import React, {useCallback, useEffect, useState} from "react";
import {Button, Form, Input, Modal, Space, Table} from "antd";
import dayjs from "dayjs";
import './alarmTable.less';
import {AlarmLog, AlarmLogRule} from "../../utils/domin";
import {getAlarmLog, getAlarmTablerule} from "../../api/robot";
import AlarmTableRule from "./alarmTableRule";

export function AlarmTable(){
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [data,setData] = useState<Array<AlarmLog>>(null)
    const [pageTotal,setpageTotal] = useState(0)
    const [queryParma,setQueryParma] = useState({
        pageNum:1,
        pageSize:10
    })

    const showModal = () => {
        setIsModalOpen(true);
    };

    const handleOk = () => {
        setIsModalOpen(false);
    };

    const handleCancel = () => {
        setIsModalOpen(false);
    };

    const pageOnChange = (val) => {
       setQueryParma({
           ...queryParma,
           pageNum: val
       })
    };
    const pageSizeChange = (page, pageSize) => {
        setQueryParma({
            ...queryParma,
            pageSize
        })
    };

    const getData = useCallback(() => {
        getAlarmLog(queryParma).then(r => {
            setData(r.rows)
            setpageTotal(r.total)
        })
    },[queryParma])

    const getDatarule = () =>{
        showModal()
    };

    const onFinish = (values: any) => {

        console.log('Success:', values);
    }; // 修改上传

    const onFinishFailed = (errorInfo: any) => {
        console.log('Failed:', errorInfo);
    };

    // const Total = data.total

    useEffect(()=>{
        getData()

    },[])

    const columns = [
        {
            title: '预警id',
            dataIndex: 'ruleId',
            key: 'ruleId',
        },
        {
            title: '预警值',
            dataIndex: 'alarmValue',
            key: 'alarmValue',
        },
        {
            title: '预警信息',
            dataIndex: 'message',
            key: 'message',
        },
        {
            title: '触发日期',
            dataIndex: 'createTime',
            key: 'createTime',
            render:(v,row,index)=>{
                const day = dayjs(v)
                return day.format('YYYY年MM月DD日');
            }
        },
        {
            title: '触发时间',
            dataIndex: 'createTime',
            key: 'createTime',
            render:(v,row,index)=>{
                const day = dayjs(v)
                return day.format('HH时mm分ss秒');
            }
        },
    ];

    return(
        <div>
            <Button onClick={getDatarule}>编辑预警规则</Button>
            <Table
                columns={columns}
                dataSource={data}
                className="warning-info-table"
                bordered={false}
                pagination={{
                    hideOnSinglePage: false, // 只有一页时不显示分页
                    showTotal: () => `共 ${pageTotal} 条`, // 显示总共有多少条
                    total: pageTotal, // 总共有多少条
                    onChange: pageOnChange, // 页码变化回调函数
                    showQuickJumper: false, // 是否显示快速跳转
                    defaultPageSize:10,
                    showSizeChanger: true,  // 是否显示页面大小变化选择框
                    onShowSizeChange: pageSizeChange,
                    pageSizeOptions: ["10", "20", "50"],  // 页面大小变化选择框中可选变化
                }}
            />
            <Modal title="预警规则修改"
                   open={isModalOpen}
                   onOk={handleOk}
                   onCancel={handleCancel}
                   width="1200px"
            >
               <AlarmTableRule/>
            </Modal>



        </div>
    )
}
