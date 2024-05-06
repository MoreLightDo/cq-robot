package com.ruoyi.robot.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.robot.mapper.RSensorAlarmRuleMapper;
import com.ruoyi.robot.domain.RSensorAlarmRule;
import com.ruoyi.robot.service.IRSensorAlarmRuleService;

/**
 * 传感器预警设置Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-16
 */
@Service
public class RSensorAlarmRuleServiceImpl implements IRSensorAlarmRuleService 
{
    @Autowired
    private RSensorAlarmRuleMapper rSensorAlarmRuleMapper;

    /**
     * 查询传感器预警设置
     * 
     * @param id 传感器预警设置主键
     * @return 传感器预警设置
     */
    @Override
    public RSensorAlarmRule selectRSensorAlarmRuleById(Long id)
    {
        return rSensorAlarmRuleMapper.selectRSensorAlarmRuleById(id);
    }

    /**
     * 查询传感器预警设置列表
     * 
     * @param rSensorAlarmRule 传感器预警设置
     * @return 传感器预警设置
     */
    @Override
    public List<RSensorAlarmRule> selectRSensorAlarmRuleList(RSensorAlarmRule rSensorAlarmRule)
    {
        return rSensorAlarmRuleMapper.selectRSensorAlarmRuleList(rSensorAlarmRule);
    }

    /**
     * 新增传感器预警设置
     * 
     * @param rSensorAlarmRule 传感器预警设置
     * @return 结果
     */
    @Override
    public int insertRSensorAlarmRule(RSensorAlarmRule rSensorAlarmRule)
    {
        rSensorAlarmRule.setCreateTime(DateUtils.getNowDate());
        return rSensorAlarmRuleMapper.insertRSensorAlarmRule(rSensorAlarmRule);
    }

    /**
     * 修改传感器预警设置
     * 
     * @param rSensorAlarmRule 传感器预警设置
     * @return 结果
     */
    @Override
    public int updateRSensorAlarmRule(RSensorAlarmRule rSensorAlarmRule)
    {
        rSensorAlarmRule.setUpdateTime(DateUtils.getNowDate());
        return rSensorAlarmRuleMapper.updateRSensorAlarmRule(rSensorAlarmRule);
    }

    /**
     * 批量删除传感器预警设置
     * 
     * @param ids 需要删除的传感器预警设置主键
     * @return 结果
     */
    @Override
    public int deleteRSensorAlarmRuleByIds(Long[] ids)
    {
        return rSensorAlarmRuleMapper.deleteRSensorAlarmRuleByIds(ids);
    }

    /**
     * 删除传感器预警设置信息
     * 
     * @param id 传感器预警设置主键
     * @return 结果
     */
    @Override
    public int deleteRSensorAlarmRuleById(Long id)
    {
        return rSensorAlarmRuleMapper.deleteRSensorAlarmRuleById(id);
    }
}
