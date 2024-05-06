package com.ruoyi.robot.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.robot.mapper.RRobotEmcyMapper;
import com.ruoyi.robot.domain.RRobotEmcy;
import com.ruoyi.robot.service.IRRobotEmcyService;

/**
 * 应急Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-02
 */
@Service
public class RRobotEmcyServiceImpl implements IRRobotEmcyService 
{
    @Autowired
    private RRobotEmcyMapper rRobotEmcyMapper;

    /**
     * 查询应急
     * 
     * @param id 应急主键
     * @return 应急
     */
    @Override
    public RRobotEmcy selectRRobotEmcyById(Long id)
    {
        return rRobotEmcyMapper.selectRRobotEmcyById(id);
    }

    /**
     * 查询应急列表
     * 
     * @param rRobotEmcy 应急
     * @return 应急
     */
    @Override
    public List<RRobotEmcy> selectRRobotEmcyList(RRobotEmcy rRobotEmcy)
    {
        return rRobotEmcyMapper.selectRRobotEmcyList(rRobotEmcy);
    }

    /**
     * 新增应急
     * 
     * @param rRobotEmcy 应急
     * @return 结果
     */
    @Override
    public int insertRRobotEmcy(RRobotEmcy rRobotEmcy)
    {
        rRobotEmcy.setCreateTime(DateUtils.getNowDate());
        return rRobotEmcyMapper.insertRRobotEmcy(rRobotEmcy);
    }

    /**
     * 修改应急
     * 
     * @param rRobotEmcy 应急
     * @return 结果
     */
    @Override
    public int updateRRobotEmcy(RRobotEmcy rRobotEmcy)
    {
        rRobotEmcy.setUpdateTime(DateUtils.getNowDate());
        return rRobotEmcyMapper.updateRRobotEmcy(rRobotEmcy);
    }

    /**
     * 批量删除应急
     * 
     * @param ids 需要删除的应急主键
     * @return 结果
     */
    @Override
    public int deleteRRobotEmcyByIds(Long[] ids)
    {
        return rRobotEmcyMapper.deleteRRobotEmcyByIds(ids);
    }

    /**
     * 删除应急信息
     * 
     * @param id 应急主键
     * @return 结果
     */
    @Override
    public int deleteRRobotEmcyById(Long id)
    {
        return rRobotEmcyMapper.deleteRRobotEmcyById(id);
    }
}
