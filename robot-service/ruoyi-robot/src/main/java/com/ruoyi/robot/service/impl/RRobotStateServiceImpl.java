package com.ruoyi.robot.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.robot.mapper.RRobotStateMapper;
import com.ruoyi.robot.domain.RRobotState;
import com.ruoyi.robot.service.IRRobotStateService;

/**
 * 机器人状态Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-02
 */
@Service
public class RRobotStateServiceImpl implements IRRobotStateService 
{
    @Autowired
    private RRobotStateMapper rRobotStateMapper;

    /**
     * 查询机器人状态
     * 
     * @param id 机器人状态主键
     * @return 机器人状态
     */
    @Override
    public RRobotState selectRRobotStateById(Long id)
    {
        return rRobotStateMapper.selectRRobotStateById(id);
    }

    /**
     * 查询机器人状态列表
     * 
     * @param rRobotState 机器人状态
     * @return 机器人状态
     */
    @Override
    public List<RRobotState> selectRRobotStateList(RRobotState rRobotState)
    {
        return rRobotStateMapper.selectRRobotStateList(rRobotState);
    }

    /**
     * 新增机器人状态
     * 
     * @param rRobotState 机器人状态
     * @return 结果
     */
    @Override
    public int insertRRobotState(RRobotState rRobotState)
    {
        rRobotState.setCreateTime(DateUtils.getNowDate());
        return rRobotStateMapper.insertRRobotState(rRobotState);
    }

    /**
     * 修改机器人状态
     * 
     * @param rRobotState 机器人状态
     * @return 结果
     */
    @Override
    public int updateRRobotState(RRobotState rRobotState)
    {
        rRobotState.setUpdateTime(DateUtils.getNowDate());
        return rRobotStateMapper.updateRRobotState(rRobotState);
    }

    /**
     * 批量删除机器人状态
     * 
     * @param ids 需要删除的机器人状态主键
     * @return 结果
     */
    @Override
    public int deleteRRobotStateByIds(Long[] ids)
    {
        return rRobotStateMapper.deleteRRobotStateByIds(ids);
    }

    /**
     * 删除机器人状态信息
     * 
     * @param id 机器人状态主键
     * @return 结果
     */
    @Override
    public int deleteRRobotStateById(Long id)
    {
        return rRobotStateMapper.deleteRRobotStateById(id);
    }
}
