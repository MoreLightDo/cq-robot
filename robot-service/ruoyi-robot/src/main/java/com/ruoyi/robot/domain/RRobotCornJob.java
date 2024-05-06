package com.ruoyi.robot.domain;

import javafx.scene.chart.PieChart;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 机器人定时任务对象 r_robot_corn_job
 *
 * @author ruoyi
 * @date 2023-04-17
 */
public class RRobotCornJob extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String taskName;

    /** 任务id */
    @Excel(name = "任务id")
    private String taskId;

    /** 任务状态 0 为正在执行 1 为 停止*/
    @Excel(name = "任务状态")
    private Integer status;

    /** 定时任务名称 */
    @Excel(name = "定时任务名称")
    private String jobName;

    /** 定时任务corn表达式 */
    @Excel(name = "定时任务corn表达式")
    private String jobCorn;

    /** 触发次数 */
    @Excel(name = "触发次数")
    private Integer triggerTimes;

    private Date lastTriggerTime;

    public Date getLastTriggerTime() {
        return lastTriggerTime;
    }

    public void setLastTriggerTime(Date lastTriggerTime) {
        this.lastTriggerTime = lastTriggerTime;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    public String getTaskName()
    {
        return taskName;
    }
    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public String getTaskId()
    {
        return taskId;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setJobName(String jobName)
    {
        this.jobName = jobName;
    }

    public String getJobName()
    {
        return jobName;
    }
    public void setJobCorn(String jobCorn)
    {
        this.jobCorn = jobCorn;
    }

    public String getJobCorn()
    {
        return jobCorn;
    }
    public void setTriggerTimes(Integer triggerTimes)
    {
        this.triggerTimes = triggerTimes;
    }

    public Integer getTriggerTimes()
    {
        return triggerTimes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("taskName", getTaskName())
            .append("taskId", getTaskId())
            .append("status", getStatus())
            .append("jobName", getJobName())
            .append("jobCorn", getJobCorn())
            .append("createTime", getCreateTime())
            .append("triggerTimes", getTriggerTimes())
            .append("remark", getRemark())
            .toString();
    }
}
