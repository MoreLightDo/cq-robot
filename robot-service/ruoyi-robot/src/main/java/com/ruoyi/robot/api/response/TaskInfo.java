package com.ruoyi.robot.api.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaskInfo {

    private Boolean tasking;

    private String name;

    private String task_id;

    private BigDecimal ts;

    // 任务状态["无任务"、"准备中"、
    // "工作中"、"已暂停"、"已完成"、"已取消"、"已失败"]
    private String state;

    private Double progress;

    private String info;

    private Integer code;

    private Integer sub_task_index;
}
