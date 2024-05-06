import React, {useEffect, useState } from "react";
import {Table,DatePicker,Space,Button, Form, Input } from "antd";
import { SearchOutlined } from '@ant-design/icons';
import {SensorLog} from "../../utils/domin";
import {ColumnsType} from "antd/lib/table/interface";
import dayjs from "dayjs";
import {getSensorInfo, getSensors} from "../../api/robot";
import moment from "moment";


export default function SensorTable(){
    const { RangePicker } = DatePicker;
    const [pageTotal,setpageTotal] = useState(0)
    const [sensors,setSensors] = useState<Array<SensorLog>>(null)
    const [queryParma,setQueryParma] = useState({
        pageNum:1,
        pageSize:10,
        orderByColumn:'create_time',
        isAsc:'desc',
        params:{
            startDate:'',
            endDate:''
        }
    })

    const [loading,setLoading] = useState(false)

    const showDate =(e)=>{
        setQueryParma({
            ...queryParma,
            params: {
                startDate: moment(e[0]._d).format('yyyy-MM-DD HH:mm:ss'),
                endDate: moment(e[1]._d).format('yyyy-MM-DD HH:mm:ss')
            }
        })
    }

    const getData = ()=>{
        setLoading(true)
        getSensorInfo(queryParma).then(res=>{
            console.log(res.rows)
            setSensors(res.rows)
            setpageTotal(res.total)
            setLoading(false)
        })
    }

    const pageOnChange = (val) => {
        setQueryParma({
            ...queryParma,
            pageNum: val
        })
    };
    const pageSizeChange = (page, pageSize : number) => {
        console.log(pageSize)
        setQueryParma({
            ...queryParma,
            pageSize
        })
    };

    useEffect(()=>{
        getData()
    },[queryParma])

    const columns : ColumnsType<SensorLog> = [
        {
            title: '采集日期',
            dataIndex: 'createTime',
            key: 'id',
            render:(v)=>{
              return dayjs(v).format('YYYY年MM月DD日')
            }
        },
        {
            title: '采集时间',
            dataIndex: 'createTime',
            key: 'id',
            render:(v)=>{
                return dayjs(v).format('HH时mm分ss秒')
            }
        },
        {
            title: '烟雾',
            key: 'id',
            render:(v,row)=>{
                return row.sensorInfos.filter(it=>it.type === 'smoke').map(it=>it.value.toFixed(2) + ' ppm')
            }
        },
        {
            title: '一氧化碳',
            key: 'id',
            render:(v,row)=>{
                return row.sensorInfos.filter(it=>it.type === 'co').map(it=>it.value.toFixed(2) + ' ppm')
            }
        },
        {
            title: '硫化氢',
            key: 'id',
            render:(v,row)=>{
                return row.sensorInfos.filter(it=>it.type === 'h2s').map(it=>it.value.toFixed(2) + ' ppm')
            }
        },
        {
            title: '甲烷',
            key: 'id',
            render:(v,row)=>{
                return row.sensorInfos.filter(it=>it.type === 'ch4').map(it=>it.value.toFixed(2) + ' %LEL')
            }
        },
        {
            title: '氢气',
            key: 'id',
            render:(v,row)=>{
                return row.sensorInfos.filter(it=>it.type === 'h2').map(it=>it.value.toFixed(2) + ' ppm')
            }
        },
        {
            title: '温度',
            key: 'id',
            render:(v,row)=>{
                return row.sensorInfos.filter(it=>it.type === 'temp').map(it=>it.value.toFixed(2) + ' ℃')
            }
        },
        {
            title: '湿度',
            key: 'id',
            render:(v,row)=>{
                return row.sensorInfos.filter(it=>it.type === 'humi').map(it=>it.value.toFixed(2) + ' %RH')
            }
        },
        {
            title: '噪音',
            key: 'id',
            render:(v,row)=>{
                return row.sensorInfos.filter(it=>it.type === 'noise').map(it=>it.value.toFixed(2) + ' dB')
            }
        },
    ]

    return(
        <div>
            <Form
                name="basic"
                labelCol={{ span: 8 }}
                wrapperCol={{ span: 16 }}
                style={{ maxWidth: 600 ,display:"flex",marginLeft:"20px"}}
                initialValues={{ remember: true }}
                autoComplete="off"
            >
                <Form.Item
                >
                    <Space direction="vertical" size={12}>
                        <RangePicker onChange={showDate} />
                    </Space>
                </Form.Item>

                <Form.Item wrapperCol={{ offset: 8, span: 16 }}>
                    <Button type="primary" shape="circle" icon={<SearchOutlined />} htmlType="submit" style={{marginLeft:"-50px"}}/>

                </Form.Item>
            </Form>
            <Table
                columns={columns}
                dataSource={sensors}
                loading={loading}
                pagination={{
                    hideOnSinglePage: false, // 只有一页时不显示分页
                    showTotal: () => `共 ${pageTotal} 条`, // 显示总共有多少条
                    total: pageTotal, // 总共有多少条
                    onChange: pageOnChange, // 页码变化回调函数
                    showQuickJumper: false, // 是否显示快速跳转
                    defaultPageSize:10,
                    showSizeChanger: true,  // 是否显示页面大小变化选择框
                    onShowSizeChange: pageSizeChange,  // 页面大小变化回调函数
                    pageSizeOptions: ["10", "20" , "50"],  // 页面大小变化选择框中可选变化
                }}
            />
        </div>
    )
}
