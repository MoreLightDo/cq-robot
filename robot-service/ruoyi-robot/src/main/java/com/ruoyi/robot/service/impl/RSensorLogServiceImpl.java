package com.ruoyi.robot.service.impl;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.websocket.WebSocketUsers;
import com.ruoyi.robot.api.response.SensorInfo;
import com.ruoyi.robot.api.service.RobotService;
import com.ruoyi.robot.domain.RSensorAlarmLog;
import com.ruoyi.robot.domain.RSensorAlarmRule;
import com.ruoyi.robot.domain.RSensorInfo;
import com.ruoyi.robot.mapper.RSensorAlarmLogMapper;
import com.ruoyi.robot.mapper.RSensorAlarmRuleMapper;
import com.ruoyi.robot.mapper.RSensorInfoMapper;
import com.ruoyi.robot.service.IRSensorAlarmLogService;
import com.ruoyi.robot.service.IRSensorAlarmRuleService;
import com.ruoyi.robot.service.IRSensorInfoService;
import com.ruoyi.robot.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.robot.mapper.RSensorLogMapper;
import com.ruoyi.robot.domain.RSensorLog;
import com.ruoyi.robot.service.IRSensorLogService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 传感器日志Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-16
 */
@Service
public class RSensorLogServiceImpl implements IRSensorLogService
{

    @Autowired
    private RobotService robotService;

    @Autowired
    private RSensorLogMapper rSensorLogMapper;

    @Autowired
    private IRSensorInfoService sensorInfoService;

    @Autowired
    private IRSensorAlarmLogService sensorAlarmLogService;

    @Autowired
    private IRSensorAlarmRuleService sensorAlarmRuleService;

    /**
     * 查询传感器日志
     *
     * @param id 传感器日志主键
     * @return 传感器日志
     */
    @Override
    public RSensorLog selectRSensorLogById(Long id)
    {
        return rSensorLogMapper.selectRSensorLogById(id);
    }

    /**
     * 查询传感器日志列表
     *
     * @param rSensorLog 传感器日志
     * @return 传感器日志
     */
    @Override
    public List<RSensorLog> selectRSensorLogList(RSensorLog rSensorLog)
    {
        return rSensorLogMapper.selectRSensorLogList(rSensorLog);
    }

    @Override
    @Transactional
    public void importSensorAlarmLogFormAgv() {
        SensorInfo info = robotService.getSensorInfo();
        List<RSensorAlarmRule> rules = sensorAlarmRuleService.selectRSensorAlarmRuleList(new RSensorAlarmRule());
        List<RSensorInfo> infos = transAgvSensorToSensor(info);
        infos.stream().map(it->{
            AtomicReference<RSensorAlarmRule> maxRule = new AtomicReference<>();
            rules.stream().filter(r -> r.getType().equals(it.getType())).forEach(r -> {
                int compare = Objects.equals(r.getStatus(), "-1") ? -1 : 1;
                if (r.getAlarmValue().compareTo(it.getValue()) == compare) {
                    if (maxRule.get() == null || maxRule.get().getAlarmLevel() < r.getAlarmLevel())
                        maxRule.set(r);
                }
            });
            RSensorAlarmLog alarmLog;
            if (maxRule.get() != null){
                alarmLog = RSensorAlarmLog.builder()
                        .alarmValue(it.getValue())
                        .ruleId(maxRule.get().getId())
                        .message(maxRule.get().getLabel()+ " 超过阈值")
                        .triggerTime(new Date())
                        .alarmJson(JSON.toJSONString(it))
                        .rule(maxRule.get())
                    .build();
            }else {
                alarmLog = RSensorAlarmLog.builder()
                        .id(0L)
                        .build();
            }
            return alarmLog;
        }).forEach(it->{
            if (it.getId()==null){
                sensorAlarmLogService.insertRSensorAlarmLog(it);
                sendMsg(it);
            }
        });
    }

    public void sendMsg(RSensorAlarmLog log){
        WebSocketUsers.sendMessageToUsersByText(log.getMessage());
    }

    public void importSensorFormAgv() {
        SensorInfo info = robotService.getSensorInfo();
        List<RSensorInfo> infos = transAgvSensorToSensor(info);
        RSensorLog log = RSensorLog.builder()
                .name(DateUtils.dateTimeNow() + " 传感器信息")
                .build();
        insertRSensorLog(log);
        infos = infos.stream().peek(it->it.setLogId(Math.toIntExact(log.getId()))).collect(Collectors.toList());
        sensorInfoService.insertRSensorInfos(infos);
    }

    public List<RSensorInfo> transAgvSensorToSensor(SensorInfo info){
        List<RSensorInfo> rSensorInfos = new ArrayList<>();
        rSensorInfos.add(RSensorInfo.builder()
                        .type(Constants.CH4)
                        .value(BigDecimal.valueOf(info.getCh4().getValue()))
                        .isOnline(info.getCh4().getOnline() ? 1 : 0)
                .build());
        rSensorInfos.add(RSensorInfo.builder()
                .type(Constants.CO)
                .value(BigDecimal.valueOf(info.getCo().getValue()))
                .isOnline(info.getCo().getOnline() ? 1 : 0)
                .build());
        rSensorInfos.add(RSensorInfo.builder()
                .type(Constants.H2)
                .value(BigDecimal.valueOf(info.getH2().getValue()))
                .isOnline(info.getH2().getOnline() ? 1 : 0)
                .build());
        rSensorInfos.add(RSensorInfo.builder()
                .type(Constants.H2S)
                .value(BigDecimal.valueOf(info.getH2s().getValue()))
                .isOnline(info.getH2s().getOnline() ? 1 : 0)
                .build());
        rSensorInfos.add(RSensorInfo.builder()
                .type(Constants.HUMI)
                .value(BigDecimal.valueOf(info.getHumi().getValue()))
                .isOnline(info.getHumi().getOnline() ? 1 : 0)
                .build());
        rSensorInfos.add(RSensorInfo.builder()
                .type(Constants.NOISE)
                .value(BigDecimal.valueOf(info.getNoise().getValue()))
                .isOnline(info.getNoise().getOnline() ? 1 : 0)
                .build());
        rSensorInfos.add(RSensorInfo.builder()
                .type(Constants.SMOKE)
                .value(BigDecimal.valueOf(info.getSmoke().getValue()))
                .isOnline(info.getSmoke().getOnline() ? 1 : 0)
                .build());
        rSensorInfos.add(RSensorInfo.builder()
                .type(Constants.TEMP)
                .value(BigDecimal.valueOf(info.getTemp().getValue()))
                .isOnline(info.getTemp().getOnline() ? 1 : 0)
                .build());
        return rSensorInfos;
    }

    /**
     * 新增传感器日志
     *
     * @param rSensorLog 传感器日志
     * @return 结果
     */
    @Override
    public int insertRSensorLog(RSensorLog rSensorLog)
    {
        rSensorLog.setCreateTime(DateUtils.getNowDate());
        return rSensorLogMapper.insertRSensorLog(rSensorLog);
    }

    /**
     * 修改传感器日志
     *
     * @param rSensorLog 传感器日志
     * @return 结果
     */
    @Override
    public int updateRSensorLog(RSensorLog rSensorLog)
    {
        rSensorLog.setUpdateTime(DateUtils.getNowDate());
        return rSensorLogMapper.updateRSensorLog(rSensorLog);
    }

    /**
     * 批量删除传感器日志
     *
     * @param ids 需要删除的传感器日志主键
     * @return 结果
     */
    @Override
    public int deleteRSensorLogByIds(Long[] ids)
    {
        return rSensorLogMapper.deleteRSensorLogByIds(ids);
    }

    /**
     * 删除传感器日志信息
     *
     * @param id 传感器日志主键
     * @return 结果
     */
    @Override
    public int deleteRSensorLogById(Long id)
    {
        return rSensorLogMapper.deleteRSensorLogById(id);
    }
}
