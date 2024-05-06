package com.ruoyi.robot.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 机器人信息对象 r_robot
 *
 * @author ruoyi
 * @date 2023-03-02
 */
@Data
public class RRobot extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 机器人id */
    @Excel(name = "机器人id")
    private String robotId;

    /** 机器人名称 */
    @Excel(name = "机器人名称")
    private String name;

    /** 机器人类型 */
    @Excel(name = "机器人类型")
    private String type;

    /** 机器人型号 */
    @Excel(name = "机器人型号")
    private String model;

    private RRobotBattery battery;

    private RRobotEmcy emcy;

    private RRobotLocation location;

    private RRobotState state;

    private RRobotTask task;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String status;

}
