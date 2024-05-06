package com.ruoyi.robot.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.robot.mapper.RRobotLocationMapper;
import com.ruoyi.robot.domain.RRobotLocation;
import com.ruoyi.robot.service.IRRobotLocationService;

/**
 * 定位Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-02
 */
@Service
public class RRobotLocationServiceImpl implements IRRobotLocationService 
{
    @Autowired
    private RRobotLocationMapper rRobotLocationMapper;

    /**
     * 查询定位
     * 
     * @param id 定位主键
     * @return 定位
     */
    @Override
    public RRobotLocation selectRRobotLocationById(Long id)
    {
        return rRobotLocationMapper.selectRRobotLocationById(id);
    }

    /**
     * 查询定位列表
     * 
     * @param rRobotLocation 定位
     * @return 定位
     */
    @Override
    public List<RRobotLocation> selectRRobotLocationList(RRobotLocation rRobotLocation)
    {
        return rRobotLocationMapper.selectRRobotLocationList(rRobotLocation);
    }

    /**
     * 新增定位
     * 
     * @param rRobotLocation 定位
     * @return 结果
     */
    @Override
    public int insertRRobotLocation(RRobotLocation rRobotLocation)
    {
        rRobotLocation.setCreateTime(DateUtils.getNowDate());
        return rRobotLocationMapper.insertRRobotLocation(rRobotLocation);
    }

    /**
     * 修改定位
     * 
     * @param rRobotLocation 定位
     * @return 结果
     */
    @Override
    public int updateRRobotLocation(RRobotLocation rRobotLocation)
    {
        rRobotLocation.setUpdateTime(DateUtils.getNowDate());
        return rRobotLocationMapper.updateRRobotLocation(rRobotLocation);
    }

    /**
     * 批量删除定位
     * 
     * @param ids 需要删除的定位主键
     * @return 结果
     */
    @Override
    public int deleteRRobotLocationByIds(Long[] ids)
    {
        return rRobotLocationMapper.deleteRRobotLocationByIds(ids);
    }

    /**
     * 删除定位信息
     * 
     * @param id 定位主键
     * @return 结果
     */
    @Override
    public int deleteRRobotLocationById(Long id)
    {
        return rRobotLocationMapper.deleteRRobotLocationById(id);
    }
}
