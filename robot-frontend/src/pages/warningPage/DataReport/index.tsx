import React from 'react';

import './index.less';

const data = [
  { title: '系统启动', time: '2022-10-16 11:11:11' },
  { title: '温度报警，位置222.131.211.666', time: '2022-10-16 02:02:22' },
  { title: '日志报告', time: '2022-10-17 13:06:06' },
  { title: '系统启动 1', time: '2022-10-16 11:11:11' },
  { title: '温度报警，位置222.131.211.666 1', time: '2022-10-16 02:02:22' },
  { title: '日志报告 1', time: '2022-10-17 13:06:06' },
  { title: '系统启动 2', time: '2022-10-16 11:11:11' },
  { title: '温度报警，位置222.131.211.666 2', time: '2022-10-16 02:02:22' },
  { title: '日志报告 2', time: '2022-10-17 13:06:06' },
];
export default function DataReport() {
  return (
    <div className="data-report">
      {data.map(({ title, time }) => (
        <div className="item" key={title}>
          <div className="title">{title}</div>
          <div className="time">{time}</div>
        </div>
      ))}
    </div>
  );
}
