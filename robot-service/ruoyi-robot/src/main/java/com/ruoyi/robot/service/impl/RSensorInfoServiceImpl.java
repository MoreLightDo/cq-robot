package com.ruoyi.robot.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.robot.api.response.SensorData;
import com.ruoyi.robot.api.response.SensorInfo;
import com.ruoyi.robot.api.service.RobotService;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.robot.mapper.RSensorInfoMapper;
import com.ruoyi.robot.domain.RSensorInfo;
import com.ruoyi.robot.service.IRSensorInfoService;

/**
 * 传感器信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-02
 */
@Service
public class RSensorInfoServiceImpl implements IRSensorInfoService
{
    @Autowired
    private RSensorInfoMapper rSensorInfoMapper;

    @Autowired
    private RobotService robotService;

    /**
     * 查询传感器信息
     *
     * @param id 传感器信息主键
     * @return 传感器信息
     */
    @Override
    public RSensorInfo selectRSensorInfoById(Long id)
    {
        return rSensorInfoMapper.selectRSensorInfoById(id);
    }

    /**
     * 查询传感器信息列表
     *
     * @param rSensorInfo 传感器信息
     * @return 传感器信息
     */
    @Override
    public List<RSensorInfo> selectRSensorInfoList(RSensorInfo rSensorInfo)
    {
        return rSensorInfoMapper.selectRSensorInfoList(rSensorInfo);
    }

    /**
     * 新增传感器信息
     *
     * @param rSensorInfo 传感器信息
     * @return 结果
     */
    @Override
    public int insertRSensorInfo(RSensorInfo rSensorInfo)
    {
        rSensorInfo.setCreateTime(DateUtils.getNowDate());
        return rSensorInfoMapper.insertRSensorInfo(rSensorInfo);
    }

    @Override
    public int insertRSensorInfos(List<RSensorInfo> rSensorInfos) {
        return rSensorInfoMapper.insertRSensorInfos(rSensorInfos);
    }

    /**
     * 修改传感器信息
     *
     * @param rSensorInfo 传感器信息
     * @return 结果
     */
    @Override
    public int updateRSensorInfo(RSensorInfo rSensorInfo)
    {
        rSensorInfo.setUpdateTime(DateUtils.getNowDate());
        return rSensorInfoMapper.updateRSensorInfo(rSensorInfo);
    }

    /**
     * 批量删除传感器信息
     *
     * @param ids 需要删除的传感器信息主键
     * @return 结果
     */
    @Override
    public int deleteRSensorInfoByIds(Long[] ids)
    {
        return rSensorInfoMapper.deleteRSensorInfoByIds(ids);
    }

    /**
     * 删除传感器信息信息
     *
     * @param id 传感器信息主键
     * @return 结果
     */
    @Override
    public int deleteRSensorInfoById(Long id)
    {
        return rSensorInfoMapper.deleteRSensorInfoById(id);
    }
}
