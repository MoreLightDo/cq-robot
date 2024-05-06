package com.ruoyi.robot.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.robot.mapper.RRobotTaskMapper;
import com.ruoyi.robot.domain.RRobotTask;
import com.ruoyi.robot.service.IRRobotTaskService;

/**
 * 机器人任务Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-02
 */
@Service
public class RRobotTaskServiceImpl implements IRRobotTaskService 
{
    @Autowired
    private RRobotTaskMapper rRobotTaskMapper;

    /**
     * 查询机器人任务
     * 
     * @param id 机器人任务主键
     * @return 机器人任务
     */
    @Override
    public RRobotTask selectRRobotTaskById(Long id)
    {
        return rRobotTaskMapper.selectRRobotTaskById(id);
    }

    /**
     * 查询机器人任务列表
     * 
     * @param rRobotTask 机器人任务
     * @return 机器人任务
     */
    @Override
    public List<RRobotTask> selectRRobotTaskList(RRobotTask rRobotTask)
    {
        return rRobotTaskMapper.selectRRobotTaskList(rRobotTask);
    }

    /**
     * 新增机器人任务
     * 
     * @param rRobotTask 机器人任务
     * @return 结果
     */
    @Override
    public int insertRRobotTask(RRobotTask rRobotTask)
    {
        rRobotTask.setCreateTime(DateUtils.getNowDate());
        return rRobotTaskMapper.insertRRobotTask(rRobotTask);
    }

    /**
     * 修改机器人任务
     * 
     * @param rRobotTask 机器人任务
     * @return 结果
     */
    @Override
    public int updateRRobotTask(RRobotTask rRobotTask)
    {
        rRobotTask.setUpdateTime(DateUtils.getNowDate());
        return rRobotTaskMapper.updateRRobotTask(rRobotTask);
    }

    /**
     * 批量删除机器人任务
     * 
     * @param ids 需要删除的机器人任务主键
     * @return 结果
     */
    @Override
    public int deleteRRobotTaskByIds(Long[] ids)
    {
        return rRobotTaskMapper.deleteRRobotTaskByIds(ids);
    }

    /**
     * 删除机器人任务信息
     * 
     * @param id 机器人任务主键
     * @return 结果
     */
    @Override
    public int deleteRRobotTaskById(Long id)
    {
        return rRobotTaskMapper.deleteRRobotTaskById(id);
    }
}
