import React, {useEffect, useState} from 'react';
import { Table } from 'antd';
import warningInfo from '../../assets/homePage/warning-info.png';
import './index.less';
import {getAlarmLog} from "../../api/robot";
import {AlarmLog} from "../../utils/domin";
import {useAppDispatch, useAppSelector} from "../../redux/store";
import {updateAlertLog} from "../../redux/reducers/RobotReducer";
import {ColumnsType} from "antd/es/table";
import dayjs from "dayjs";

const columns :ColumnsType<AlarmLog> = [
  {
    title: '序号',
    dataIndex: 'index',
    width: 100,
  },
  {
    title: '识别时间',
    dataIndex: 'createTime',
    render:(value)=>{
      return dayjs(value).format("YYYY-MM-DD HH:mm:ss")
    },
    width: 200,
  },
  {
    title: '巡检项',
    dataIndex: ['rule','label'],
    width: 200,
  },
  {
    title: '参数',
    dataIndex: 'alarmValue',
    width: 100,
  },
  {
    title: '巡检结果',
    dataIndex: 'message',
    width: 200,
  },
  {
    title: '预警等级',
    dataIndex: ['rule','alarmLevel'],
    width: 100,
  },
  {
    title: '操作',
    dataIndex: 'address4',
    width: 200,
  },
];

export default function WarningInfoList() {

  const [query,setQuery] = useState({
    pageNum:1,
    pageSize:10
  })

  const selectd = useAppSelector(state => state.robot.selectd);

  const dispatch = useAppDispatch();

  const [data,setData] = useState<Array<AlarmLog>>()

  const getLogList = () => {
    getAlarmLog(query).then(res=>{
      setData(res.rows.map((it,k)=>({
        ...it,
        index:k+1
      })))
    })
  }

  useEffect(()=>{
    if (selectd){
      getLogList()
      dispatch(updateAlertLog(false))
    }
  },[selectd])

  useEffect(()=>{
    getLogList()
  },[])

  return (
    <div className="warning-info">
      <img alt="warningInfo" src={warningInfo} className="warning-info-background" />
      <Table
        rowKey={(item) => item.id}
        dataSource={data}
        columns={columns}
        pagination={false}
        className="warning-info-table"
        size="small"
        bordered={false}
        scroll={{ y: 161 }}
      />
    </div>
  );
}
