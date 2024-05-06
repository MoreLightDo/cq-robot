package com.ruoyi.robot.api.response;


import lombok.Data;

@Data
public class SensorInfo {

    private SensorData smoke;

    private SensorData co;

    private SensorData h2s;

    private SensorData ch4;

    private SensorData h2;

    private SensorData temp;

    private SensorData humi;

    private SensorData noise;

}
