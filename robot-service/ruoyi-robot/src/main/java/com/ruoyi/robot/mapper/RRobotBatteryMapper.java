package com.ruoyi.robot.mapper;

import java.util.List;
import com.ruoyi.robot.domain.RRobotBattery;

/**
 * 电池Mapper接口
 *
 * @author ruoyi
 * @date 2023-03-02
 */
public interface RRobotBatteryMapper
{
    /**
     * 查询电池
     *
     * @param id 电池主键
     * @return 电池
     */
    public RRobotBattery selectRRobotBatteryById(Long id);

    public RRobotBattery selectNewStrRobotBatteryByRobotId(Long id);

    /**
     * 查询电池列表
     *
     * @param rRobotBattery 电池
     * @return 电池集合
     */
    public List<RRobotBattery> selectRRobotBatteryList(RRobotBattery rRobotBattery);

    /**
     * 新增电池
     *
     * @param rRobotBattery 电池
     * @return 结果
     */
    public int insertRRobotBattery(RRobotBattery rRobotBattery);

    /**
     * 修改电池
     *
     * @param rRobotBattery 电池
     * @return 结果
     */
    public int updateRRobotBattery(RRobotBattery rRobotBattery);

    /**
     * 删除电池
     *
     * @param id 电池主键
     * @return 结果
     */
    public int deleteRRobotBatteryById(Long id);

    /**
     * 批量删除电池
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRRobotBatteryByIds(Long[] ids);
}
