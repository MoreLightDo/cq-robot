package com.ruoyi.robot.service.impl;

import java.math.BigDecimal;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.robot.api.response.*;
import com.ruoyi.robot.api.service.RobotService;
import com.ruoyi.robot.domain.*;
import com.ruoyi.robot.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.robot.service.IRRobotService;

/**
 * 机器人信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-02
 */
@Service
public class RRobotServiceImpl implements IRRobotService
{
    @Autowired
    private RRobotMapper rRobotMapper;

    @Autowired
    private RRobotBatteryMapper batteryMapper;

    @Autowired
    private RRobotLocationMapper locationMapper;

    @Autowired
    private RRobotEmcyMapper emyMapper;

    @Autowired
    private RRobotStateMapper stateMapper;

    @Autowired
    private RRobotTaskMapper taskMapper;

    @Autowired
    private RobotService robotService;

    /**
     * 查询机器人信息
     *
     * @param id 机器人信息主键
     * @return 机器人信息
     */
    @Override
    public RRobot selectRRobotById(Long id)
    {
        return rRobotMapper.selectRRobotById(id);
    }

    /**
     * 查询机器人信息列表
     *
     * @param rRobot 机器人信息
     * @return 机器人信息
     */
    @Override
    public RRobot selectCurrentRRobot(RRobot rRobot)
    {
        List<RRobot> rRobots = rRobotMapper.selectRRobotList(rRobot);
        if (rRobots.isEmpty()){
            return null;
        }
        RRobot robot = rRobots.get(0);
        Long id = robot.getId();
        robot.setBattery(batteryMapper.selectNewStrRobotBatteryByRobotId(id));
        robot.setLocation(locationMapper.selectNewStRRobotLocationByRobotId(id));
        robot.setEmcy(emyMapper.selectNewstRRobotEmcyByRobotId(id));
        robot.setState(stateMapper.selectNewstRRobotStateByRobotId(id));
        robot.setTask(taskMapper.selectNewestRRobotTaskById(id));
        return rRobot;
    }

    @Override
    public void importRobotInfoFromAgv() {
        AGVInfoResponse agvInfo = robotService.getAGVInfo();
        RRobot robot = transAgvToRobot(agvInfo);
        List<RRobot> rRobots = rRobotMapper.selectRRobotList(new RRobot() {{
            setRobotId(agvInfo.getRobot_id());
        }});
        Long id;
        if (rRobots.isEmpty()){
            rRobotMapper.insertRRobot(robot);
            id = robot.getId();
        }else {
            id = rRobots.get(0).getId();
            robot.setId(id);
            rRobotMapper.updateRRobot(robot);
        }
        Long finalId = id;
        List<RRobotBattery> batteries = batteryMapper.selectRRobotBatteryList(new RRobotBattery() {{
            setRobotId(finalId);
        }});
        List<RRobotLocation> locations = locationMapper.selectRRobotLocationList(new RRobotLocation() {{
            setRobotId(finalId);
        }});
        List<RRobotState> states = stateMapper.selectRRobotStateList(new RRobotState() {{
            setRobotId(finalId);
        }});
        List<RRobotEmcy> emcies = emyMapper.selectRRobotEmcyList(new RRobotEmcy() {{
            setRobotId(finalId);
        }});
        List<RRobotTask> tasks = taskMapper.selectRRobotTaskList(new RRobotTask() {{
            setRobotId(finalId);
        }});
        RRobotBattery battery = robot.getBattery();
        battery.setRobotId(id);
        if (batteries.isEmpty()){
            batteryMapper.insertRRobotBattery(battery);
        }else {
            battery.setId(batteries.get(0).getId());
            batteryMapper.updateRRobotBattery(battery);
        }
        RRobotState state = robot.getState();
        state.setRobotId(id);
        if (states.isEmpty()){
            stateMapper.insertRRobotState(state);
        }else {
            state.setId(states.get(0).getId());
            stateMapper.updateRRobotState(state);
        }
        RRobotEmcy emcy = robot.getEmcy();
        emcy.setRobotId(id);
        if (emcies.isEmpty()){
            emyMapper.insertRRobotEmcy(emcy);
        }else {
            emcy.setId(emcies.get(0).getId());
            emyMapper.updateRRobotEmcy(emcy);
        }
        RRobotLocation location = robot.getLocation();
        location.setRobotId(id);
        if (locations.isEmpty()){
            locationMapper.insertRRobotLocation(location);
        }else {
            location.setId(locations.get(0).getId());
            locationMapper.updateRRobotLocation(location);
        }
        RRobotTask task = robot.getTask();
        task.setRobotId(id);
        if (tasks.isEmpty()){
            taskMapper.insertRRobotTask(task);
        }else {
            task.setId(tasks.get(0).getId());
            taskMapper.updateRRobotTask(task);
        }
    }

    public RRobot transAgvToRobot(AGVInfoResponse agvInfo){
        RRobot robot = new RRobot() {{
            setRobotId(agvInfo.getRobot_id());
            setName(agvInfo.getName());
            setType(agvInfo.getType());
            setModel(agvInfo.getModel());
        }};
        RobotStateInfo stateInfo = agvInfo.getState();
        RRobotState state = new RRobotState();
        state.setName(stateInfo.getName());
        state.setCharging(stateInfo.getCharging() ? 1 : 0);
        state.setEmcyed(stateInfo.getEmcyed() ? 1 : 0);
        state.setMapping(stateInfo.getMapping() ? 1 : 0);
        state.setTasking(stateInfo.getTasking() ? 1 : 0);
        state.setFaulted(stateInfo.getFaulted() ? 1 : 0);
        state.setLocated(stateInfo.getLocated() ? 1 : 0);
        robot.setState(state);
        BatteryInfo batteryInfo = agvInfo.getBattery();
        RRobotBattery battery = new RRobotBattery();
        battery.setCharging(batteryInfo.getCharging() ? 1 : 0);
        battery.setCurrent(BigDecimal.valueOf(batteryInfo.getCurrent()));
        battery.setSoc(BigDecimal.valueOf(batteryInfo.getSoc()));
        battery.setVoltage(BigDecimal.valueOf(batteryInfo.getVoltage()));
        robot.setBattery(battery);
        RRobotEmcy emcy = new RRobotEmcy();
        EmcyInfo emcyInfo = agvInfo.getEmcy();
        emcy.setEmcyed(emcyInfo.getEmcyed() ? 1 : 0);
        emcy.setHardware(emcyInfo.getHardware() ? 1 : 0);
        emcy.setSoftware(emcyInfo.getSoftware() ? 1 : 0);
        robot.setEmcy(emcy);
        RRobotLocation location = new RRobotLocation();
        LocationInfo locationInfo = agvInfo.getLocation();
        location.setLocated(locationInfo.getLocated() ? 1 : 0);
        location.setMapId(locationInfo.getMap_id());
        location.setX(BigDecimal.valueOf(locationInfo.getX()));
        location.setY(BigDecimal.valueOf(locationInfo.getY()));
        location.setYaw(BigDecimal.valueOf(locationInfo.getYaw()));
        robot.setLocation(location);
        RRobotTask task = new RRobotTask();
        TaskInfo taskInfo = agvInfo.getTask();
        task.setTaskId(taskInfo.getTask_id());
        task.setTasking(taskInfo.getTasking() ? 1 : 0);
        task.setName(taskInfo.getName());
        task.setTs(taskInfo.getTs());
        task.setState(taskInfo.getState());
        task.setProgress(BigDecimal.valueOf(taskInfo.getProgress()));
        robot.setTask(task);
        return robot;
    }

    /**
     * 新增机器人信息
     *
     * @param rRobot 机器人信息
     * @return 结果
     */
    @Override
    public int insertRRobot(RRobot rRobot)
    {
        rRobot.setCreateTime(DateUtils.getNowDate());
        return rRobotMapper.insertRRobot(rRobot);
    }

    /**
     * 修改机器人信息
     *
     * @param rRobot 机器人信息
     * @return 结果
     */
    @Override
    public int updateRRobot(RRobot rRobot)
    {
        rRobot.setUpdateTime(DateUtils.getNowDate());
        return rRobotMapper.updateRRobot(rRobot);
    }

    /**
     * 批量删除机器人信息
     *
     * @param ids 需要删除的机器人信息主键
     * @return 结果
     */
    @Override
    public int deleteRRobotByIds(Long[] ids)
    {
        return rRobotMapper.deleteRRobotByIds(ids);
    }

    /**
     * 删除机器人信息信息
     *
     * @param id 机器人信息主键
     * @return 结果
     */
    @Override
    public int deleteRRobotById(Long id)
    {
        return rRobotMapper.deleteRRobotById(id);
    }
}
