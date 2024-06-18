import React from 'react';
import './index.less'

export default function Progress(props) {
  const {
    title,
    themeColor,
    // 主题色渐变
    themeColorTransition,
    progress,
    className,
    style,
  } = props;


  return (
    <div className={`progress-chart ${className}`} style={style}>
      <div className='top-info'>
        <span className='chart-title'>{title || ''}</span>
        <span className='progress' style={{ color: themeColor }}>{progress}%</span>
      </div>
      <div
        className='progress-length'
        style={{
          width: `${progress}%`,
          backgroundImage: `linear-gradient(to right, ${themeColorTransition}, ${themeColor})`,
        }}
      >
      </div>
    </div>
  );
}
