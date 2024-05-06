import React from 'react';
import { message as AntdMessage, MessageArgsProps } from 'antd';
import { MessageType } from 'antd/lib/message';

import errorSvg from '../../assets/message/error.svg';
import infoSvg from '../../assets/message/info.svg';
import successSvg from '../../assets/message/success.svg';
import warningSvg from '../../assets/message/warning.svg';
import loadingCircle from '../../assets/message/loading.svg';
import './index.less';

const prefixCls = `message`;
AntdMessage.config({
  duration: 2,
  maxCount: 1,
  top: 60,
});

const success = (content: Pick<MessageArgsProps, 'content'> | string, duration = 2): MessageType =>
  AntdMessage.success({
    content,
    duration,
    icon: <img src={successSvg} className={`${prefixCls}-init-icon`} alt="" />,
    className: `${prefixCls}-success`,
  });

const info = (content: Pick<MessageArgsProps, 'content'> | string, duration = 2): MessageType =>
  AntdMessage.info({
    content,
    duration,
    icon: <img src={infoSvg} className={`${prefixCls}-init-icon`} alt="" />,
    className: `${prefixCls}-info`,
  });

const warning = (content: Pick<MessageArgsProps, 'content'> | string, duration = 2): MessageType =>
  AntdMessage.warning({
    content,
    duration,
    icon: <img src={warningSvg} className={`${prefixCls}-init-icon`} alt="" />,
    className: `${prefixCls}-warning`,
  });

const error = (content: Pick<MessageArgsProps, 'content'> | string, duration = 2): MessageType =>
  AntdMessage.error({
    content,
    duration,
    icon: <img src={errorSvg} className={`${prefixCls}-init-icon`} alt="" />,
    className: `${prefixCls}-error`,
  });

const loading = (content: Pick<MessageArgsProps, 'content'> | string, duration = 2): MessageType =>
  AntdMessage.loading({
    content,
    duration,
    icon: <img src={loadingCircle} className={`${prefixCls}-init-icon`} alt="" />,
    className: `${prefixCls}-loading`,
  });

const Message = { success, info, warning, error, loading, destroy: AntdMessage.destroy };
export default Message;
