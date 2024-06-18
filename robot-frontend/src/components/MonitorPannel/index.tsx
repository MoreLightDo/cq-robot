import React from 'react';
import bottomLine from '@/assets/monitorPage/bottom-line.png';
import rightArrow from '@/assets/monitorPage/right-arrow.png';
import './index.less'

export default function MonitorPannel(props) {
  const {
    children,
    className,
    style,
    title,
    clickViewMore,
  } = props;

  return (
    <div className={`monitor-pannel ${className}`} style={style}>
      <div className='monitor-panner-header'>
        <div className='mointor-panner-title-area'>
          <span>{title}</span>
          {clickViewMore && <a onClick={() => clickViewMore()}>更多记录</a>}
        </div>
        <img src={bottomLine} className='header-bottom-line' />
      </div>
      {children}
    </div>
  );
}
