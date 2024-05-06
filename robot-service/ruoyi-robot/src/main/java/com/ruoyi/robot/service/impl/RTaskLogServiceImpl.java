package com.ruoyi.robot.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.robot.api.response.TaskLog;
import com.ruoyi.robot.api.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.robot.mapper.RTaskLogMapper;
import com.ruoyi.robot.domain.RTaskLog;
import com.ruoyi.robot.service.IRTaskLogService;

/**
 * 任务日志Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-02
 */
@Service
public class RTaskLogServiceImpl implements IRTaskLogService
{
    @Autowired
    private RTaskLogMapper rTaskLogMapper;

    @Autowired
    private RobotService robotService;

    /**
     * 查询任务日志
     *
     * @param id 任务日志主键
     * @return 任务日志
     */
    @Override
    public RTaskLog selectRTaskLogById(Long id)
    {
        return rTaskLogMapper.selectRTaskLogById(id);
    }

    @Override
    public void importRTaskLogFormAgv() {
        List<TaskLog> taskLogs = robotService.getTaskLog();
        taskLogs.forEach(task -> {
            rTaskLogMapper.insertRTaskLog(new RTaskLog(){{
                setTaskId(task.getTask_id());
                setAlarm(task.getAlarm());
                setData((String) task.getData());
                setName(task.getName());
            }});
        });
    }

    /**
     * 查询任务日志列表
     *
     * @param rTaskLog 任务日志
     * @return 任务日志
     */
    @Override
    public List<RTaskLog> selectRTaskLogList(RTaskLog rTaskLog)
    {
        return rTaskLogMapper.selectRTaskLogList(rTaskLog);
    }

    /**
     * 新增任务日志
     *
     * @param rTaskLog 任务日志
     * @return 结果
     */
    @Override
    public int insertRTaskLog(RTaskLog rTaskLog)
    {
        rTaskLog.setCreateTime(DateUtils.getNowDate());
        return rTaskLogMapper.insertRTaskLog(rTaskLog);
    }

    /**
     * 修改任务日志
     *
     * @param rTaskLog 任务日志
     * @return 结果
     */
    @Override
    public int updateRTaskLog(RTaskLog rTaskLog)
    {
        rTaskLog.setUpdateTime(DateUtils.getNowDate());
        return rTaskLogMapper.updateRTaskLog(rTaskLog);
    }

    /**
     * 批量删除任务日志
     *
     * @param ids 需要删除的任务日志主键
     * @return 结果
     */
    @Override
    public int deleteRTaskLogByIds(Long[] ids)
    {
        return rTaskLogMapper.deleteRTaskLogByIds(ids);
    }

    /**
     * 删除任务日志信息
     *
     * @param id 任务日志主键
     * @return 结果
     */
    @Override
    public int deleteRTaskLogById(Long id)
    {
        return rTaskLogMapper.deleteRTaskLogById(id);
    }
}
