import React from 'react';
import {
  FieldNumberOutlined,
  FontSizeOutlined,
  DotChartOutlined,
  BoxPlotOutlined,
  ApiOutlined,
  BranchesOutlined,
} from '@ant-design/icons';

import './index.less';

const d = [
  {
    title: '编号',
    data: '39943',
    icon: <FieldNumberOutlined className="icon" />,
  },
  {
    title: '名称',
    data: '工作机器人1号',
    icon: <FontSizeOutlined className="icon" />,
  },
  {
    title: '工作状态',
    data: '正常',
    icon: <DotChartOutlined className="icon" />,
  },
  {
    title: '运行速度',
    data: '1000转/秒',
    icon: <BoxPlotOutlined className="icon" />,
  },
  {
    title: '位置',
    data: '控制中心机位',
    icon: <ApiOutlined className="icon" />,
  },
  {
    title: '电量',
    data: '40%',
    icon: <BranchesOutlined className="icon" />,
  },
];

export default function RobotInfo() {
  return (
    <div className="robot-infomation">
      {d.map(({ title, data, icon }) => (
        <div className="item" key={title}>
          <div className="action">
            {icon}
            {title}
          </div>
          <div className="data">{data}</div>
        </div>
      ))}
    </div>
  );
}
