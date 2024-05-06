package com.ruoyi.robot.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 机器人信息对象 r_robot_info
 * 
 * @author ruoyi
 * @date 2023-03-02
 */
public class RRobotInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long robotId;

    /** 在线状态[1-在线 0-离线] */
    @Excel(name = "在线状态[1-在线 0-离线]")
    private Integer online;

    /** R1电流(A) */
    @Excel(name = "R1电流(A)")
    private BigDecimal r1Current;

    /** R2电流(A) */
    @Excel(name = "R2电流(A)")
    private BigDecimal r2Current;

    /** R3电流(A) */
    @Excel(name = "R3电流(A)")
    private BigDecimal r3Current;

    /** R4电流(A) */
    @Excel(name = "R4电流(A)")
    private BigDecimal r4Current;

    /** R5电流(A) */
    @Excel(name = "R5电流(A)")
    private BigDecimal r5Current;

    /** R6电流(A) */
    @Excel(name = "R6电流(A)")
    private BigDecimal r6Current;

    /** R1电压(V) */
    @Excel(name = "R1电压(V)")
    private BigDecimal r1Voltage;

    /** R2电压(V) */
    @Excel(name = "R2电压(V)")
    private BigDecimal r2Voltage;

    /** R3电压(V) */
    @Excel(name = "R3电压(V)")
    private BigDecimal r3Voltage;

    /** R4电压(V) */
    @Excel(name = "R4电压(V)")
    private BigDecimal r4Voltage;

    /** R5电压(V) */
    @Excel(name = "R5电压(V)")
    private BigDecimal r5Voltage;

    /** R6电压(V) */
    @Excel(name = "R6电压(V)")
    private BigDecimal r6Voltage;

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
    public void setOnline(Integer online) 
    {
        this.online = online;
    }

    public Integer getOnline() 
    {
        return online;
    }
    public void setR1Current(BigDecimal r1Current) 
    {
        this.r1Current = r1Current;
    }

    public BigDecimal getR1Current() 
    {
        return r1Current;
    }
    public void setR2Current(BigDecimal r2Current) 
    {
        this.r2Current = r2Current;
    }

    public BigDecimal getR2Current() 
    {
        return r2Current;
    }
    public void setR3Current(BigDecimal r3Current) 
    {
        this.r3Current = r3Current;
    }

    public BigDecimal getR3Current() 
    {
        return r3Current;
    }
    public void setR4Current(BigDecimal r4Current) 
    {
        this.r4Current = r4Current;
    }

    public BigDecimal getR4Current() 
    {
        return r4Current;
    }
    public void setR5Current(BigDecimal r5Current) 
    {
        this.r5Current = r5Current;
    }

    public BigDecimal getR5Current() 
    {
        return r5Current;
    }
    public void setR6Current(BigDecimal r6Current) 
    {
        this.r6Current = r6Current;
    }

    public BigDecimal getR6Current() 
    {
        return r6Current;
    }
    public void setR1Voltage(BigDecimal r1Voltage) 
    {
        this.r1Voltage = r1Voltage;
    }

    public BigDecimal getR1Voltage() 
    {
        return r1Voltage;
    }
    public void setR2Voltage(BigDecimal r2Voltage) 
    {
        this.r2Voltage = r2Voltage;
    }

    public BigDecimal getR2Voltage() 
    {
        return r2Voltage;
    }
    public void setR3Voltage(BigDecimal r3Voltage) 
    {
        this.r3Voltage = r3Voltage;
    }

    public BigDecimal getR3Voltage() 
    {
        return r3Voltage;
    }
    public void setR4Voltage(BigDecimal r4Voltage) 
    {
        this.r4Voltage = r4Voltage;
    }

    public BigDecimal getR4Voltage() 
    {
        return r4Voltage;
    }
    public void setR5Voltage(BigDecimal r5Voltage) 
    {
        this.r5Voltage = r5Voltage;
    }

    public BigDecimal getR5Voltage() 
    {
        return r5Voltage;
    }
    public void setR6Voltage(BigDecimal r6Voltage) 
    {
        this.r6Voltage = r6Voltage;
    }

    public BigDecimal getR6Voltage() 
    {
        return r6Voltage;
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
            .append("online", getOnline())
            .append("r1Current", getR1Current())
            .append("r2Current", getR2Current())
            .append("r3Current", getR3Current())
            .append("r4Current", getR4Current())
            .append("r5Current", getR5Current())
            .append("r6Current", getR6Current())
            .append("r1Voltage", getR1Voltage())
            .append("r2Voltage", getR2Voltage())
            .append("r3Voltage", getR3Voltage())
            .append("r4Voltage", getR4Voltage())
            .append("r5Voltage", getR5Voltage())
            .append("r6Voltage", getR6Voltage())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status", getStatus())
            .toString();
    }
}
