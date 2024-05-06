package com.ruoyi.robot.api.response;

import lombok.Data;

@Data
public class BatteryInfo {

    private Double soc;

    private Double voltage;

    private Double current;

    private Boolean charging;

}
