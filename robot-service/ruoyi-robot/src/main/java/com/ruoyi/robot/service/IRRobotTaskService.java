package com.ruoyi.robot.service;

import java.util.List;
import com.ruoyi.robot.domain.RRobotTask;

/**
 * 机器人任务Service接口
 * 
 * @author ruoyi
 * @date 2023-03-02
 */
public interface IRRobotTaskService 
{
    /**
     * 查询机器人任务
     * 
     * @param id 机器人任务主键
     * @return 机器人任务
     */
    public RRobotTask selectRRobotTaskById(Long id);

    /**
     * 查询机器人任务列表
     * 
     * @param rRobotTask 机器人任务
     * @return 机器人任务集合
     */
    public List<RRobotTask> selectRRobotTaskList(RRobotTask rRobotTask);

    /**
     * 新增机器人任务
     * 
     * @param rRobotTask 机器人任务
     * @return 结果
     */
    public int insertRRobotTask(RRobotTask rRobotTask);

    /**
     * 修改机器人任务
     * 
     * @param rRobotTask 机器人任务
     * @return 结果
     */
    public int updateRRobotTask(RRobotTask rRobotTask);

    /**
     * 批量删除机器人任务
     * 
     * @param ids 需要删除的机器人任务主键集合
     * @return 结果
     */
    public int deleteRRobotTaskByIds(Long[] ids);

    /**
     * 删除机器人任务信息
     * 
     * @param id 机器人任务主键
     * @return 结果
     */
    public int deleteRRobotTaskById(Long id);
}
