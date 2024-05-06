package com.ruoyi.robot.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.robot.mapper.RRobotBatteryMapper;
import com.ruoyi.robot.domain.RRobotBattery;
import com.ruoyi.robot.service.IRRobotBatteryService;

/**
 * 电池Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-02
 */
@Service
public class RRobotBatteryServiceImpl implements IRRobotBatteryService 
{
    @Autowired
    private RRobotBatteryMapper rRobotBatteryMapper;

    /**
     * 查询电池
     * 
     * @param id 电池主键
     * @return 电池
     */
    @Override
    public RRobotBattery selectRRobotBatteryById(Long id)
    {
        return rRobotBatteryMapper.selectRRobotBatteryById(id);
    }

    /**
     * 查询电池列表
     * 
     * @param rRobotBattery 电池
     * @return 电池
     */
    @Override
    public List<RRobotBattery> selectRRobotBatteryList(RRobotBattery rRobotBattery)
    {
        return rRobotBatteryMapper.selectRRobotBatteryList(rRobotBattery);
    }

    /**
     * 新增电池
     * 
     * @param rRobotBattery 电池
     * @return 结果
     */
    @Override
    public int insertRRobotBattery(RRobotBattery rRobotBattery)
    {
        rRobotBattery.setCreateTime(DateUtils.getNowDate());
        return rRobotBatteryMapper.insertRRobotBattery(rRobotBattery);
    }

    /**
     * 修改电池
     * 
     * @param rRobotBattery 电池
     * @return 结果
     */
    @Override
    public int updateRRobotBattery(RRobotBattery rRobotBattery)
    {
        rRobotBattery.setUpdateTime(DateUtils.getNowDate());
        return rRobotBatteryMapper.updateRRobotBattery(rRobotBattery);
    }

    /**
     * 批量删除电池
     * 
     * @param ids 需要删除的电池主键
     * @return 结果
     */
    @Override
    public int deleteRRobotBatteryByIds(Long[] ids)
    {
        return rRobotBatteryMapper.deleteRRobotBatteryByIds(ids);
    }

    /**
     * 删除电池信息
     * 
     * @param id 电池主键
     * @return 结果
     */
    @Override
    public int deleteRRobotBatteryById(Long id)
    {
        return rRobotBatteryMapper.deleteRRobotBatteryById(id);
    }
}
