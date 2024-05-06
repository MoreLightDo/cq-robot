import React, {useEffect, useState } from "react";
import {Button, Form, FormInstance, Input, InputNumber, Modal, Select, Space, Table} from "antd";
import {AlarmLogRule} from "../../utils/domin";
import {getAlarmTablerule, update} from "../../api/robot";
import Message from "../Message";


export default function AlarmTableRule(){
    const [datarule,setDatarule] = useState<Array<AlarmLogRule>>(null)
    const [alarmValue,setAlarmValue] = useState(0)
    const [editId,setEditId] = useState(null)
    const [isModifyModalOpen, setIsModifyModalOpen] = useState(false);
    const formRef = React.createRef<FormInstance>()




    const handleModifyCancel = () => {
        setIsModifyModalOpen(false);
        setAlarmValue(0)
        setEditId(null)
    };

    const editAlarmTablerule = (a:AlarmLogRule) =>{
        setIsModifyModalOpen(true);
        setAlarmValue(a.alarmValue)
        setEditId(a.id)
            formRef.current.setFieldsValue({
                alarmValue:a.alarmValue
            })
    };

    const getDatarule = () =>{
        getAlarmTablerule().then(r =>{
            setDatarule(r.data)
        })
    };

    const handleModifyOk = () => {

        const alarmData = formRef.current.getFieldsValue(true)
        // 调用接口修改
        update({id:editId,alarmValue:alarmData.alarmValue}).then(res=> {
            Message.success("修改成功")
            setEditId(null)
            getDatarule()
            setIsModifyModalOpen(false);
        })
    };

    useEffect(()=>{
        if (alarmValue!=0){
            setIsModifyModalOpen(true)
        }
    },[alarmValue])

    useEffect(()=>{
        getDatarule()
    },[])

    const columnsrule = [
        {
            title: '标题',
            dataIndex: 'label',
            key: 'label',
        },
        {
            title: '类型',
            dataIndex: 'type',
            key: 'type',
        },
        {
            title: '阈值',
            dataIndex: 'alarmValue',
            key: 'alarmValue',
        },
        {
            title: '单位',
            dataIndex: 'alarmUnit',
            key: 'alarmUnit',
        },
        {
            title: '级别',
            dataIndex: 'alarmLevel',
            key: 'alarmLevel',
        },
        {
            title: '操作',
            key: 'action',
            render: (text,record) => (
                <Space size="middle">
                    <a onClick={()=>editAlarmTablerule(record)}>修改</a>
                </Space>
            ),
        },
    ];


    return(

        <div>
            <Table
                columns={columnsrule}
                dataSource={datarule}
                className="warning-info-table"
                bordered={false}
            />

            <Modal title="修改"
                   open={isModifyModalOpen}
                   onOk={handleModifyOk}
                   onCancel={handleModifyCancel}
                   width="600px"
                   forceRender
            >

                { alarmValue !== null  ?  (
                        <Form
                            ref={formRef}
                            name="修改阈值"
                            labelCol={{ span: 8 }}
                            wrapperCol={{ span: 16 }}
                            style={{ maxWidth: 600 }}
                            autoComplete="off"
                        >

                            <Form.Item
                                label={<label style={{color:"white"}}>阈值</label>}
                                name="alarmValue"
                                rules={[{ required: true}]}

                            >
                                <input type="number"/>
                            </Form.Item>
                        </Form> )
                    :(
                        <div>空</div>
                    ) }

            </Modal>
        </div>

    )
}
