import React, { useEffect, useState } from 'react';
import { Table } from 'antd';
import { ArrowUpOutlined, ArrowDownOutlined } from '@ant-design/icons';
import MonitorPannel from '@/components/MonitorPannel';
import Progress from '@/components/Progress';
import SafeDataChart from '@/components/SafeDataChart';
import { getVideoList, getSnapshotList, getSafeData, getWarningEventData } from '@/api/monitor';
import settingIcon from '@/assets/center/setting.png';
import safeIcon from '@/assets/monitorPage/safe-icon.png';
import history from '@/utils/history';
import './index.less';

// mock
import src1 from '@/assets/videoMock/WX20240730-185629-1.png';
import src2 from '@/assets/videoMock/WX20240730-185720-2.png';
import src3 from '@/assets/videoMock/WX20240730-185749-3.png';

const src = [src1, src2];

export default function Instrument(props) {
  // 视频监控列表
  const [videoMonitorList, setVideoMonitorList] = useState([]);

  // 实时抓拍列表
  const [snapshotList, setSnapshotList] = useState([]);

  // 中间视频的显示
  const [centerVideo, setCenterVideo] = useState(null);

  // 安全趋势数据
  const [safeLogData, setSafeLogData] = useState(null);

  // 告警事故统计数据
  const [warningDataSource, setWarningDataSource] = useState([]);

  // 页面切换
  const pageChange = (path) => {
    // history.push(path);
  };

  // 查看更多
  const viewMore = (item) => {
    console.log(item);
  };

  useEffect(() => {
    // 获取视频监控列表
    getVideoList('xx').then((res) => {
      console.log(res.monitorList);
      setVideoMonitorList(res.monitorList);
      if (res.monitorList.length > 0) {
        // 中间默认显示第0个
        setCenterVideo(res.monitorList[0].videoUrl);
      }
    });

    // 获取实时抓拍列表
    getSnapshotList('xxx').then((res) => {
      console.log(res.monitorList);
      setSnapshotList(res.monitorList);
    });

    // 获取安全趋势数据
    getSafeData('xxxx').then((res) => {
      console.log(res);
      setSafeLogData(res);
    });

    // 获取告警事故统计数据
    getWarningEventData().then((res) => {
      console.log(res);
      setWarningDataSource(res);
    });
  }, []);

  return (
    <div className='monitor-page'>
      <div className='monitor-page-header'>
        <a className='page-button' onClick={() => pageChange('xxx')}>首页</a>
        <span className='header-left-elements'>
          <span className='data-and-time-item'>2024-01-25</span>
          <span className='data-and-time-item'>17:01:05</span>
          <span className='data-and-time-item'>星期一</span>
        </span>
        <span className='header-right-elements'>
          {/* 下列跳转可能本期还没有 */}
          <a className='page-button' onClick={() => pageChange('xxx')}>仪表识别</a>
          <a className='page-button' onClick={() => pageChange('xxx')}>智能运维</a>
          <a className='page-button' onClick={() => pageChange('xxx')}>智能群控系统</a>
          <a className='page-button' onClick={() => pageChange('xxx')}>数据记录</a>
          <img className='setting-icon' alt='settingIcon' src={settingIcon} />
        </span>
      </div>
      <div className='monitor-page-body'>
        <div className='monitor-page-body-left'>
          <MonitorPannel
            className='top-area'
            title='视频监控'
            clickViewMore={viewMore.bind(null, '视频监控参数')}
          >
            <div className='video-list'>
              {videoMonitorList.slice(0, 2).map((item, i) => (
                <div className='video-item' key={item.videoUrl}>
                  <p>{item.name}</p>
                  <div
                    className='video-area'
                    // 点击切换中间视频流
                    onClick={() => setCenterVideo(item.videoUrl)}
                  >
                    <img style={{ display: 'block', width: '100%', height: '100%' }} src={src[i]} />
                    {/* 待完善视频流 */}
                  </div>
                </div>
              ))}
            </div>
          </MonitorPannel>
          <MonitorPannel
            className='bottom-area'
            title='实时抓拍'
            clickViewMore={viewMore.bind(null, '实时抓拍参数')}
          >
            <div className='video-list'>
              {snapshotList[0] && (
                <div className='video-item'>
                  <p>{snapshotList[0].name}</p>
                  <div className='video-area' style={{
                    backgroundImage: `url(${src3})`,
                    backgroundRepeat: 'no-repeat',
                    backgroundSize: '100% 100%',
                  }}>
                    <div className='video-info'>
                      <span>{snapshotList[0].tip}</span>
                      <span>{snapshotList[0].time}</span>
                    </div>
                  </div>
                </div>
              )}
            </div>
          </MonitorPannel>
        </div>
        <div className='monitor-page-body-center'>
          {/* 待完善视频流 */}
          {centerVideo}
        </div>
        <div className='monitor-page-body-right'>
          <MonitorPannel
            title='安全着装概况'
          >
            <p className='safe-equipped-title'>今日安全着装指数</p>
            {safeLogData && (
              <>
                <div className='safe-equipped-score'>
                  <img src={safeIcon} />
                  <span className='score'>{safeLogData.todayScore}<span>分</span></span>
                </div>
                <p className='safe-equipped-title'>今日安全着装率</p>
                <Progress
                  title='安全帽穿戴率'
                  progress={safeLogData.todayEquipped}
                  themeColor='#FFF476'
                  themeColorTransition='#FCCB34'
                  className='safe-equipped-progess-chart'
                />
                <Progress
                  title='反光衣穿戴率'
                  progress={safeLogData.todayFanguang}
                  themeColor='#83FFA0'
                  themeColorTransition='#34FC7F'
                  className='safe-equipped-progess-chart'
                />
                <p className='safe-chart-title'>近30天安全趋势</p>
                <SafeDataChart />
              </>
            )}
          </MonitorPannel>
          <MonitorPannel
            className='bottom-area'
            title='告警事故统计'
            clickViewMore={viewMore.bind(null, '告警事故参数')}
          >
            <Table
              className='warning-date-table'
              columns={[
                {
                  title: '事件名称',
                  dataIndex: 'eventName',
                },
                {
                  title: '今日次数',
                  dataIndex: 'todayTimes',
                  render: (value, record) => {
                    const Icon = record.trend === 'up'
                      ? () => <ArrowUpOutlined style={{ color: '#FF6683', marginLeft: '10px' }} />
                      : () => <ArrowDownOutlined style={{ color: '#66FFD6', marginLeft: '10px' }}/>;
                    return (
                      <span>
                        <span>{value}</span>
                        <Icon />
                      </span>
                    );
                  },
                },
                {
                  title: '近30日均值',
                  dataIndex: 'average',
                },
              ]}
              pagination={false}
              dataSource={warningDataSource}
            />
          </MonitorPannel>
        </div>
      </div>
    </div>
  );
}
