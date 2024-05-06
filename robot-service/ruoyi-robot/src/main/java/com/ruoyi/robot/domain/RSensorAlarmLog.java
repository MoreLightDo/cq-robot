package com.ruoyi.robot.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 传感器预警日志对象 r_sensor_alarm_log
 *
 * @author ruoyi
 * @date 2023-03-16
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RSensorAlarmLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 预警规则id */
    @Excel(name = "预警规则id")
    private Long ruleId;

    /** 触发时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "触发时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date triggerTime;

    /** 预警信息 */
    @Excel(name = "预警信息")
    private String message;

    /** 预警值 */
    @Excel(name = "预警值")
    private BigDecimal alarmValue;

    /** 预警json */
    @Excel(name = "预警json")
    private String alarmJson;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String status;

    private Long infoId;

    private RSensorAlarmRule rule;

    public RSensorAlarmRule getRule() {
        return rule;
    }

    public void setRule(RSensorAlarmRule rule) {
        this.rule = rule;
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setRuleId(Long ruleId)
    {
        this.ruleId = ruleId;
    }

    public Long getRuleId()
    {
        return ruleId;
    }
    public void setTriggerTime(Date triggerTime)
    {
        this.triggerTime = triggerTime;
    }

    public Date getTriggerTime()
    {
        return triggerTime;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }
    public void setAlarmValue(BigDecimal alarmValue)
    {
        this.alarmValue = alarmValue;
    }

    public BigDecimal getAlarmValue()
    {
        return alarmValue;
    }
    public void setAlarmJson(String alarmJson)
    {
        this.alarmJson = alarmJson;
    }

    public String getAlarmJson()
    {
        return alarmJson;
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
            .append("ruleId", getRuleId())
            .append("triggerTime", getTriggerTime())
            .append("message", getMessage())
            .append("alarmValue", getAlarmValue())
            .append("alarmJson", getAlarmJson())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("status", getStatus())
            .toString();
    }
}
