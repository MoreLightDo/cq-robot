package com.ruoyi.robot.api.response;

public class LastTaskResponse {
    /**
     * begin_time : 2023-04-28 14:12:02
     * name : d403-巡检
     * state : 已完成
     * tasks : 总共6个巡检点
     */

    private String begin_time;
    private String name;
    private String state;
    private String tasks;

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }
}
