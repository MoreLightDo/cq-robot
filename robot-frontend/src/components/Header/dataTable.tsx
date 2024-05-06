import {Col, Menu, Row, Table} from "antd";
import React, {useCallback, useEffect, useState} from "react";
import {ColumnsType} from "antd/es/table";
import dayjs from "dayjs";
import {AlarmLog} from "../../utils/domin";
import {getAlarmLog} from "../../api/robot";
import {AlarmTable} from "./alarmTable";
import SensorTable from "./sensorTable";
import './dataTable.less'

export default function DataTable(){



    const [type,setType] = useState('1')

    const item = [
        {
            key:'1',
            label:'预警数据'
        },
        {
            key:'2',
            label:'传感器信息'
        }
    ]

    return(
        <div className="ant-modal-content" >
            <Row >
                <Col span={2} >
                    <Menu onClick={(e)=>setType(e.key)} defaultSelectedKeys={['1']} items={item}/>
                </Col>
                <Col span={20}>
                    {
                        type==='1'?<AlarmTable/>:<SensorTable/>
                    }
                </Col>
            </Row>
        </div>
    )

}
