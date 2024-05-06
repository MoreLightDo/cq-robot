package com.ruoyi.robot.mapper;

import java.util.List;
import com.ruoyi.robot.domain.RPtzInfo;

/**
 * ptz信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-02
 */
public interface RPtzInfoMapper 
{
    /**
     * 查询ptz信息
     * 
     * @param id ptz信息主键
     * @return ptz信息
     */
    public RPtzInfo selectRPtzInfoById(Long id);

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
     * 删除ptz信息
     * 
     * @param id ptz信息主键
     * @return 结果
     */
    public int deleteRPtzInfoById(Long id);

    /**
     * 批量删除ptz信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRPtzInfoByIds(Long[] ids);
}
