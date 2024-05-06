package com.ruoyi.robot.service;

import java.util.List;
import com.ruoyi.robot.domain.RSensorAlarmLog;

/**
 * 传感器预警日志Service接口
 * 
 * @author ruoyi
 * @date 2023-03-16
 */
public interface IRSensorAlarmLogService 
{
    /**
     * 查询传感器预警日志
     * 
     * @param id 传感器预警日志主键
     * @return 传感器预警日志
     */
    public RSensorAlarmLog selectRSensorAlarmLogById(Long id);

    /**
     * 查询传感器预警日志列表
     * 
     * @param rSensorAlarmLog 传感器预警日志
     * @return 传感器预警日志集合
     */
    public List<RSensorAlarmLog> selectRSensorAlarmLogList(RSensorAlarmLog rSensorAlarmLog);

    /**
     * 新增传感器预警日志
     * 
     * @param rSensorAlarmLog 传感器预警日志
     * @return 结果
     */
    public int insertRSensorAlarmLog(RSensorAlarmLog rSensorAlarmLog);

    /**
     * 修改传感器预警日志
     * 
     * @param rSensorAlarmLog 传感器预警日志
     * @return 结果
     */
    public int updateRSensorAlarmLog(RSensorAlarmLog rSensorAlarmLog);

    /**
     * 批量删除传感器预警日志
     * 
     * @param ids 需要删除的传感器预警日志主键集合
     * @return 结果
     */
    public int deleteRSensorAlarmLogByIds(Long[] ids);

    /**
     * 删除传感器预警日志信息
     * 
     * @param id 传感器预警日志主键
     * @return 结果
     */
    public int deleteRSensorAlarmLogById(Long id);
}
