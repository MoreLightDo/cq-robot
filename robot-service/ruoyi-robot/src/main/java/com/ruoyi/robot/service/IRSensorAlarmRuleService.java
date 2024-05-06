package com.ruoyi.robot.service;

import java.util.List;
import com.ruoyi.robot.domain.RSensorAlarmRule;

/**
 * 传感器预警设置Service接口
 * 
 * @author ruoyi
 * @date 2023-03-16
 */
public interface IRSensorAlarmRuleService 
{
    /**
     * 查询传感器预警设置
     * 
     * @param id 传感器预警设置主键
     * @return 传感器预警设置
     */
    public RSensorAlarmRule selectRSensorAlarmRuleById(Long id);

    /**
     * 查询传感器预警设置列表
     * 
     * @param rSensorAlarmRule 传感器预警设置
     * @return 传感器预警设置集合
     */
    public List<RSensorAlarmRule> selectRSensorAlarmRuleList(RSensorAlarmRule rSensorAlarmRule);

    /**
     * 新增传感器预警设置
     * 
     * @param rSensorAlarmRule 传感器预警设置
     * @return 结果
     */
    public int insertRSensorAlarmRule(RSensorAlarmRule rSensorAlarmRule);

    /**
     * 修改传感器预警设置
     * 
     * @param rSensorAlarmRule 传感器预警设置
     * @return 结果
     */
    public int updateRSensorAlarmRule(RSensorAlarmRule rSensorAlarmRule);

    /**
     * 批量删除传感器预警设置
     * 
     * @param ids 需要删除的传感器预警设置主键集合
     * @return 结果
     */
    public int deleteRSensorAlarmRuleByIds(Long[] ids);

    /**
     * 删除传感器预警设置信息
     * 
     * @param id 传感器预警设置主键
     * @return 结果
     */
    public int deleteRSensorAlarmRuleById(Long id);
}
