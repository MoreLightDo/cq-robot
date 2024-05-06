package com.ruoyi.robot.mapper;

import java.util.List;
import com.ruoyi.robot.domain.RTaskLog;

/**
 * 任务日志Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-02
 */
public interface RTaskLogMapper 
{
    /**
     * 查询任务日志
     * 
     * @param id 任务日志主键
     * @return 任务日志
     */
    public RTaskLog selectRTaskLogById(Long id);

    /**
     * 查询任务日志列表
     * 
     * @param rTaskLog 任务日志
     * @return 任务日志集合
     */
    public List<RTaskLog> selectRTaskLogList(RTaskLog rTaskLog);

    /**
     * 新增任务日志
     * 
     * @param rTaskLog 任务日志
     * @return 结果
     */
    public int insertRTaskLog(RTaskLog rTaskLog);

    /**
     * 修改任务日志
     * 
     * @param rTaskLog 任务日志
     * @return 结果
     */
    public int updateRTaskLog(RTaskLog rTaskLog);

    /**
     * 删除任务日志
     * 
     * @param id 任务日志主键
     * @return 结果
     */
    public int deleteRTaskLogById(Long id);

    /**
     * 批量删除任务日志
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRTaskLogByIds(Long[] ids);
}
