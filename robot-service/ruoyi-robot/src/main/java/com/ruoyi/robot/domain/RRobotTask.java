package com.ruoyi.robot.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 机器人任务对象 r_robot_task
 *
 * @author ruoyi
 * @date 2023-03-02
 */
public class RRobotTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long robotId;

    /** 是否工作中[true-工作中 false-未工作] */
    @Excel(name = "是否工作中[true-工作中 false-未工作]")
    private Integer tasking;

    /** 任务id */
    @Excel(name = "任务id")
    private String taskId;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String name;

    /** 任务时间戳（us） */
    @Excel(name = "任务时间戳", readConverterExp = "u=s")
    private BigDecimal ts;

    /** 任务状态["无任务"、"准备中"、"工作中"、"已暂停"、"已完成"、"已取消"、"已失败"] */
    @Excel(name = "任务状态[‘无任务’、‘准备中’、‘工作中’、‘已暂停’、‘已完成’、‘已取消’、’已失败‘]")
    private String state;

    /** 任务进度（%） */
    @Excel(name = "任务进度", readConverterExp = "%=")
    private BigDecimal progress;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setRobotId(Long robotId)
    {
        this.robotId = robotId;
    }

    public Long getRobotId()
    {
        return robotId;
    }
    public void setTasking(Integer tasking)
    {
        this.tasking = tasking;
    }

    public Integer getTasking()
    {
        return tasking;
    }
    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public String getTaskId()
    {
        return taskId;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setTs(BigDecimal ts)
    {
        this.ts = ts;
    }

    public BigDecimal getTs()
    {
        return ts;
    }
    public void setState(String state)
    {
        this.state = state;
    }

    public String getState()
    {
        return state;
    }
    public void setProgress(BigDecimal progress)
    {
        this.progress = progress;
    }

    public BigDecimal getProgress()
    {
        return progress;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("robotId", getRobotId())
            .append("tasking", getTasking())
            .append("taskId", getTaskId())
            .append("name", getName())
            .append("ts", getTs())
            .append("state", getState())
            .append("progress", getProgress())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status", getStatus())
            .toString();
    }
}
