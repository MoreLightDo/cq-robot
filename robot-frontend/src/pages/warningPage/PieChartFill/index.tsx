import React, { useEffect, useRef } from 'react';
import { Chart, Util } from '@antv/g2';

export default function PieChartFill(props: { className: string }) {
  const canvasRef = useRef(null);
  useEffect(() => {
    const data = [
      { type: '任务1', value: 0.19 },
      { type: '任务2', value: 0.21 },
      { type: '任务3', value: 0.27 },
      { type: '任务4', value: 0.33 },
    ];
    const chart = new Chart({
      container: canvasRef.current,
      autoFit: true,
      height: 500,
    });
    chart.data(data);

    chart.coordinate('theta', {
      radius: 0.75,
    });
    chart.tooltip({
      showMarkers: false,
    });

    chart
      .interval()
      .adjust('stack')
      .position('value')
      .color('type', ['#063d8a', '#1770d6', '#47abfc', '#38c060'])
      .style({ opacity: 0.4 })
      .state({
        active: {
          style: (element) => {
            const { shape } = element;
            return {
              matrix: Util.zoom(shape, 1.1),
            };
          },
        },
      })
      .label('type', (val) => {
        const opacity = val === '四线及以下' ? 1 : 0.5;
        return {
          offset: -30,
          style: {
            opacity,
            fill: 'white',
            fontSize: 12,
            shadowBlur: 2,
            shadowColor: 'rgba(0, 0, 0, .45)',
          },
          content(obj) {
            return `${obj.type}\n${obj.value}%`;
          },
        };
      });

    chart.interaction('element-single-selected');

    chart.render();
  }, []);

  return <div ref={canvasRef} className={props.className} />;
}
