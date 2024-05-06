package com.ruoyi.robot.service;

import java.util.List;
import com.ruoyi.robot.domain.RRobotEmcy;

/**
 * 应急Service接口
 * 
 * @author ruoyi
 * @date 2023-03-02
 */
public interface IRRobotEmcyService 
{
    /**
     * 查询应急
     * 
     * @param id 应急主键
     * @return 应急
     */
    public RRobotEmcy selectRRobotEmcyById(Long id);

    /**
     * 查询应急列表
     * 
     * @param rRobotEmcy 应急
     * @return 应急集合
     */
    public List<RRobotEmcy> selectRRobotEmcyList(RRobotEmcy rRobotEmcy);

    /**
     * 新增应急
     * 
     * @param rRobotEmcy 应急
     * @return 结果
     */
    public int insertRRobotEmcy(RRobotEmcy rRobotEmcy);

    /**
     * 修改应急
     * 
     * @param rRobotEmcy 应急
     * @return 结果
     */
    public int updateRRobotEmcy(RRobotEmcy rRobotEmcy);

    /**
     * 批量删除应急
     * 
     * @param ids 需要删除的应急主键集合
     * @return 结果
     */
    public int deleteRRobotEmcyByIds(Long[] ids);

    /**
     * 删除应急信息
     * 
     * @param id 应急主键
     * @return 结果
     */
    public int deleteRRobotEmcyById(Long id);
}
