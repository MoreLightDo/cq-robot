package com.ruoyi.robot.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 传感器预警设置对象 r_sensor_alarm_rule
 *
 * @author ruoyi
 * @date 2023-03-16
 */
public class RSensorAlarmRule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 预警标题 */
    @Excel(name = "预警标题")
    private String label;

    /** 预警类型 */
    @Excel(name = "预警类型")
    private String type;

    /** 预警阈值 */
    @Excel(name = "预警阈值")
    private BigDecimal alarmValue;

    /** 预警单位名称 */
    @Excel(name = "预警单位名称")
    private String alarmUnit;

    /** 预警级别 */
    @Excel(name = "预警级别")
    private Integer alarmLevel;

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
    public void setLabel(String label)
    {
        this.label = label;
    }

    public String getLabel()
    {
        return label;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setAlarmValue(BigDecimal alarmValue)
    {
        this.alarmValue = alarmValue;
    }

    public BigDecimal getAlarmValue()
    {
        return alarmValue;
    }
    public void setAlarmUnit(String alarmUnit)
    {
        this.alarmUnit = alarmUnit;
    }

    public String getAlarmUnit()
    {
        return alarmUnit;
    }
    public void setAlarmLevel(Integer alarmLevel)
    {
        this.alarmLevel = alarmLevel;
    }

    public Integer getAlarmLevel()
    {
        return alarmLevel;
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
            .append("label", getLabel())
            .append("type", getType())
            .append("alarmValue", getAlarmValue())
            .append("alarmUnit", getAlarmUnit())
            .append("alarmLevel", getAlarmLevel())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("status", getStatus())
            .toString();
    }
}
