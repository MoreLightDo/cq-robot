import React, { useEffect, useRef } from 'react';
import { Chart } from '@antv/g2';
import './index.less';

export default function RuntimeTrendChart(props) {
  const { className, style } = props;
  const containerRef = useRef(null);

  useEffect(() => {
    // mock新增事件数据
  const data1 = [
    { date: '1', labelText: '新增事件', score: 4.3 },
    { date: '2', labelText: '新增事件', score: 4.9 },
    { date: '3', labelText: '新增事件', score: 7.9 },
    { date: '4', labelText: '新增事件', score: 5.2 },
    { date: '5', labelText: '新增事件', score: 6.5 },
    { date: '6', labelText: '新增事件', score: 7.7 },
    { date: '7', labelText: '新增事件', score: 15.5 },
  ];
  // mock预警事件数据
  const data2 = [
    { date: '1', labelText: '预警事件', score: 3.3 },
    { date: '2', labelText: '预警事件', score: 3.9 },
    { date: '3', labelText: '预警事件', score: 6.9 },
    { date: '4', labelText: '预警事件', score: 4.2 },
    { date: '5', labelText: '预警事件', score: 9.5 },
    { date: '6', labelText: '预警事件', score: 5.7 },
    { date: '7', labelText: '预警事件', score: 14.5 },
  ];
    const chart = new Chart({
      container: containerRef.current,
      autoFit: true,
    });
    
    chart
      .data([...data1, ...data2])
      .encode('x', 'date')
      .encode('y', 'score')
      .encode('color', 'labelText')
      .scale('color', { range: ['#FFF171', '#66FD94'] })
      .scale('x', {
        range: [0, 1],
      })
      .scale('y', {
        nice: true,
      })

    chart.axis('x', {
      lineStroke: '#fff',
      title: '',
      lineLineWidth: 2,
      line: true,
      arrow: false,
      labelFill: '#fff',
      labelFontSize: 12,
    }).axis('y', {
      lineStroke: '#fff',
      title: '',
      lineLineWidth: 2,
      line: true,
      arrow: false,
      labelFill: '#fff',
      labelFontSize: 12,
    });
    chart.line().encode('shape', 'smooth');
    chart.point().encode('shape', 'point').tooltip(false);
    // chart.options({
    //   legend: false,
    // });
    chart.render();
  }, []);

  return (
    <div
      className={`his-chart-container ${className}`}
      ref={containerRef}
      style={{
        height: '276px',
        ...style,
      }}
    ></div>
  );
}
