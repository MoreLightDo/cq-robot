package com.ruoyi.robot.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 定位对象 r_robot_location
 *
 * @author ruoyi
 * @date 2023-03-02
 */
public class RRobotLocation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long robotId;

    /** 是否已定位[1-已定位 0-未定位] */
    @Excel(name = "是否已定位[1-已定位 0-未定位]")
    private Integer located;

    /** 当前定位地图id */
    @Excel(name = "当前定位地图id")
    private String mapId;

    /** x坐标（m） */
    @Excel(name = "x坐标", readConverterExp = "m=")
    private BigDecimal x;

    /** y坐标（m） */
    @Excel(name = "y坐标", readConverterExp = "m=")
    private BigDecimal y;

    /** yaw坐标（°） */
    @Excel(name = "yaw坐标", readConverterExp = "°=")
    private BigDecimal yaw;

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
    public void setLocated(Integer located)
    {
        this.located = located;
    }

    public Integer getLocated()
    {
        return located;
    }

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    public void setX(BigDecimal x)
    {
        this.x = x;
    }

    public BigDecimal getX()
    {
        return x;
    }
    public void setY(BigDecimal y)
    {
        this.y = y;
    }

    public BigDecimal getY()
    {
        return y;
    }
    public void setYaw(BigDecimal yaw)
    {
        this.yaw = yaw;
    }

    public BigDecimal getYaw()
    {
        return yaw;
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
            .append("located", getLocated())
            .append("mapId", getMapId())
            .append("x", getX())
            .append("y", getY())
            .append("yaw", getYaw())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status", getStatus())
            .toString();
    }
}
