package com.ruoyi.robot.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 电池对象 r_robot_battery
 * 
 * @author ruoyi
 * @date 2023-03-02
 */
public class RRobotBattery extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long robotId;

    /** 剩余电量（%） */
    @Excel(name = "剩余电量", readConverterExp = "%=")
    private BigDecimal soc;

    /** 电池电压（V） */
    @Excel(name = "电池电压", readConverterExp = "V=")
    private BigDecimal voltage;

    /** 电池电流（A） */
    @Excel(name = "电池电流", readConverterExp = "A=")
    private BigDecimal current;

    /** 是否充电中[1-充电中 0-未充电] */
    @Excel(name = "是否充电中[1-充电中 0-未充电]")
    private Integer charging;

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
    public void setSoc(BigDecimal soc) 
    {
        this.soc = soc;
    }

    public BigDecimal getSoc() 
    {
        return soc;
    }
    public void setVoltage(BigDecimal voltage) 
    {
        this.voltage = voltage;
    }

    public BigDecimal getVoltage() 
    {
        return voltage;
    }
    public void setCurrent(BigDecimal current) 
    {
        this.current = current;
    }

    public BigDecimal getCurrent() 
    {
        return current;
    }
    public void setCharging(Integer charging) 
    {
        this.charging = charging;
    }

    public Integer getCharging() 
    {
        return charging;
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
            .append("soc", getSoc())
            .append("voltage", getVoltage())
            .append("current", getCurrent())
            .append("charging", getCharging())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status", getStatus())
            .toString();
    }
}
