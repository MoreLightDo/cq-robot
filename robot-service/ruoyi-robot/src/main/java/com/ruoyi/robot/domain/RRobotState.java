package com.ruoyi.robot.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 机器人状态对象 r_robot_state
 *
 * @author ruoyi
 * @date 2023-03-02
 */
public class RRobotState extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 状态提示字符
["未定位"、"空闲中"、"建图中"、"工作中"、"故障中"]
 */
    private String name;

    /** 是否已定位 [1-已定位 0-未定位] */
    @Excel(name = "是否已定位 [1-已定位 0-未定位]")
    private Integer located;

    /** 是否建图中 [1-建图中 0-未建图] */
    @Excel(name = "是否建图中 [1-建图中 0-未建图]")
    private Integer mapping;

    /** 是否工作中 [1-工作中 0-未工作] */
    @Excel(name = "是否工作中 [1-工作中 0-未工作]")
    private Integer tasking;

    /** 是否充电中[1-充电中 0-未充电] */
    @Excel(name = "是否充电中[1-充电中 0-未充电]")
    private Integer charging;

    /** 是否急停中[1-急停中 0-未急停] */
    @Excel(name = "是否急停中[1-急停中 0-未急停]")
    private Integer emcyed;

    /** 是否故障中[1-故障中 0-无故障] */
    @Excel(name = "是否故障中[1-故障中 0-无故障]")
    private Integer faulted;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String status;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long robotId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setLocated(Integer located)
    {
        this.located = located;
    }

    public Integer getLocated()
    {
        return located;
    }
    public void setMapping(Integer mapping)
    {
        this.mapping = mapping;
    }

    public Integer getMapping()
    {
        return mapping;
    }
    public void setTasking(Integer tasking)
    {
        this.tasking = tasking;
    }

    public Integer getTasking()
    {
        return tasking;
    }
    public void setCharging(Integer charging)
    {
        this.charging = charging;
    }

    public Integer getCharging()
    {
        return charging;
    }
    public void setEmcyed(Integer emcyed)
    {
        this.emcyed = emcyed;
    }

    public Integer getEmcyed()
    {
        return emcyed;
    }
    public void setFaulted(Integer faulted)
    {
        this.faulted = faulted;
    }

    public Integer getFaulted()
    {
        return faulted;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setRobotId(Long robotId)
    {
        this.robotId = robotId;
    }

    public Long getRobotId()
    {
        return robotId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("located", getLocated())
            .append("mapping", getMapping())
            .append("tasking", getTasking())
            .append("charging", getCharging())
            .append("emcyed", getEmcyed())
            .append("faulted", getFaulted())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("robotId", getRobotId())
            .toString();
    }
}
