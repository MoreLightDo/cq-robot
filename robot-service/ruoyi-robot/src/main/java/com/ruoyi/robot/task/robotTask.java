package com.ruoyi.robot.task;

import com.ruoyi.robot.api.request.TaskDoRequest;
import com.ruoyi.robot.api.service.RobotService;
import com.ruoyi.robot.domain.RRobotCornJob;
import com.ruoyi.robot.service.IRRobotCornJobService;
import com.ruoyi.robot.service.IRSensorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("rtask")
public class robotTask {

    @Autowired
    private IRSensorLogService sensorLogService;

    @Autowired
    private IRRobotCornJobService cubeCornJobService;

    @Autowired
    private RobotService robotService;

    public void logTask() {
        sensorLogService.importSensorFormAgv();
    }

    public void alertTask(){
        sensorLogService.importSensorAlarmLogFormAgv();
    }

    public void doJob(Long jobId){
        RRobotCornJob cornJob = cubeCornJobService.selectRRobotCornJobById(jobId);
        RRobotCornJob newCornJob = new RRobotCornJob();
        newCornJob.setId(jobId);
        newCornJob.setTriggerTimes(cornJob.getTriggerTimes() + 1);
        newCornJob.setLastTriggerTime(new Date());
        cubeCornJobService.updateRRobotCornJob(newCornJob);
        robotService.doTask(TaskDoRequest.builder().task_id(cornJob.getTaskId()).build());
    }

}
