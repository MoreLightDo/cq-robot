package com.ruoyi.robot.api.response;

import lombok.Data;

@Data
public class TaskLog {

    private String task_id;

    private String name;

    private Object data;

    private String alarm;

}
