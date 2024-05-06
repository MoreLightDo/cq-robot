package com.ruoyi.robot.mapper;

import java.util.List;
import com.ruoyi.robot.domain.RSensorInfo;

/**
 * 传感器信息Mapper接口
 *
 * @author ruoyi
 * @date 2023-03-02
 */
public interface RSensorInfoMapper
{
    /**
     * 查询传感器信息
     *
     * @param id 传感器信息主键
     * @return 传感器信息
     */
    public RSensorInfo selectRSensorInfoById(Long id);

    /**
     * 查询传感器信息列表
     *
     * @param rSensorInfo 传感器信息
     * @return 传感器信息集合
     */
    public List<RSensorInfo> selectRSensorInfoList(RSensorInfo rSensorInfo);

    /**
     * 新增传感器信息
     *
     * @param rSensorInfo 传感器信息
     * @return 结果
     */
    public int insertRSensorInfo(RSensorInfo rSensorInfo);

    public int insertRSensorInfos(List<RSensorInfo> rSensorInfos);

    /**
     * 修改传感器信息
     *
     * @param rSensorInfo 传感器信息
     * @return 结果
     */
    public int updateRSensorInfo(RSensorInfo rSensorInfo);

    /**
     * 删除传感器信息
     *
     * @param id 传感器信息主键
     * @return 结果
     */
    public int deleteRSensorInfoById(Long id);

    /**
     * 批量删除传感器信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRSensorInfoByIds(Long[] ids);
}
