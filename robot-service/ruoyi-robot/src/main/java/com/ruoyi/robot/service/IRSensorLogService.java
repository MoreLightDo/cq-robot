package com.ruoyi.robot.service;

import java.util.List;
import com.ruoyi.robot.domain.RSensorLog;

/**
 * 传感器日志Service接口
 *
 * @author ruoyi
 * @date 2023-03-16
 */
public interface IRSensorLogService
{
    /**
     * 查询传感器日志
     *
     * @param id 传感器日志主键
     * @return 传感器日志
     */
    public RSensorLog selectRSensorLogById(Long id);

    /**
     * 查询传感器日志列表
     *
     * @param rSensorLog 传感器日志
     * @return 传感器日志集合
     */
    public List<RSensorLog> selectRSensorLogList(RSensorLog rSensorLog);

    void importSensorFormAgv();

    void importSensorAlarmLogFormAgv();

    /**
     * 新增传感器日志
     *
     * @param rSensorLog 传感器日志
     * @return 结果
     */
    public int insertRSensorLog(RSensorLog rSensorLog);

    /**
     * 修改传感器日志
     *
     * @param rSensorLog 传感器日志
     * @return 结果
     */
    public int updateRSensorLog(RSensorLog rSensorLog);

    /**
     * 批量删除传感器日志
     *
     * @param ids 需要删除的传感器日志主键集合
     * @return 结果
     */
    public int deleteRSensorLogByIds(Long[] ids);

    /**
     * 删除传感器日志信息
     *
     * @param id 传感器日志主键
     * @return 结果
     */
    public int deleteRSensorLogById(Long id);
}
