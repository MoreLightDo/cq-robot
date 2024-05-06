package com.ruoyi.robot.api.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PtzRequest {

    // 水平速度[-30°~30°]，正值逆时针转动
    private Integer level;

    // 垂直速度[-30°~30°]，正值向上转动
    private Integer vertical;

}
