package com.ruoyi.robot.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.robot.api.response.TaskInfo;
import com.ruoyi.robot.api.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.robot.mapper.RTaskMapper;
import com.ruoyi.robot.domain.RTask;
import com.ruoyi.robot.service.IRTaskService;

/**
 * 任务信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-02
 */
@Service
public class RTaskServiceImpl implements IRTaskService
{
    @Autowired
    private RTaskMapper rTaskMapper;

    @Autowired
    private RobotService robotService;

    /**
     * 查询任务信息
     *
     * @param id 任务信息主键
     * @return 任务信息
     */
    @Override
    public RTask selectRTaskById(Long id)
    {
        return rTaskMapper.selectRTaskById(id);
    }

    @Override
    public void importRTaskListFromAgv() {
        List<RTask> rTasks = rTaskMapper.selectRTaskList(new RTask());
        List<TaskInfo> tasks = robotService.getTaskInfo();
        tasks.forEach(task -> {
           if (rTasks.stream().noneMatch(it->it.getTaskId().equals(task.getTask_id())) ){
               rTaskMapper.insertRTask(new RTask(){{
                   setTaskId(task.getTask_id());
                   setName(task.getName());
               }});
           }
        });
    }

    /**
     * 查询任务信息列表
     *
     * @param rTask 任务信息
     * @return 任务信息
     */
    @Override
    public List<RTask> selectRTaskList(RTask rTask)
    {
        return rTaskMapper.selectRTaskList(rTask);
    }

    /**
     * 新增任务信息
     *
     * @param rTask 任务信息
     * @return 结果
     */
    @Override
    public int insertRTask(RTask rTask)
    {
        rTask.setCreateTime(DateUtils.getNowDate());
        return rTaskMapper.insertRTask(rTask);
    }

    /**
     * 修改任务信息
     *
     * @param rTask 任务信息
     * @return 结果
     */
    @Override
    public int updateRTask(RTask rTask)
    {
        rTask.setUpdateTime(DateUtils.getNowDate());
        return rTaskMapper.updateRTask(rTask);
    }

    /**
     * 批量删除任务信息
     *
     * @param ids 需要删除的任务信息主键
     * @return 结果
     */
    @Override
    public int deleteRTaskByIds(Long[] ids)
    {
        return rTaskMapper.deleteRTaskByIds(ids);
    }

    /**
     * 删除任务信息信息
     *
     * @param id 任务信息主键
     * @return 结果
     */
    @Override
    public int deleteRTaskById(Long id)
    {
        return rTaskMapper.deleteRTaskById(id);
    }
}
