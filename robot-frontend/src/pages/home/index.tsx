import React, {useContext, useEffect} from 'react';
import { Tooltip } from 'antd';
import { Navigate } from 'react-router-dom';

import appBackground from '../../assets/common/app-background.png';
import Header from '../../components/Header';
import HomePageStatus from '../../components/HomePageStatus';
import TaskMenu from '../../components/TaskMenu';
import ControlArea from '../../components/ControlArea';
import VideoSelect from '../../components/VideoSelect';
import location from '../../assets/icons/location.png';
import { getToken } from '../../utils/auth';
import WarningInfoList from '../../components/WarningInfoList';
import './index.less';
import CenterMap from "../../components/centerMap";
import {getInfo} from "../../api/login";
import {useAppDispatch, useAppSelector} from "../../redux/store";
import {updateUser} from "../../redux/reducers/UserReducer";
import {interval, intervalClear} from "../../utils/interval";
import {getAgvInfo, getSensors} from "../../api/robot";
import {updateRobotInfo, updateSensors} from "../../redux/reducers/RobotReducer";


function CenterPage(){
  console.log(getToken(), 'CenterPage');

  const dispatch = useAppDispatch()

  const userInfo = useAppSelector(state => state.user.userInfo)

  useEffect(() => {
    getInfo().then((res) => {
      dispatch(updateUser(res.user))
    })
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [])

  const refrashInfo = ()=>{
    getAgvInfo().then(res => {
      dispatch(updateRobotInfo(res.data))
    })
    getSensors().then(res => {
      dispatch(updateSensors(res.data))
    })
  }

  useEffect(() => {
      refrashInfo()
      const timer = interval(refrashInfo, 2000)
      return () => {
          intervalClear(timer)
      }
  }, [])

  if (!getToken()) {
    return <Navigate to="/login" replace/>
  }

  const localText = '全国>重庆市>招商局检测车辆技术研究院有限公司>2021123104';


  return (
    <div className="home-page">
      <img src={appBackground} alt="appBackground" className="home-page-background" />
      <Header />
      <div className="home-page-content">
        <HomePageStatus />
        <div className="home-page-center-content">
          <div className="content-left">
            <div className="location">
              <img alt="" src={location} />
              <Tooltip title={localText}>
                <span>{localText}</span>
              </Tooltip>
            </div>
            <TaskMenu />
          </div>
          {/* 视频区 */}
          <div className="content-center">
            <CenterMap/>
          </div>
          <div className="content-right">
            <ControlArea />
            <VideoSelect />
          </div>
        </div>
        <WarningInfoList />
      </div>
    </div>
  );
}

export default CenterPage;
