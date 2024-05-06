package com.ruoyi.robot.api.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Statistics {

    /**
     * this_dist : 0
     * this_on_time : 88657.600001
     * this_task : 0
     * this_task_time : 0
     * total_dist : 0.15558
     * total_on_time : 414757.599974
     * total_task : 9
     * total_task_time : 10
     */

    private BigDecimal this_dist;
    private BigDecimal this_on_time;
    private BigDecimal this_task;
    private BigDecimal this_task_time;
    private BigDecimal total_dist;
    private BigDecimal total_on_time;
    private BigDecimal total_task;
    private BigDecimal total_task_time;


}
