package com.ruoyi.robot.api.response;

import lombok.Data;

@Data
public class LocationInfo {

    private Boolean located;

    private String map_id;

    private Double x;

    private Double y;

    private Double yaw;
}
