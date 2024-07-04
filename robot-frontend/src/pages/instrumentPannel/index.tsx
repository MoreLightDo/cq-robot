import React, { useEffect, useState } from 'react';
import { Table } from 'antd';
import { getInstrumentState, getRealTimeInfo } from '@/api/panel';
import history from '@/utils/history';
import settingIcon from '@/assets/center/setting.png';
import stateIcon from '@/assets/instrumentPage/taskState.png';
import locationIcon from '@/assets/instrumentPage/location.png';
import pannelNoIcon from '@/assets/instrumentPage/pannelNo.png';
import readingIcon from '@/assets/instrumentPage/reading.png';
import timeIcon from '@/assets/instrumentPage/time.png';
import './index.less';

 // 页面切换
 const pageChange = (path) => {
  // history.push(path);
};

export default function InstrumentPannel(props) {
  const [pannelState, setPannelState] = useState<any>({});
  const [realTimeInfo, setRealTimeInfo] = useState<any[]>([]);

  useEffect(() => {
    getInstrumentState().then((res) => {
      setPannelState(res);
    });
    getRealTimeInfo().then((res) => {
      setRealTimeInfo(res);
    });
  }, []);

  return (
    <div className='instrument-page'>
      <div className='instrument-page-header'>
        <a className='page-button' onClick={() => pageChange('xxx')}>首页</a>
        <span className='header-left-elements'>
          <span className='data-and-time-item'>2024-01-25</span>
          <span className='data-and-time-item'>17:01:05</span>
          <span className='data-and-time-item'>星期一</span>
        </span>
        <span className='header-right-elements'>
          {/* 下列跳转可能本期还没有 */}
          <a className='page-button' onClick={() => pageChange('xxx')}>智能监控</a>
          <a className='page-button' onClick={() => pageChange('xxx')}>智能运维</a>
          <a className='page-button' onClick={() => pageChange('xxx')}>智能群控系统</a>
          <a className='page-button' onClick={() => pageChange('xxx')}>数据记录</a>
          <img className='setting-icon' alt='settingIcon' src={settingIcon} />
        </span>
      </div>
      <div className='instrument-page-body'>
        <div className='instrument-page-body-top'>
          <div className='left-area'>
            <div className='left-area-pannel' style={{ height: '142px' }}>
              <p className='title'>仪表状态</p>
              {/* 仪表状态内容 */}
              <div className='pannel-state'>
                <div className='item'>
                  <img src={stateIcon} />
                  <span className='text'>当前任务状态</span>
                  <span className='value'>{pannelState.currentState}</span>
                </div>
                <div className='item'>
                  <img src={locationIcon} />
                  <span className='text'>当前位置</span>
                  <span className='value'>{pannelState.location}</span>
                </div>
                <div className='item'>
                  <img src={pannelNoIcon} />
                  <span className='text'>仪表编号</span>
                  <span className='value'>{pannelState.instrumentNo}</span>
                </div>
                <div className='item'>
                  <img src={readingIcon} />
                  <span className='text'>识别读数</span>
                  <span className='value'>{pannelState.reading}</span>
                </div>
                <div className='item'>
                  <img src={timeIcon} />
                  <span className='text'>时间</span>
                  <span className='value'>{pannelState.time}</span>
                </div>
              </div>
            </div>
            <div className='left-area-pannel' style={{ height: '260px', overflow: 'auto' }}>
              <p className='title'>实时信息</p>
              {/* 实时信息内容 */}
              <Table
                className='realtime-info-date-table'
                bordered={false}
                columns={[
                  {
                    title: '序号',
                    dataIndex: 'indexNo',
                  },
                  {
                    title: '运营状态',
                    dataIndex: 'operationalStatus',
                  },
                  {
                    title: '异常说明',
                    dataIndex: 'abnormal',
                  },
                  {
                    title: '参考值范围',
                    dataIndex: 'refRange',
                  },
                ]}
                pagination={false}
                dataSource={realTimeInfo}
              />
            </div>
          </div>
          <div className='right-area'></div>
        </div>
        <div className='bottom-area'>
          <p className='title'>仪表分析</p>
          <div className='bottom-area-content'>
          <Table
            className='analyze-date-table'
            bordered={false}
            rowKey='indexNo'
            scroll={{ y: 210 }}
            columns={[
              {
                title: '序号',
                dataIndex: 'indexNo',
              },
              {
                title: '分析仪表',
                dataIndex: 'yibiao',
              },
              {
                title: '日期',
                dataIndex: 'date',
              },
              {
                title: '开始',
                dataIndex: 'kaishi',
              },
              {
                title: '结束',
                dataIndex: 'jieshu',
              },
              {
                title: '分析数',
                dataIndex: 'num',
              },
              {
                title: 'CaO',
                dataIndex: 'CaO',
              },
              {
                title: 'MgO',
                dataIndex: 'MgO',
              },
              {
                title: 'SkOz',
                dataIndex: 'SkOz',
              },
              {
                title: 'KzO',
                dataIndex: 'KzO',
              },
              {
                title: 'NazO',
                dataIndex: 'NazO',
              },
            ]}
            pagination={false}
            dataSource={[
              {
                indexNo: 1,
                yibiao: '5487654',
                date: '2024-07-01',
                kaishi: '2024-07-01 15:00',
                jieshu: '2024-07-01 15:00',
                num: 23,
                CaO: 44,
                MgO: 23,
                SkOz: 23,
                KzO: 23,
                NazO: 12,
              },
              {
                indexNo: 2,
                yibiao: '5487654',
                date: '2024-07-01',
                kaishi: '2024-07-01 15:00',
                jieshu: '2024-07-01 15:00',
                num: 23,
                CaO: 44,
                MgO: 23,
                SkOz: 23,
                KzO: 23,
                NazO: 12,
              },
              {
                indexNo: 3,
                yibiao: '5487654',
                date: '2024-07-01',
                kaishi: '2024-07-01 15:00',
                jieshu: '2024-07-01 15:00',
                num: 23,
                CaO: 44,
                MgO: 23,
                SkOz: 23,
                KzO: 23,
                NazO: 12,
              },
              {
                indexNo: 4,
                yibiao: '5487654',
                date: '2024-07-01',
                kaishi: '2024-07-01 15:00',
                jieshu: '2024-07-01 15:00',
                num: 23,
                CaO: 44,
                MgO: 23,
                SkOz: 23,
                KzO: 23,
                NazO: 12,
              },
              {
                indexNo: 5,
                yibiao: '5487654',
                date: '2024-07-01',
                kaishi: '2024-07-01 15:00',
                jieshu: '2024-07-01 15:00',
                num: 23,
                CaO: 44,
                MgO: 23,
                SkOz: 23,
                KzO: 23,
                NazO: 12,
              },
              {
                indexNo: 6,
                yibiao: '5487654',
                date: '2024-07-01',
                kaishi: '2024-07-01 15:00',
                jieshu: '2024-07-01 15:00',
                num: 23,
                CaO: 44,
                MgO: 23,
                SkOz: 23,
                KzO: 23,
                NazO: 12,
              },
            ]}
          />
          </div>
        </div>
      </div>
    </div>
  );
}
