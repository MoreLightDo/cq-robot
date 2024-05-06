package com.ruoyi.robot.service;

import java.util.List;
import com.ruoyi.robot.domain.RRobotLocation;

/**
 * 定位Service接口
 * 
 * @author ruoyi
 * @date 2023-03-02
 */
public interface IRRobotLocationService 
{
    /**
     * 查询定位
     * 
     * @param id 定位主键
     * @return 定位
     */
    public RRobotLocation selectRRobotLocationById(Long id);

    /**
     * 查询定位列表
     * 
     * @param rRobotLocation 定位
     * @return 定位集合
     */
    public List<RRobotLocation> selectRRobotLocationList(RRobotLocation rRobotLocation);

    /**
     * 新增定位
     * 
     * @param rRobotLocation 定位
     * @return 结果
     */
    public int insertRRobotLocation(RRobotLocation rRobotLocation);

    /**
     * 修改定位
     * 
     * @param rRobotLocation 定位
     * @return 结果
     */
    public int updateRRobotLocation(RRobotLocation rRobotLocation);

    /**
     * 批量删除定位
     * 
     * @param ids 需要删除的定位主键集合
     * @return 结果
     */
    public int deleteRRobotLocationByIds(Long[] ids);

    /**
     * 删除定位信息
     * 
     * @param id 定位主键
     * @return 结果
     */
    public int deleteRRobotLocationById(Long id);
}
