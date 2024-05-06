import React, {useCallback, useEffect, useRef, useState} from 'react';
import {CloseCircleTwoTone} from '@ant-design/icons'
import cls from 'classnames';
import {Player, ControlBar, BigPlayButton} from 'video-react'
import {Image, Modal} from "antd";
import videoArea from '../../assets/homePage/video-area.png';
import videoBack from '../../assets/homePage/video-back.png';
import FlvJs from "flv.js";
import './index.less';
import "video-react/dist/video-react.css"
import VideoBack from "../VideoBack";
import {interval, intervalClear} from "../../utils/interval";

export default function VideoSelect() {
    const values = [
        {label: '云台可见光成像', value: "http://123.249.6.197:18000/live/video.flv", type: 1},
        {label: '云台红外光成像', value: "http://123.249.6.197:18000/live/infrared.flv", type: 1},
        {label: '双目摄像机', value: "http://123.249.6.197:18000/live/camera.flv", type: 1},
        {label: '视频回放', value: "", type: 0},
    ];
    const [activeVideo, setActiveVideo] = useState({
        label: '云台可见光成像',
        value: ""
    });

    const [open, setOpen] = useState(false);

    const [open2, setOpen2] = useState(false)

    const [videos,setVideos] = useState<HTMLVideoElement[]>([])

    const players: FlvJs.Player[] = []

    const currentPlayer = useRef<FlvJs.Player>();

    const [currentVideo,setCurrentVideo] = useState<HTMLVideoElement>()

    const load = (ref:HTMLVideoElement,url:string) : FlvJs.Player =>{
        const player = FlvJs.createPlayer({
            type: 'flv',
            isLive: true,
            cors: true,
            hasVideo: true,
            hasAudio:false,
            url,
        },{
            stashInitialSize: 128,
            enableStashBuffer: false,
            autoCleanupSourceBuffer:true,
            fixAudioTimestampGap:false
        })

        player.attachMediaElement(ref)
        player.load()
        player.play()

        return player
    }

    const loadPlayerTimer = () =>{

        for (let i = 0; i < players.length; i++) {
            if (players[i].buffered && players[i].buffered.length) {
                const end = players[i].buffered.end(0); // 获取当前buffered值
                const diff = end - players[i].currentTime; // 获取buffered与currentTime的差值
                // console.log(i)
                // console.log(diff)
                if (diff >= 3) {
                    players[i].currentTime = end;
                }
            }
        }

    }




    const handleVideoClick = (val) => {
        if (val.type == 0 ){
            setOpen2(true)
        }else {
            setActiveVideo(val)
            setOpen(true)
        }
    }

    const handleRef = (ref) =>{
        if (ref != null){
            setVideos((prevState)=>{
                if (prevState.length == 0){
                    prevState.push(ref)
                }else if (prevState.filter(it=>it.id == ref.id).length === 0){
                    prevState.push(ref)
                }
                return prevState
            })
        }
    }



    useEffect(()=>{
        if (videos.length === 3){
            videos.forEach((it,index)=>{
                players.push(load(it,values[index].value))
            })
        }
        const timer = interval(loadPlayerTimer, 2000)
        return () => {
            intervalClear(timer)
        }
    },[videos])

    useEffect(()=>{
        if (currentVideo != null && open == true){
            currentPlayer.current = load(currentVideo,activeVideo.value)
        }
    },[currentVideo,open])

    useEffect(()=>{
        if (open == false){
            if (currentPlayer.current != null){
                currentPlayer.current.unload()
                currentPlayer.current.detachMediaElement()
                currentPlayer.current.destroy()
                currentPlayer.current = null
            }
        }
    },[open])

    return (
        <div className="video-area">
            <img alt="" src={videoArea} className="video-area-background"/>
            <div className="video-select-grid">
                {values.map((item,index) => (
                    <div
                        key={index}
                        className={cls({
                            'grid-item': true,
                            'item-active': activeVideo.label === item.label,
                        })}
                        onClick={() => handleVideoClick(item)}
                    >
                        {item.label}
                        {
                            item.type == 1 ? <div
                                    style={{pointerEvents: 'none'}}
                                >
                                    <video
                                        id={`${index}video`}
                                        ref={handleRef}
                                        className="video"
                                        height={125}
                                        width="100%"
                                    >
                                    </video>
                                </div> :
                                <img alt="视频回放" src={videoBack} height={125}/>
                        }
                    </div>
                ))}
            </div>
            <Modal
                width="80%"
                open={open}
                onOk={() => {
                    setOpen(false)
                }}
                onCancel={() => {
                    setOpen(false)
                }}
                closeIcon={<CloseCircleTwoTone style={{fontSize: '35px'}}/>}
            >
                <video controls ref={setCurrentVideo} width="100%">
                    <track kind="captions"/>
                </video>
            </Modal>
            <Modal
                width="80%"
                open={open2}
                onOk={() => {
                    setOpen2(false)
                }}
                onCancel={() => {
                    setOpen2(false)
                }}
                closeIcon={<CloseCircleTwoTone style={{fontSize: '35px'}}/>}
            >
                <VideoBack/>
            </Modal>
        </div>
    );
}
