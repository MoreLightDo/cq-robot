import React, {useEffect, useRef, useState} from 'react';
import {Button, Modal, Dropdown, message, Space} from 'antd';
import {CloseCircleTwoTone, EllipsisOutlined, UserOutlined} from '@ant-design/icons'
import type {MenuProps} from 'antd';
import Message from '../Message';
import {useDateAndTime} from '../../hooks';
import title from '../../assets/homePage/title.png';
import settingPng from '../../assets/center/setting.png';
import {logout} from '../../api/login';
import {getToken, removeToken} from '../../utils/auth'
import history from '../../utils/history';
import './index.less';
import DataTable from './dataTable';
import {useAppDispatch} from "../../redux/store";
import {updateAlertLog} from "../../redux/reducers/RobotReducer";


export default function Header() {
    const {date, time, day} = useDateAndTime();
    const [open, setopen] = useState(false);
    const [isModalOpen, setIsModalOpen] = useState(false);

    const ws = useRef<WebSocket>(null)

    const websocketUrl = "ws://192.168.1.35:8080/websocket/message"

    const dispatch = useAppDispatch()

    const [show,setShow] = useState(false)

    const handleMsg = (data) => {
        if (!show){
            Message.error(data)
            setShow(false)
        }
        dispatch(updateAlertLog(true))
    }

    const connectWeb = () => {
        ws.current = new WebSocket(websocketUrl)
        ws.current.onopen = function (event) {
            ws.current.send(`token:${  getToken()}`)
        };
        ws.current.onmessage = function (event) {
            const msg = event.data;
            handleMsg(msg)
        };
        ws.current.onclose = function (event) {

        };
    }

    const items = [
        {
            label: '1',
            key: '1',
        },
        {
            label: '2',
            key: '2',
        },
        {
            label: '退出',
            key: '3',
        },
    ];
    const onClick: MenuProps['onClick'] = ({key}) => {
        if (key === '3') {
            showModal()
            // handleLogout();
            // message.info(`退出成功`);
        }
        ;
    };

    const showModal = () => {
        setIsModalOpen(true);
    };

    const handleOk = () => {
        setIsModalOpen(false);
    };

    const handleCancel = () => {
        setIsModalOpen(false);
    };


    const handleLogout = () => {
        logout().then(() => {
            removeToken();
            history.push('/login')
            message.success(`退出成功`);
        }).catch(() => {
            Message.error('退出失败')
        })
    };

    useEffect(()=>{
        connectWeb()
    },[])


    return (
        <div className="header">
            <img src={title} alt="title" className="title"/>
            <div className="date-time-day">
                <span style={{width: '100px'}}>{date}</span>
                <span style={{width: '70px'}}>{time}</span>
                <span style={{width: '60px'}}>{day}</span>
            </div>
            <div className="right-area"><Button className="button-default" onClick={() => {
                    const w = window.open('_black')
                    w.location.href = 'http://192.168.1.21:10001'
                }}>智能群控系统</Button>

                <Button className="button-default" onClick={() => setopen(true)}>数据记录</Button>

                <Dropdown menu={{items, onClick}} trigger={['click']} className="dropdownPop">
                    <Button icon={<UserOutlined style={{fontSize: '32px'}}/>} type="link">
                        <div style={{background: '#fff'}}></div>
                    </Button>
                </Dropdown>

                <Modal
                    width='80%'
                    open={open}
                    onCancel={() => setopen(false)}
                    footer={[]}
                    closeIcon={<CloseCircleTwoTone style={{fontSize: '35px'}}/>}
                >


                    <DataTable/>
                </Modal>

                <Modal
                    className="modal-style"
                    bodyStyle={{color: '#fff'}}
                    closable={false}
                    open={isModalOpen}
                    onOk={handleOk}
                    onCancel={handleCancel}
                    footer={[
                        <Button
                            key="back"
                            onClick={handleCancel}
                            type="text"
                            style={{color: '#fff'}}>
                            取消
                        </Button>,
                        <Button
                            type="text"
                            onClick={handleLogout}
                            style={{color: '#fff'}}
                        >
                            确定
                        </Button>
                    ]}
                >
                    <p style={{textAlign: 'center'}}>确认退出登录么</p>
                </Modal>

            </div>


        </div>


    );
}
