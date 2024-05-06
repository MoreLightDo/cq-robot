import React from 'react';

import './index.less';

interface IContainerType {
  wrapClass?: string;
  titleClass?: string;
  title: string;
  children: any;
}
function Container(props: IContainerType) {
  return (
    <div className={`${props.wrapClass ? props.wrapClass : ''} container`}>
      <div className={`${props.titleClass ? props.titleClass : ''} base-title`}>{props.title}</div>
      {props.children}
    </div>
  );
}

export default Container;
