import React, {useEffect, useState} from 'react';
import controlBackground from '../../assets/homePage/control-area.png';
import cycle from '../../assets/contro/cycle.png';
import up from '../../assets/contro/up.png';
import down from '../../assets/contro/down.png';
import left from '../../assets/contro/left.png';
import right from '../../assets/contro/right.png';
import './index.less';
import {ctrlPtz, getPtzInfo} from "../../api/robot";
import {PtzInfo, PtzResponse} from "../../utils/domin";
import {interval, intervalClear} from "../../utils/interval";
import Message from "../Message";

export default function ControlArea() {
    const [values, setValues] = useState<PtzInfo>({
        status: '良好',
        horizontalDeg: '20°',
        verticalDeg: '90°',
    })

    const [ptzInfo,setPtzInfo] = useState<PtzResponse>(null)

    const getInfo = () => {
        getPtzInfo().then(res => {
            const {data} = res
            setPtzInfo(data)
            setValues({
                status: data.online ? '良好' : '掉线',
                horizontalDeg: `${data.level}°`,
                verticalDeg: `${data.vertical}°`
            })
        })
    }

    useEffect(() => {
        getInfo()
        const timer = interval(getInfo, 2000)
        return () => {
            intervalClear(timer)
        }
    }, [])

    const angle = {
        'u':'上',
        'd':'下',
        'r':'右',
        'l':'左'
    }

    const handlePtzCtrl = (type:string ) => {
        let v  = ptzInfo.level
        let h  = ptzInfo.vertical
        switch (type){
            case 'u':
                h +=10
                break;
            case 'd':
                h -=10
                break;
            case 'l':
                v +=10
                break;
            case 'r':
                v -=10
                break;
            default:
                break
        }
        ctrlPtz({
            level:v,
            vertical:h
        }).then(res=>{
            if (res.data.ack == 0){
                Message.success(`向${angle[type]}移动 10 成功`)
            }
        })
    }

    return (
        <div className="control-area">
            <img alt="controlBackground" className="control-background" src={controlBackground}/>
            <div className="control-info">
                <div>在线状态：{values.status}</div>
                <div>水平角度：{values.horizontalDeg}</div>
                <div>垂直角度：{values.verticalDeg}</div>
            </div>
            <div className="rocking-bar">
                <span className="top">上</span>
                <span className="right">右</span>
                <span className="bottom">下</span>
                <span className="left">左</span>
                <div>
                    <img alt="topIcon" className="topIcon" src={up} onClick={()=>{handlePtzCtrl('u')}}/>
                    <img alt="leftIcon" className="leftIcon" src={left} onClick={()=>{handlePtzCtrl('l')}}/>
                    <img alt="rightIcon" className="rightIcon" src={right} onClick={()=>{handlePtzCtrl('r')}} />
                    <img alt="bottomIcon" className="bottomIcon" src={down} onClick={()=>{handlePtzCtrl('d')}}/>
                    <img alt="cycle" className="cycle" src={cycle} />
                </div>
            </div>
        </div>
    );
}
