import React, {useContext, useEffect, useRef, useState} from 'react';
import leftStatus from '../../assets/homePage/left-status.png';
import rightStatus from '../../assets/homePage/right-status.png';
import status from '../../assets/icons/status.png';
import number from '../../assets/icons/number.png';
import battery from '../../assets/icons/battery.png';
import speed from '../../assets/icons/speed.png';
import direction from '../../assets/icons/direction.png';
import clock from '../../assets/icons/clock.png';
import temp from '../../assets/icons/temp.png';
import wet from '../../assets/icons/wet.png';
import smoke from '../../assets/icons/smoke.png';
import voice from '../../assets/icons/voice.png';
import co from '../../assets/icons/co.png';
import h2s from '../../assets/icons/h2s.png';
import ch4 from '../../assets/icons/ch4.png';
import h2 from '../../assets/icons/h2.png'

import './index.less';
import {getAgvInfo, getSensors} from "../../api/robot";
import {RobotObject, Sensors} from "../../utils/domin";
import {useAppSelector} from "../../redux/store";


export default function HomePageStatus() {

    const [robotInfo, setRobotInfo] = useState<RobotObject>(null)

    const [sensors, setSensors] = useState<Sensors>(null)

    const robotState = useAppSelector((state)=>state.robot.robotInfo)

    const sensorsState = useAppSelector((state)=>state.robot.sensors)

    useEffect(()=>{
        setRobotInfo(robotState)
        setSensors(sensorsState)
    },[robotState,sensorsState])

    const [statusOne, setStatusOne] = useState([
        {
            icon: status,
            label: '工作状态',
            value: '巡检中',
        },
        {
            icon: number,
            label: '机器人编号',
            value: '2021123104',
        },
        {
            icon: battery,
            label: '当前电量',
            value: '92%',
        },
        {
            icon: speed,
            label: '行驶速度',
            value: '0.00m/s',
        },
        {
            icon: direction,
            label: '导航状态',
            value: '导航中',
        },
        {
            icon: clock,
            label: '本次运行时长',
            value: '8天20小时',
        },
    ]);

    const [statusTwo, setStateTwo] = useState([
        {
            icon: temp,
            label: '温度',
            value: '20°',
        },
        {
            icon: wet,
            label: '湿度',
            value: '12%RH',
        },
        {
            icon: smoke,
            label: '烟雾',
            value: '14/ppm',
        },
        {
            icon: voice,
            label: '噪声',
            value: '30/dB',
        },
        {
            icon: co,
            label: '一氧化碳',
            value: '11/PPM',
        },
        {
            icon: h2s,
            label: '硫化氢',
            value: '16/PPM',
        },
        {
            icon: ch4,
            label: '甲烷',
            value: '10%LEL',
        },
        {
            icon: ch4,
            label: '氢气',
            value: '10%LEL',
        },
    ]);

    useEffect(() => {
        if (robotInfo == null) {
            return
        }
        setStatusOne(
            [
                {
                    icon: status,
                    label: '工作状态',
                    value: robotInfo.state.name,
                },
                {
                    icon: number,
                    label: '机器人编号',
                    value: robotInfo.robot_id,
                },
                {
                    icon: battery,
                    label: '当前电量',
                    value: `${robotInfo.battery.soc}%`,
                },
                {
                    icon: speed,
                    label: '行驶速度',
                    value: `${robotInfo.motion.vel.x.toFixed(1)}m/s`,
                },
                {
                    icon: direction,
                    label: '导航状态',
                    value: robotInfo.motion.in_nav ? '导航中' : '无信号',
                },
                {
                    icon: clock,
                    label: '本次运行时长',
                    value: `${Math.trunc(robotInfo.statistics.this_on_time/60/60/24)}天${Math.trunc(robotInfo.statistics.this_on_time%86400/60/60)}小时`,
                },
            ]
        )

    }, [robotInfo])

    useEffect(() => {
        if (sensors == null) {
            return
        }
        setStateTwo([
            {
                icon: temp,
                label: '温度',
                value: `${sensors.temp.value.toFixed(2)}°`,
            },
            {
                icon: wet,
                label: '湿度',
                value: `${sensors.humi.value.toFixed(2)}%RH`,
            },
            {
                icon: smoke,
                label: '烟雾',
                value: `${sensors.smoke.value.toFixed(2)}/ppm`,
            },
            {
                icon: voice,
                label: '噪声',
                value: `${sensors.noise.value.toFixed(2)}/dB`,
            },
            {
                icon: co,
                label: '一氧化碳',
                value: `${sensors.co.value.toFixed(2)}/PPM`,
            },
            {
                icon: h2s,
                label: '硫化氢',
                value: `${sensors.h2s.value.toFixed(2)}/PPM`,
            },
            {
                icon: ch4,
                label: '甲烷',
                value: `${sensors.ch4.value.toFixed(2)}%LEL`,
            },
            {
                icon: h2,
                label: '氢气',
                value: `${(sensors.h2.value/400).toFixed(2)}%LEL`,
            },
        ])
    },[sensors])

    return (
        <div className="home-page-status">
            <div className="status1">
                <img alt="leftStatus" src={leftStatus} className="status-background"/>
                {statusOne.map((item, i) => (
                    <div key={i} className="status-item">
                        <div className="status-item-label">
                            <img alt={item.label} src={item.icon}/>
                            <span>{item.label}</span>
                        </div>
                        <div className="status-item-value">{item.value}</div>
                    </div>
                ))}
                <span className="status1-label">机器人状态</span>
            </div>
            <div className="status2">
                <img alt="rightStatus" src={rightStatus} className="status-background"/>
                {statusTwo.map((item, i) => (
                    <div key={i} className="status-item">
                        <div className="status-item-label">
                            <img alt={item.label} src={item.icon}/>
                            <span>{item.label}</span>
                        </div>
                        <div className="status-item-value">{item.value}</div>
                    </div>
                ))}
                <span className="status2-label">环境信息</span>
            </div>
        </div>
    );
}
