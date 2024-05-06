package com.ruoyi.robot.api.response;

import lombok.Data;

@Data
public class RobotStateInfo {

    private String name;

    private  Boolean located;

    private Boolean mapping;

    private Boolean tasking;

    private Boolean charging;

    private Boolean emcyed;

    private Boolean faulted;

    private Boolean online;

    private Boolean low_power;
}
