package com.ruoyi.robot.api.response;

public class RobotMapping {
    /**
     * floor : 0
     * height : 0
     * map_id :
     * mapping : false
     * name :
     * progress : 0
     * resolution : 0.02
     * rotation : 0
     * ts : 0
     * version : 0
     * width : 0
     */

    private int floor;
    private int height;
    private String map_id;
    private boolean mapping;
    private String name;
    private int progress;
    private double resolution;
    private int rotation;
    private int ts;
    private String version;
    private int width;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMap_id() {
        return map_id;
    }

    public void setMap_id(String map_id) {
        this.map_id = map_id;
    }

    public boolean isMapping() {
        return mapping;
    }

    public void setMapping(boolean mapping) {
        this.mapping = mapping;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public double getResolution() {
        return resolution;
    }

    public void setResolution(double resolution) {
        this.resolution = resolution;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int getTs() {
        return ts;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
