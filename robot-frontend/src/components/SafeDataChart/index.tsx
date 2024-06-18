import React, { useEffect, useRef } from 'react';
import { Chart } from '@antv/g2';
import { getRecentData } from '@/api/monitor';
import './index.less';

export default function SafeDataChart(props) {
  const { className, style } = props;
  const containerRef = useRef(null);

  useEffect(() => {
    getRecentData(30).then((data) => {
      const chart = new Chart({
        container: containerRef.current,
        autoFit: true,
      });
      
      chart
        .data(data)
        .encode('x', 'date')
        .encode('y', 'score')
        .encode('color', 'safeItem')
        .scale('color', { range: ['#FFF171', '#66FD94'] })
        .scale('x', {
          range: [0, 1],
        })
        .scale('y', {
          nice: true,
        })
        .axis('x', false)
        .axis('y', false);

      chart.line().encode('shape', 'smooth');
      chart.point().encode('shape', 'point').tooltip(false);
      chart.options({
        legend: false,
      });
      chart.render();
    });
  }, []);

  return (
    <div
      className={`chart-container ${className}`}
      ref={containerRef}
      style={{
        height: '100px',
        ...style,
      }}
    ></div>
  );
}
