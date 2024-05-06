package com.ruoyi.robot.service.impl;

import java.math.BigDecimal;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.robot.api.response.ArmInfo;
import com.ruoyi.robot.api.service.RobotService;
import com.ruoyi.robot.domain.RRobot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.robot.mapper.RRobotInfoMapper;
import com.ruoyi.robot.domain.RRobotInfo;
import com.ruoyi.robot.service.IRRobotInfoService;

/**
 * 机器人信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-02
 */
@Service
public class RRobotInfoServiceImpl implements IRRobotInfoService
{
    @Autowired
    private RRobotInfoMapper rRobotInfoMapper;

    @Autowired
    private RobotService robotService;

    /**
     * 查询机器人信息
     *
     * @param id 机器人信息主键
     * @return 机器人信息
     */
    @Override
    public RRobotInfo selectRRobotInfoById(Long id)
    {
        return rRobotInfoMapper.selectRRobotInfoById(id);
    }

    /**
     * 查询机器人信息列表
     *
     * @param rRobotInfo 机器人信息
     * @return 机器人信息
     */
    @Override
    public List<RRobotInfo> selectRRobotInfoList(RRobotInfo rRobotInfo)
    {
        return rRobotInfoMapper.selectRRobotInfoList(rRobotInfo);
    }

    public void importRRobotInfoFormAgv() {
        ArmInfo armInfo = robotService.getArmInfo();
        RRobotInfo rRobotInfo = new RRobotInfo();
        rRobotInfo.setOnline(armInfo.getOnline() ? 1 : 0);
        rRobotInfo.setR1Current(BigDecimal.valueOf(armInfo.getR1_current()));
        rRobotInfo.setR2Current(BigDecimal.valueOf(armInfo.getR2_current()));
        rRobotInfo.setR3Current(BigDecimal.valueOf(armInfo.getR3_current()));
        rRobotInfo.setR4Current(BigDecimal.valueOf(armInfo.getR4_current()));
        rRobotInfo.setR5Current(BigDecimal.valueOf(armInfo.getR5_current()));
        rRobotInfo.setR6Current(BigDecimal.valueOf(armInfo.getR6_current()));
        rRobotInfo.setR1Voltage(BigDecimal.valueOf(armInfo.getR1_voltage()));
        rRobotInfo.setR2Voltage(BigDecimal.valueOf(armInfo.getR2_voltage()));
        rRobotInfo.setR3Voltage(BigDecimal.valueOf(armInfo.getR3_voltage()));
        rRobotInfo.setR4Voltage(BigDecimal.valueOf(armInfo.getR4_voltage()));
        rRobotInfo.setR5Voltage(BigDecimal.valueOf(armInfo.getR5_voltage()));
        rRobotInfo.setR6Voltage(BigDecimal.valueOf(armInfo.getR6_voltage()));
        List<RRobotInfo> infos = rRobotInfoMapper.selectRRobotInfoList(new RRobotInfo());
        if (infos.isEmpty()){
            rRobotInfoMapper.insertRRobotInfo(rRobotInfo);
        }else {
            rRobotInfo.setId(infos.get(0).getId());
            rRobotInfoMapper.updateRRobotInfo(rRobotInfo);
        }
    }

    /**
     * 新增机器人信息
     *
     * @param rRobotInfo 机器人信息
     * @return 结果
     */
    @Override
    public int insertRRobotInfo(RRobotInfo rRobotInfo)
    {
        rRobotInfo.setCreateTime(DateUtils.getNowDate());
        return rRobotInfoMapper.insertRRobotInfo(rRobotInfo);
    }

    /**
     * 修改机器人信息
     *
     * @param rRobotInfo 机器人信息
     * @return 结果
     */
    @Override
    public int updateRRobotInfo(RRobotInfo rRobotInfo)
    {
        rRobotInfo.setUpdateTime(DateUtils.getNowDate());
        return rRobotInfoMapper.updateRRobotInfo(rRobotInfo);
    }

    /**
     * 批量删除机器人信息
     *
     * @param ids 需要删除的机器人信息主键
     * @return 结果
     */
    @Override
    public int deleteRRobotInfoByIds(Long[] ids)
    {
        return rRobotInfoMapper.deleteRRobotInfoByIds(ids);
    }

    /**
     * 删除机器人信息信息
     *
     * @param id 机器人信息主键
     * @return 结果
     */
    @Override
    public int deleteRRobotInfoById(Long id)
    {
        return rRobotInfoMapper.deleteRRobotInfoById(id);
    }
}
