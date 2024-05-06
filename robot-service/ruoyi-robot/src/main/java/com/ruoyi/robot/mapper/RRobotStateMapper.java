package com.ruoyi.robot.mapper;

import java.util.List;
import com.ruoyi.robot.domain.RRobotState;

/**
 * 机器人状态Mapper接口
 *
 * @author ruoyi
 * @date 2023-03-02
 */
public interface RRobotStateMapper
{
    /**
     * 查询机器人状态
     *
     * @param id 机器人状态主键
     * @return 机器人状态
     */
    public RRobotState selectRRobotStateById(Long id);

    public RRobotState selectNewstRRobotStateByRobotId(Long id);


    /**
     * 查询机器人状态列表
     *
     * @param rRobotState 机器人状态
     * @return 机器人状态集合
     */
    public List<RRobotState> selectRRobotStateList(RRobotState rRobotState);

    /**
     * 新增机器人状态
     *
     * @param rRobotState 机器人状态
     * @return 结果
     */
    public int insertRRobotState(RRobotState rRobotState);

    /**
     * 修改机器人状态
     *
     * @param rRobotState 机器人状态
     * @return 结果
     */
    public int updateRRobotState(RRobotState rRobotState);

    /**
     * 删除机器人状态
     *
     * @param id 机器人状态主键
     * @return 结果
     */
    public int deleteRRobotStateById(Long id);

    /**
     * 批量删除机器人状态
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRRobotStateByIds(Long[] ids);
}
