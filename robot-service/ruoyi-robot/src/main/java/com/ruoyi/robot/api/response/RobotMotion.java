package com.ruoyi.robot.api.response;

public class RobotMotion {
    /**
     * in_nav : false
     * obstacle_slow : false
     * obstacle_stop : false
     * vel : {"x":0,"y":0,"yaw":0}
     */

    private boolean in_nav;
    private boolean obstacle_slow;
    private boolean obstacle_stop;
    private VelBean vel;

    public boolean isIn_nav() {
        return in_nav;
    }

    public void setIn_nav(boolean in_nav) {
        this.in_nav = in_nav;
    }

    public boolean isObstacle_slow() {
        return obstacle_slow;
    }

    public void setObstacle_slow(boolean obstacle_slow) {
        this.obstacle_slow = obstacle_slow;
    }

    public boolean isObstacle_stop() {
        return obstacle_stop;
    }

    public void setObstacle_stop(boolean obstacle_stop) {
        this.obstacle_stop = obstacle_stop;
    }

    public VelBean getVel() {
        return vel;
    }

    public void setVel(VelBean vel) {
        this.vel = vel;
    }

    public static class VelBean {
        /**
         * x : 0
         * y : 0
         * yaw : 0
         */

        private double x;
        private double y;
        private double yaw;

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getYaw() {
            return yaw;
        }

        public void setYaw(double yaw) {
            this.yaw = yaw;
        }
    }
}
