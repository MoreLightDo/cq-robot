package com.ruoyi.robot.api.response;

import lombok.Data;

@Data
public class AGVInfoResponse {

   private String robot_id;

   private String name;

   private String type;

   private String model;

   private RobotStateInfo state;

   private EmcyInfo emcy;

   private BatteryInfo battery;

   private LocationInfo location;

   private TaskInfo task;

   private RobotController controller;

   private RobotMapping mapping;

   private RobotMotion motion;

   private Statistics statistics;

}
