package com.ruoyi.robot.service;

import java.util.List;
import com.ruoyi.robot.domain.RPtzInfo;

/**
 * ptz信息Service接口
 *
 * @author ruoyi
 * @date 2023-03-02
 */
public interface IRPtzInfoService
{
    /**
     * 查询ptz信息
     *
     * @param id ptz信息主键
     * @return ptz信息
     */
    public RPtzInfo selectRPtzInfoById(Long id);

    public void importRPtzInfoFormAgv();

    /**
     * 查询ptz信息列表
     *
     * @param rPtzInfo ptz信息
     * @return ptz信息集合
     */
    public List<RPtzInfo> selectRPtzInfoList(RPtzInfo rPtzInfo);

    /**
     * 新增ptz信息
     *
     * @param rPtzInfo ptz信息
     * @return 结果
     */
    public int insertRPtzInfo(RPtzInfo rPtzInfo);

    /**
     * 修改ptz信息
     *
     * @param rPtzInfo ptz信息
     * @return 结果
     */
    public int updateRPtzInfo(RPtzInfo rPtzInfo);

    /**
     * 批量删除ptz信息
     *
     * @param ids 需要删除的ptz信息主键集合
     * @return 结果
     */
    public int deleteRPtzInfoByIds(Long[] ids);

    /**
     * 删除ptz信息信息
     *
     * @param id ptz信息主键
     * @return 结果
     */
    public int deleteRPtzInfoById(Long id);
}
