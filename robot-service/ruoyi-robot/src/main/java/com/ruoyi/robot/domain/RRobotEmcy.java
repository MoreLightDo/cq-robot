package com.ruoyi.robot.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 应急对象 r_robot_emcy
 * 
 * @author ruoyi
 * @date 2023-03-02
 */
public class RRobotEmcy extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long robotId;

    /** 是否急停中[1-急停中 0-未急停] */
    @Excel(name = "是否急停中[1-急停中 0-未急停]")
    private Integer emcyed;

    /** 是否硬件急停[1-是 0-否] */
    @Excel(name = "是否硬件急停[1-是 0-否]")
    private Integer hardware;

    /** 是否软件急停[1-是 0-否] */
    @Excel(name = "是否软件急停[1-是 0-否]")
    private Integer software;

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
    public void setEmcyed(Integer emcyed) 
    {
        this.emcyed = emcyed;
    }

    public Integer getEmcyed() 
    {
        return emcyed;
    }
    public void setHardware(Integer hardware) 
    {
        this.hardware = hardware;
    }

    public Integer getHardware() 
    {
        return hardware;
    }
    public void setSoftware(Integer software) 
    {
        this.software = software;
    }

    public Integer getSoftware() 
    {
        return software;
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
            .append("emcyed", getEmcyed())
            .append("hardware", getHardware())
            .append("software", getSoftware())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status", getStatus())
            .toString();
    }
}
