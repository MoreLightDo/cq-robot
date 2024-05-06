package com.ruoyi.robot.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.robot.mapper.RSensorAlarmLogMapper;
import com.ruoyi.robot.domain.RSensorAlarmLog;
import com.ruoyi.robot.service.IRSensorAlarmLogService;

/**
 * 传感器预警日志Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-16
 */
@Service
public class RSensorAlarmLogServiceImpl implements IRSensorAlarmLogService 
{
    @Autowired
    private RSensorAlarmLogMapper rSensorAlarmLogMapper;

    /**
     * 查询传感器预警日志
     * 
     * @param id 传感器预警日志主键
     * @return 传感器预警日志
     */
    @Override
    public RSensorAlarmLog selectRSensorAlarmLogById(Long id)
    {
        return rSensorAlarmLogMapper.selectRSensorAlarmLogById(id);
    }

    /**
     * 查询传感器预警日志列表
     * 
     * @param rSensorAlarmLog 传感器预警日志
     * @return 传感器预警日志
     */
    @Override
    public List<RSensorAlarmLog> selectRSensorAlarmLogList(RSensorAlarmLog rSensorAlarmLog)
    {
        return rSensorAlarmLogMapper.selectRSensorAlarmLogList(rSensorAlarmLog);
    }

    /**
     * 新增传感器预警日志
     * 
     * @param rSensorAlarmLog 传感器预警日志
     * @return 结果
     */
    @Override
    public int insertRSensorAlarmLog(RSensorAlarmLog rSensorAlarmLog)
    {
        rSensorAlarmLog.setCreateTime(DateUtils.getNowDate());
        return rSensorAlarmLogMapper.insertRSensorAlarmLog(rSensorAlarmLog);
    }

    /**
     * 修改传感器预警日志
     * 
     * @param rSensorAlarmLog 传感器预警日志
     * @return 结果
     */
    @Override
    public int updateRSensorAlarmLog(RSensorAlarmLog rSensorAlarmLog)
    {
        rSensorAlarmLog.setUpdateTime(DateUtils.getNowDate());
        return rSensorAlarmLogMapper.updateRSensorAlarmLog(rSensorAlarmLog);
    }

    /**
     * 批量删除传感器预警日志
     * 
     * @param ids 需要删除的传感器预警日志主键
     * @return 结果
     */
    @Override
    public int deleteRSensorAlarmLogByIds(Long[] ids)
    {
        return rSensorAlarmLogMapper.deleteRSensorAlarmLogByIds(ids);
    }

    /**
     * 删除传感器预警日志信息
     * 
     * @param id 传感器预警日志主键
     * @return 结果
     */
    @Override
    public int deleteRSensorAlarmLogById(Long id)
    {
        return rSensorAlarmLogMapper.deleteRSensorAlarmLogById(id);
    }
}
