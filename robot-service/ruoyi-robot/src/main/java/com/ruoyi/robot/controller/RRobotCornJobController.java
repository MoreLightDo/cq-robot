package com.ruoyi.robot.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.scheduling.support.CronExpression;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.robot.domain.RRobotCornJob;
import com.ruoyi.robot.service.IRRobotCornJobService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 机器人定时任务Controller
 *
 * @author ruoyi
 * @date 2023-04-17
 */
@RestController
@RequestMapping("/cornjob/job")
public class RRobotCornJobController extends BaseController
{
    @Autowired
    private IRRobotCornJobService rRobotCornJobService;

    /**
     * 查询机器人定时任务列表
     */
    @PreAuthorize("@ss.hasPermi('cornjob:job:list')")
    @GetMapping("/list")
    public TableDataInfo list(RRobotCornJob rRobotCornJob)
    {
        startPage();
        List<RRobotCornJob> list = rRobotCornJobService.selectRRobotCornJobList(rRobotCornJob);
        return getDataTable(list);
    }

    /**
     * 导出机器人定时任务列表
     */
    @PreAuthorize("@ss.hasPermi('cornjob:job:export')")
    @Log(title = "机器人定时任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RRobotCornJob rRobotCornJob)
    {
        List<RRobotCornJob> list = rRobotCornJobService.selectRRobotCornJobList(rRobotCornJob);
        ExcelUtil<RRobotCornJob> util = new ExcelUtil<RRobotCornJob>(RRobotCornJob.class);
        util.exportExcel(response, list, "机器人定时任务数据");
    }

    /**
     * 获取机器人定时任务详细信息
     */
    @PreAuthorize("@ss.hasPermi('cornjob:job:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rRobotCornJobService.selectRRobotCornJobById(id));
    }

    /**
     * 新增机器人定时任务
     */
    @PreAuthorize("@ss.hasPermi('cornjob:job:add')")
    @Log(title = "机器人定时任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RRobotCornJob rRobotCornJob)
    {
        return toAjax(rRobotCornJobService.insertRRobotCornJob(rRobotCornJob));
    }

    /**
     * 修改机器人定时任务
     */
    @PreAuthorize("@ss.hasPermi('cornjob:job:edit')")
    @Log(title = "机器人定时任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RRobotCornJob rRobotCornJob)
    {
        return toAjax(rRobotCornJobService.updateRRobotCornJob(rRobotCornJob));
    }

    /**
     * 删除机器人定时任务
     */
    @PreAuthorize("@ss.hasPermi('cornjob:job:remove')")
    @Log(title = "机器人定时任务", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable Long id)
    {
        return toAjax(rRobotCornJobService.deleteRRobotCornJobById(id));
    }

    @GetMapping("/features")
    public AjaxResult listFeatures(@RequestParam(name = "corn") String cron){
        CronExpression parse = CronExpression.parse(cron);
        ArrayList<LocalDateTime> dateTimes = new ArrayList<>();
        LocalDateTime temp = parse.next(LocalDateTime.now());
        for (int i = 0; i < 10; i++) {
            dateTimes.add(temp);
            temp = parse.next(temp);
        }
        return AjaxResult.success(dateTimes);
    }
}
