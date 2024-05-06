package com.ruoyi.robot.domain;

import java.math.BigDecimal;

import lombok.Builder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 传感器信息对象 r_sensor_info
 *
 * @author ruoyi
 * @date 2023-03-02
 */
@Builder
public class RSensorInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 传感器类型 */
    @Excel(name = "传感器类型")
    private String type;

    /** 在线状态[1-在线 0-离线] */
    @Excel(name = "在线状态[1-在线 0-离线]")
    private Integer isOnline;

    /** 当前值（ppm） */
    @Excel(name = "当前值", readConverterExp = "p=pm")
    private BigDecimal value;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String status;

    private Integer logId;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setIsOnline(Integer isOnline)
    {
        this.isOnline = isOnline;
    }

    public Integer getIsOnline()
    {
        return isOnline;
    }
    public void setValue(BigDecimal value)
    {
        this.value = value;
    }

    public BigDecimal getValue()
    {
        return value;
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
            .append("type", getType())
            .append("isOnline", getIsOnline())
            .append("value", getValue())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status", getStatus())
            .toString();
    }
}
