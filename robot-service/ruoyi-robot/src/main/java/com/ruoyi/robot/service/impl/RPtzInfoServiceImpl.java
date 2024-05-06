package com.ruoyi.robot.service.impl;

import java.math.BigDecimal;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.robot.api.response.PtzInfo;
import com.ruoyi.robot.api.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.robot.mapper.RPtzInfoMapper;
import com.ruoyi.robot.domain.RPtzInfo;
import com.ruoyi.robot.service.IRPtzInfoService;

/**
 * ptz信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-02
 */
@Service
public class RPtzInfoServiceImpl implements IRPtzInfoService
{
    @Autowired
    private RPtzInfoMapper rPtzInfoMapper;

    @Autowired
    private RobotService robotService;

    /**
     * 查询ptz信息
     *
     * @param id ptz信息主键
     * @return ptz信息
     */
    @Override
    public RPtzInfo selectRPtzInfoById(Long id)
    {
        return rPtzInfoMapper.selectRPtzInfoById(id);
    }

    public void importRPtzInfoFormAgv(){
        PtzInfo ptzInfo = robotService.getPtzInfo();
        RPtzInfo ptz = new RPtzInfo();
        ptz.setOnline(ptzInfo.isOnline() ? 1 : 0);
        ptz.setLevel(BigDecimal.valueOf(ptzInfo.getLevel()));
        ptz.setVertical(BigDecimal.valueOf(ptzInfo.getVertical()));
        List<RPtzInfo> rPtzInfos = rPtzInfoMapper.selectRPtzInfoList(new RPtzInfo());
        if (rPtzInfos.isEmpty()){
            rPtzInfoMapper.insertRPtzInfo(ptz);
        }else {
            ptz.setId(rPtzInfos.get(0).getId());
            rPtzInfoMapper.updateRPtzInfo(ptz);
        }
    }

    /**
     * 查询ptz信息列表
     *
     * @param rPtzInfo ptz信息
     * @return ptz信息
     */
    @Override
    public List<RPtzInfo> selectRPtzInfoList(RPtzInfo rPtzInfo)
    {
        return rPtzInfoMapper.selectRPtzInfoList(rPtzInfo);
    }

    /**
     * 新增ptz信息
     *
     * @param rPtzInfo ptz信息
     * @return 结果
     */
    @Override
    public int insertRPtzInfo(RPtzInfo rPtzInfo)
    {
        rPtzInfo.setCreateTime(DateUtils.getNowDate());
        return rPtzInfoMapper.insertRPtzInfo(rPtzInfo);
    }

    /**
     * 修改ptz信息
     *
     * @param rPtzInfo ptz信息
     * @return 结果
     */
    @Override
    public int updateRPtzInfo(RPtzInfo rPtzInfo)
    {
        rPtzInfo.setUpdateTime(DateUtils.getNowDate());
        return rPtzInfoMapper.updateRPtzInfo(rPtzInfo);
    }

    /**
     * 批量删除ptz信息
     *
     * @param ids 需要删除的ptz信息主键
     * @return 结果
     */
    @Override
    public int deleteRPtzInfoByIds(Long[] ids)
    {
        return rPtzInfoMapper.deleteRPtzInfoByIds(ids);
    }

    /**
     * 删除ptz信息信息
     *
     * @param id ptz信息主键
     * @return 结果
     */
    @Override
    public int deleteRPtzInfoById(Long id)
    {
        return rPtzInfoMapper.deleteRPtzInfoById(id);
    }
}
