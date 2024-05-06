package com.ruoyi.robot.service;

import java.util.List;
import com.ruoyi.robot.domain.RRobot;

/**
 * 机器人信息Service接口
 *
 * @author ruoyi
 * @date 2023-03-02
 */
public interface IRRobotService
{
    /**
     * 查询机器人信息
     *
     * @param id 机器人信息主键
     * @return 机器人信息
     */
    public RRobot selectRRobotById(Long id);

    /**
     * 查询机器人信息列表
     *
     * @param rRobot 机器人信息
     * @return 机器人信息集合
     */
    public RRobot selectCurrentRRobot(RRobot rRobot);

    public void importRobotInfoFromAgv();

    /**
     * 新增机器人信息
     *
     * @param rRobot 机器人信息
     * @return 结果
     */
    public int insertRRobot(RRobot rRobot);

    /**
     * 修改机器人信息
     *
     * @param rRobot 机器人信息
     * @return 结果
     */
    public int updateRRobot(RRobot rRobot);

    /**
     * 批量删除机器人信息
     *
     * @param ids 需要删除的机器人信息主键集合
     * @return 结果
     */
    public int deleteRRobotByIds(Long[] ids);

    /**
     * 删除机器人信息信息
     *
     * @param id 机器人信息主键
     * @return 结果
     */
    public int deleteRRobotById(Long id);
}
