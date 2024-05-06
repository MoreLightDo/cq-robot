import React, { useEffect, useRef } from 'react';
import { Chart } from '@antv/g2';

export default function Column(props: { className: string }) {
  const canvasRef = useRef(null);
  useEffect(() => {
    const data = [
      { year: '10.09', 数量: 38 },
      { year: '10.10', 数量: 52 },
      { year: '10.11', 数量: 61 },
      { year: '10.12', 数量: 145 },
      { year: '10.13', 数量: 48 },
      { year: '10.14', 数量: 38 },
      { year: '10.15', 数量: 38 },
      { year: '10.16', 数量: 38 },
    ];
    const chart = new Chart({
      container: canvasRef.current,
      autoFit: true,
      height: 500,
    });

    chart.data(data);
    chart.scale('数量', {
      nice: true,
    });

    chart.tooltip({
      showMarkers: false,
    });
    chart.interaction('active-region');

    chart.interval().position('year*数量');

    chart.render();
  }, []);

  return <div className={props.className} ref={canvasRef} />;
}
