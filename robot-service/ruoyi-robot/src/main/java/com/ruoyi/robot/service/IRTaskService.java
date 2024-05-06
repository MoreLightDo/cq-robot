package com.ruoyi.robot.service;

import java.util.List;
import com.ruoyi.robot.domain.RTask;

/**
 * 任务信息Service接口
 *
 * @author ruoyi
 * @date 2023-03-02
 */
public interface IRTaskService
{
    /**
     * 查询任务信息
     *
     * @param id 任务信息主键
     * @return 任务信息
     */
    public RTask selectRTaskById(Long id);

    public void importRTaskListFromAgv();

    /**
     * 查询任务信息列表
     *
     * @param rTask 任务信息
     * @return 任务信息集合
     */
    public List<RTask> selectRTaskList(RTask rTask);

    /**
     * 新增任务信息
     *
     * @param rTask 任务信息
     * @return 结果
     */
    public int insertRTask(RTask rTask);

    /**
     * 修改任务信息
     *
     * @param rTask 任务信息
     * @return 结果
     */
    public int updateRTask(RTask rTask);

    /**
     * 批量删除任务信息
     *
     * @param ids 需要删除的任务信息主键集合
     * @return 结果
     */
    public int deleteRTaskByIds(Long[] ids);

    /**
     * 删除任务信息信息
     *
     * @param id 任务信息主键
     * @return 结果
     */
    public int deleteRTaskById(Long id);
}
