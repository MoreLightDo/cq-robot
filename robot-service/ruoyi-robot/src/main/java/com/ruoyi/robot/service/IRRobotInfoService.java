package com.ruoyi.robot.service;

import java.util.List;
import com.ruoyi.robot.domain.RRobotInfo;

/**
 * 机器人信息Service接口
 *
 * @author ruoyi
 * @date 2023-03-02
 */
public interface IRRobotInfoService
{
    /**
     * 查询机器人信息
     *
     * @param id 机器人信息主键
     * @return 机器人信息
     */
    public RRobotInfo selectRRobotInfoById(Long id);

    public void importRRobotInfoFormAgv();

    /**
     * 查询机器人信息列表
     *
     * @param rRobotInfo 机器人信息
     * @return 机器人信息集合
     */
    public List<RRobotInfo> selectRRobotInfoList(RRobotInfo rRobotInfo);

    /**
     * 新增机器人信息
     *
     * @param rRobotInfo 机器人信息
     * @return 结果
     */
    public int insertRRobotInfo(RRobotInfo rRobotInfo);

    /**
     * 修改机器人信息
     *
     * @param rRobotInfo 机器人信息
     * @return 结果
     */
    public int updateRRobotInfo(RRobotInfo rRobotInfo);

    /**
     * 批量删除机器人信息
     *
     * @param ids 需要删除的机器人信息主键集合
     * @return 结果
     */
    public int deleteRRobotInfoByIds(Long[] ids);

    /**
     * 删除机器人信息信息
     *
     * @param id 机器人信息主键
     * @return 结果
     */
    public int deleteRRobotInfoById(Long id);
}
