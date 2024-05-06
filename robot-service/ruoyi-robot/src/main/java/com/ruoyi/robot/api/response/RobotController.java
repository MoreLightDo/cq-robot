package com.ruoyi.robot.api.response;

public class RobotController {
    /**
     * cpu : {"freq":0,"usage":0}
     * disk : {"total":0,"usage":0,"used":0}
     * memory : {"total":0,"usage":0,"used":0}
     * network : {"in":0,"out":0}
     * temperature : {"cpu":0}
     */

    private CpuBean cpu;
    private DiskBean disk;
    private MemoryBean memory;
    private NetworkBean network;
    private TemperatureBean temperature;

    public CpuBean getCpu() {
        return cpu;
    }

    public void setCpu(CpuBean cpu) {
        this.cpu = cpu;
    }

    public DiskBean getDisk() {
        return disk;
    }

    public void setDisk(DiskBean disk) {
        this.disk = disk;
    }

    public MemoryBean getMemory() {
        return memory;
    }

    public void setMemory(MemoryBean memory) {
        this.memory = memory;
    }

    public NetworkBean getNetwork() {
        return network;
    }

    public void setNetwork(NetworkBean network) {
        this.network = network;
    }

    public TemperatureBean getTemperature() {
        return temperature;
    }

    public void setTemperature(TemperatureBean temperature) {
        this.temperature = temperature;
    }

    public static class CpuBean {
        /**
         * freq : 0
         * usage : 0
         */

        private int freq;
        private int usage;

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }

        public int getUsage() {
            return usage;
        }

        public void setUsage(int usage) {
            this.usage = usage;
        }
    }

    public static class DiskBean {
        /**
         * total : 0
         * usage : 0
         * used : 0
         */

        private int total;
        private int usage;
        private int used;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getUsage() {
            return usage;
        }

        public void setUsage(int usage) {
            this.usage = usage;
        }

        public int getUsed() {
            return used;
        }

        public void setUsed(int used) {
            this.used = used;
        }
    }

    public static class MemoryBean {
        /**
         * total : 0
         * usage : 0
         * used : 0
         */

        private int total;
        private int usage;
        private int used;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getUsage() {
            return usage;
        }

        public void setUsage(int usage) {
            this.usage = usage;
        }

        public int getUsed() {
            return used;
        }

        public void setUsed(int used) {
            this.used = used;
        }
    }

    public static class NetworkBean {
        /**
         * in : 0
         * out : 0
         */

        private int in;
        private int out;

        public int getIn() {
            return in;
        }

        public void setIn(int in) {
            this.in = in;
        }

        public int getOut() {
            return out;
        }

        public void setOut(int out) {
            this.out = out;
        }
    }

    public static class TemperatureBean {
        /**
         * cpu : 0
         */

        private int cpu;

        public int getCpu() {
            return cpu;
        }

        public void setCpu(int cpu) {
            this.cpu = cpu;
        }
    }
}
