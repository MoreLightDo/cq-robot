package com.ruoyi.robot.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * ptz信息对象 r_ptz_info
 * 
 * @author ruoyi
 * @date 2023-03-02
 */
public class RPtzInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 在线状态[true-在线 false-离线] */
    @Excel(name = "在线状态[true-在线 false-离线]")
    private Integer online;

    /** 水平角度[-180°~180°] */
    @Excel(name = "水平角度[-180°~180°]")
    private BigDecimal level;

    /** 垂直角度[-180°~180°] */
    @Excel(name = "垂直角度[-180°~180°]")
    private BigDecimal vertical;

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
    public void setOnline(Integer online) 
    {
        this.online = online;
    }

    public Integer getOnline() 
    {
        return online;
    }
    public void setLevel(BigDecimal level) 
    {
        this.level = level;
    }

    public BigDecimal getLevel() 
    {
        return level;
    }
    public void setVertical(BigDecimal vertical) 
    {
        this.vertical = vertical;
    }

    public BigDecimal getVertical() 
    {
        return vertical;
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
            .append("online", getOnline())
            .append("level", getLevel())
            .append("vertical", getVertical())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status", getStatus())
            .toString();
    }
}
