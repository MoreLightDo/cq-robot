import React, { useEffect, useRef } from 'react';
import { Chart, registerShape } from '@antv/g2';

export default function WarningPage(props: { className: string }) {
  const canvasRef = useRef(null);
  useEffect(() => {
    // 自定义Shape 部分
    registerShape('point', 'pointer', {
      draw(cfg, container) {
        const group = container.addGroup();
        // eslint-disable-next-line react/no-this-in-sfc
        const center = this.parsePoint({ x: 0, y: 0 }); // 获取极坐标系下画布中心点
        // 绘制指针
        group.addShape('line', {
          attrs: {
            x1: center.x,
            y1: center.y,
            x2: cfg.x,
            y2: cfg.y,
            stroke: cfg.color,
            lineWidth: 5,
            lineCap: 'round',
          },
        });
        group.addShape('circle', {
          attrs: {
            x: center.x,
            y: center.y,
            r: 9.75,
            stroke: cfg.color,
            lineWidth: 4.5,
            fill: '#fff',
          },
        });

        return group;
      },
    });

    const data = [{ value: 5.6 }];
    const chart = new Chart({
      container: canvasRef.current,
      autoFit: true,
      height: 500,
      padding: [0, 0, 30, 0],
    });
    chart.data(data);
    chart.scale('value', {
      min: 0,
      max: 9,
      tickInterval: 1,
    });
    chart.coordinate('polar', {
      startAngle: (-9 / 8) * Math.PI,
      endAngle: (1 / 8) * Math.PI,
      radius: 0.75,
    });

    chart.axis('1', false);
    chart.axis('value', {
      line: null,
      label: {
        offset: -36,
        style: {
          fontSize: 18,
          textAlign: 'center',
          textBaseline: 'middle',
        },
      },
      subTickLine: {
        count: 4,
        length: -15,
      },
      tickLine: {
        length: -24,
      },
      grid: null,
    });
    chart.legend(false);
    chart
      .point()
      .position('value*1')
      .shape('pointer')
      .color('#1890FF')
      .animate({
        appear: {
          animation: 'fade-in',
        },
      });

    // 绘制仪表盘背景
    chart.annotation().arc({
      top: false,
      start: [0, 1],
      end: [9, 1],
      style: {
        // 底灰色
        stroke: '#CBCBCB',
        lineWidth: 18,
        lineDash: null,
      },
    });

    // 绘制指标
    chart.annotation().arc({
      start: [0, 1],
      end: [data[0].value, 1],
      style: {
        stroke: '#1890FF',
        lineWidth: 18,
        lineDash: null,
      },
    });
    // 绘制指标数字
    chart.annotation().text({
      position: ['50%', '85%'],
      content: '剩余电量',
      style: {
        fontSize: 18,
        fill: '#545454',
        textAlign: 'center',
      },
    });
    chart.annotation().text({
      position: ['50%', '90%'],
      content: `${data[0].value * 10} %`,
      style: {
        fontSize: 30,
        fill: '#545454',
        textAlign: 'center',
      },
      offsetY: 15,
    });

    chart.render();
  }, []);

  return <div ref={canvasRef} className={props.className} />;
}
