package com.ruoyi.robot.mapper;

import java.util.List;
import com.ruoyi.robot.domain.RRobotLocation;

/**
 * 定位Mapper接口
 *
 * @author ruoyi
 * @date 2023-03-02
 */
public interface RRobotLocationMapper
{
    /**
     * 查询定位
     *
     * @param id 定位主键
     * @return 定位
     */
    public RRobotLocation selectRRobotLocationById(Long id);

    public RRobotLocation selectNewStRRobotLocationByRobotId(Long id);

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
     * 删除定位
     *
     * @param id 定位主键
     * @return 结果
     */
    public int deleteRRobotLocationById(Long id);

    /**
     * 批量删除定位
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRRobotLocationByIds(Long[] ids);
}
