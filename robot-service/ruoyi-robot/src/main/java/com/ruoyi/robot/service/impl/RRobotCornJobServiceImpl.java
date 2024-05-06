package com.ruoyi.robot.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.constant.ScheduleConstants;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.job.TaskException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.quartz.domain.SysJob;
import com.ruoyi.quartz.service.ISysJobService;
import com.ruoyi.quartz.util.CronUtils;
import com.ruoyi.quartz.util.QuartzJobExecution;
import com.ruoyi.quartz.util.ScheduleUtils;
import com.ruoyi.robot.api.request.TaskDoRequest;
import com.ruoyi.robot.api.service.RobotService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.stereotype.Service;
import com.ruoyi.robot.mapper.RRobotCornJobMapper;
import com.ruoyi.robot.domain.RRobotCornJob;
import com.ruoyi.robot.service.IRRobotCornJobService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * 机器人定时任务Service业务层处理
 *
 * @author ruoyi
 * @date 2023-04-17
 */
@Service
public class RRobotCornJobServiceImpl implements IRRobotCornJobService {
    @Autowired
    private RRobotCornJobMapper rRobotCornJobMapper;

    @Autowired
    private RobotService service;

    @Autowired
    private ISysJobService jobService;

    @Autowired
    private Scheduler scheduler;

    @PostConstruct
    public void init() throws SchedulerException
    {
        scheduler.clear();
        rRobotCornJobMapper.selectRRobotCornJobList(new RRobotCornJob()).forEach(it->{
            try {
                ScheduleUtils.createScheduleJob(scheduler,cornJobToSysJob(it));
            } catch (SchedulerException | TaskException e) {
                throw new RuntimeException(e);
            }
        });
    }


    /**
     * 查询机器人定时任务
     *
     * @param id 机器人定时任务主键
     * @return 机器人定时任务
     */
    @Override
    public RRobotCornJob selectRRobotCornJobById(Long id) {
        return rRobotCornJobMapper.selectRRobotCornJobById(id);
    }

    /**
     * 查询机器人定时任务列表
     *
     * @param rRobotCornJob 机器人定时任务
     * @return 机器人定时任务
     */
    @Override
    public List<RRobotCornJob> selectRRobotCornJobList(RRobotCornJob rRobotCornJob) {
        return rRobotCornJobMapper.selectRRobotCornJobList(rRobotCornJob);
    }

    /**
     * 新增机器人定时任务
     *
     * @param rRobotCornJob 机器人定时任务
     * @return 结果
     */
    @Override
    @Transactional
    public int insertRRobotCornJob(RRobotCornJob rRobotCornJob) {
        rRobotCornJob.setCreateTime(DateUtils.getNowDate());
        int i = rRobotCornJobMapper.insertRRobotCornJob(rRobotCornJob);
        SysJob sysJob = cornJobToSysJob(rRobotCornJob);
        try {
            ScheduleUtils.createScheduleJob(scheduler,sysJob);
        } catch (SchedulerException | TaskException e) {
            throw new ServiceException("定时任务添加失败 : "+e.getMessage());
        }
        return i;
    }

    private SysJob cornJobToSysJob(RRobotCornJob rRobotCornJob){
        SysJob sysJob = new SysJob();
        sysJob.setJobId(rRobotCornJob.getId());
        sysJob.setJobName(rRobotCornJob.getJobName());
        sysJob.setCronExpression(rRobotCornJob.getJobCorn());
        sysJob.setJobGroup("robot");
        sysJob.setInvokeTarget("rtask.doJob("+ rRobotCornJob.getId() +"L)");
        sysJob.setMisfirePolicy(ScheduleConstants.MISFIRE_FIRE_AND_PROCEED);
        sysJob.setConcurrent("1");
        sysJob.setStatus("0");
        return sysJob;
    }

    /**
     * 修改机器人定时任务
     *
     * @param rRobotCornJob 机器人定时任务
     * @return 结果
     */
    @Override
    public int updateRRobotCornJob(RRobotCornJob rRobotCornJob) {
        return rRobotCornJobMapper.updateRRobotCornJob(rRobotCornJob);
    }

    /**
     * 批量删除机器人定时任务
     *
     * @param ids 需要删除的机器人定时任务主键
     * @return 结果
     */
    @Override
    public int deleteRRobotCornJobByIds(Long[] ids) {
        return rRobotCornJobMapper.deleteRRobotCornJobByIds(ids);
    }

    /**
     * 删除机器人定时任务信息
     *
     * @param id 机器人定时任务主键
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteRRobotCornJobById(Long id) {
        try {
            scheduler.deleteJob(ScheduleUtils.getJobKey(id, "robot"));
        } catch (SchedulerException e) {
            throw new ServiceException("取消任务失败");
        }
        return rRobotCornJobMapper.deleteRRobotCornJobById(id);
    }
}
