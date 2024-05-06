package com.ruoyi.robot.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.robot.domain.RSensorAlarmRule;
import com.ruoyi.robot.service.IRSensorAlarmRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alarm/rule")
public class RobotAlarmRuleController extends BaseController {

    @Autowired
    private IRSensorAlarmRuleService alarmRuleService;

    @GetMapping("/list")
    public AjaxResult list(){
        return AjaxResult.success(alarmRuleService.selectRSensorAlarmRuleList(new RSensorAlarmRule()));
    }

    @PostMapping
    public AjaxResult edit(@RequestBody RSensorAlarmRule rule){
        return toAjax(alarmRuleService.updateRSensorAlarmRule(rule));
    }

}
