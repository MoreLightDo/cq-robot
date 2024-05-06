package com.ruoyi.robot.service;

import java.util.List;
import com.ruoyi.robot.domain.RRobotCornJob;

/**
 * 机器人定时任务Service接口
 *
 * @author ruoyi
 * @date 2023-04-17
 */
public interface IRRobotCornJobService
{
    /**
     * 查询机器人定时任务
     *
     * @param id 机器人定时任务主键
     * @return 机器人定时任务
     */
    public RRobotCornJob selectRRobotCornJobById(Long id);

    /**
     * 查询机器人定时任务列表
     *
     * @param rRobotCornJob 机器人定时任务
     * @return 机器人定时任务集合
     */
    public List<RRobotCornJob> selectRRobotCornJobList(RRobotCornJob rRobotCornJob);

    /**
     * 新增机器人定时任务
     *
     * @param rRobotCornJob 机器人定时任务
     * @return 结果
     */
    public int insertRRobotCornJob(RRobotCornJob rRobotCornJob);

    /**
     * 修改机器人定时任务
     *
     * @param rRobotCornJob 机器人定时任务
     * @return 结果
     */
    public int updateRRobotCornJob(RRobotCornJob rRobotCornJob);

    /**
     * 批量删除机器人定时任务
     *
     * @param ids 需要删除的机器人定时任务主键集合
     * @return 结果
     */
    public int deleteRRobotCornJobByIds(Long[] ids);

    /**
     * 删除机器人定时任务信息
     *
     * @param id 机器人定时任务主键
     * @return 结果
     */
    public int deleteRRobotCornJobById(Long id);
}
