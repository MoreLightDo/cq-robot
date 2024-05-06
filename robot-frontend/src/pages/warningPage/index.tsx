import React, { useEffect } from 'react';

import RobotInformation from './RobotInfomation';
import PieChart from './PieChart';
import PieChartFill from './PieChartFill';
import ColumnChart from './ColumnChart';
import ColumnChartFill from './ColumnChartFill';
import DataReport from './DataReport';
import Container from './Container';
import './index.less';

export default function WarningPage() {
  // wds代理测试
  useEffect(() => {
    fetch('/dutang/api.php')
      .then((res) => {
        const r = res.json();
        return r;
      })
      .then((data) => {
        console.log(data);
      });
  }, []);
  return (
    <div className="waring-page">
      <div className="left">
        <Container title="机器人信息">
          <RobotInformation />
        </Container>
        <Container title="剩余电量" titleClass="t" wrapClass="w">
          <PieChart className="chart" />
        </Container>
        <Container title="任务处理" titleClass="t" wrapClass="w">
          <PieChartFill className="chart" />
        </Container>
      </div>
      <div className="content">
        <div className="video">预留的视频区域</div>
        <div className="column">
          <Container title="记录" wrapClass="column-wrap">
            <ColumnChart className="chart" />
          </Container>
          <Container title="访问详情" wrapClass="column-wrap">
            <ColumnChartFill className="chart" />
          </Container>
        </div>
      </div>
      <div className="right">
        <Container title="日志记录">
          <DataReport />
        </Container>
      </div>
    </div>
  );
}
