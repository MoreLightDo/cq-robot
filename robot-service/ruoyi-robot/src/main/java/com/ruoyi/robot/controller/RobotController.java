package com.ruoyi.robot.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.robot.api.request.PtzRequest;
import com.ruoyi.robot.api.request.TaskDoRequest;
import com.ruoyi.robot.api.request.TaskInfoRequest;
import com.ruoyi.robot.api.response.AGVInfoResponse;
import com.ruoyi.robot.api.service.RobotService;
import com.ruoyi.robot.api.service.RobotTwoService;
import com.ruoyi.robot.domain.*;
import com.ruoyi.robot.service.*;
import com.ruoyi.robot.utils.SshUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/robot")
public class RobotController  extends BaseController {

    @Autowired
    private RobotService service;

    @Autowired
    private RobotTwoService twoService;

    @Autowired
    private IRSensorLogService sensorLogService;

    @Autowired
    private IRSensorAlarmLogService sensorAlarmLogService;

    @GetMapping("/agv_info")
    public AjaxResult getAGVInfo(){
        return AjaxResult.success(service.getAGVInfo());
    }

    @GetMapping("/sensors")
    public AjaxResult getSensorInfos(){
        return AjaxResult.success(service.getSensorInfo());
    }

    @GetMapping("/info")
    public AjaxResult getRobotInfo(){
        return AjaxResult.success(service.getArmInfo());
    }

    @GetMapping("/ptz")
    public AjaxResult getPtzInfo(){
        return  AjaxResult.success(service.getPtzInfo());
    }

    @PostMapping("/ptz_ctrl")
    public AjaxResult ctrlPtz(@RequestBody Map<String, Integer> params){
        return AjaxResult.success(service.ptzCtl(PtzRequest.builder()
                        .level(params.get("level"))
                        .vertical(params.get("vertical"))
                        .build()));
    }

    @GetMapping("/tasks")
    public AjaxResult getTaskList(){
        return AjaxResult.success(service.getTaskInfo());
    }

    @GetMapping("/dotask/{id}")
    public AjaxResult doTask(@PathVariable String id){
        return AjaxResult.success(service.doTask(TaskDoRequest.builder().task_id(id).build()));
    }

    @GetMapping("/task_log")
    public AjaxResult taskLogs(){
        return AjaxResult.success(twoService.getTaskInfo(TaskInfoRequest.builder().type(1).build()).getData().getInfos());
    }

    @GetMapping("/last_task")
    public AjaxResult getLastTask(){
        return AjaxResult.success(service.getLastTask());
    }

    @GetMapping("/mapList")
    public AjaxResult getMapList(){
        return AjaxResult.success(service.getMapList());
    }

    @GetMapping("/mapInfo/{id}")
    public AjaxResult getMapInfo(@PathVariable String id){
        return AjaxResult.success(service.getMapInfo(Collections.singletonMap("map_id",id)));
    }

    @GetMapping("/import/sensor")
    public AjaxResult importSensor(){
        sensorLogService.importSensorFormAgv();
        return success();
    }

    @GetMapping("/alarm/log/list")
    public TableDataInfo getAlarmLogList(){
        startPage();
        return getDataTable(sensorAlarmLogService.selectRSensorAlarmLogList(new RSensorAlarmLog()));
    }

    @GetMapping("/sensor/list")
    public TableDataInfo getSensorList(RSensorLog sensorLog){
        startPage();
        return getDataTable(sensorLogService.selectRSensorLogList(sensorLog));
    }

    @GetMapping("/video/list")
    public AjaxResult getVideoList(){
        return AjaxResult.success(SshUtils.getFileList());
    }

    @GetMapping("/view/video")
    public AjaxResult viewVideo(@RequestParam(name = "fileName") String fileName){
        return AjaxResult.success(SshUtils.convertVidep(fileName));
    }
}
