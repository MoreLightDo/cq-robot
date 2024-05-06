import React, { useEffect, useRef } from 'react';
import DataSet from '@antv/data-set';
import { Chart } from '@antv/g2';

export default function ColumnChartFill(props: { className: string }) {
  const canvasRef = useRef(null);
  useEffect(() => {
    const data = [
      { country: '设备访问占比', year: '1750', value: 502 },
      { country: '设备访问占比', year: '1800', value: 635 },
      { country: '设备访问占比', year: '1850', value: 809 },
      { country: '设备访问占比', year: '1900', value: 947 },
      { country: '设备访问占比', year: '1950', value: 1402 },
      { country: '设备访问占比', year: '1999', value: 3634 },
      { country: '设备访问占比', year: '2050', value: 5268 },
      { country: '成功占比', year: '1750', value: 106 },
      { country: '成功占比', year: '1800', value: 107 },
      { country: '成功占比', year: '1850', value: 111 },
      { country: '成功占比', year: '1900', value: 133 },
      { country: '成功占比', year: '1950', value: 221 },
      { country: '成功占比', year: '1999', value: 767 },
      { country: '成功占比', year: '2050', value: 1766 },
      { country: '失败占比', year: '1750', value: 163 },
      { country: '失败占比', year: '1800', value: 203 },
      { country: '失败占比', year: '1850', value: 276 },
      { country: '失败占比', year: '1900', value: 408 },
      { country: '失败占比', year: '1950', value: 547 },
      { country: '失败占比', year: '1999', value: 729 },
      { country: '失败占比', year: '2050', value: 628 },
    ];

    const dv = new DataSet.DataView().source(data);
    dv.transform({
      type: 'percent',
      field: 'value',
      dimension: 'country',
      groupBy: ['year'],
      as: 'percent',
    });

    const chart = new Chart({
      container: canvasRef.current,
      autoFit: true,
      height: 500,
    });
    chart.data(dv.rows);
    chart.scale({
      year: {
        type: 'linear',
        tickInterval: 50,
      },
      percent: {
        formatter: (value) => {
          let v = +value || 0;
          v = +value * 100;
          return v;
        },
        alias: 'percent(%)',
      },
    });
    chart.tooltip({
      showCrosshairs: true,
      shared: true,
    });
    chart.area().adjust('stack').position('year*percent').color('country');
    chart.line().adjust('stack').position('year*percent').color('country');
    chart.render();
  }, []);

  return <div ref={canvasRef} className={props.className} />;
}
