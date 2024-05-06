import React from 'react';
import { message } from 'antd';

import LoginCommonHooks from '../../hooks/login-common';
import LoginCommonMask from '../../components/login-common/mask';
import LoginCommonInputItem from '../../components/login-common/input-item';
import LoginCommonAction from '../../components/login-common/action';
import './index.less';

function EditPasswordPage() {
  const { user, password, isRemberPassword, setUser, setPassword, setRemberPassword } = LoginCommonHooks();
  const onSendCode = () => {
    if (!user.trim()) {
      message.warning('请先输入手机号');
      return;
    }

    // 执行后续逻辑
    message.success('后续逻辑');
  };

  return (
    <LoginCommonMask title="修 改 密 码" subtitle="CHANGE PASSWORD">
      <LoginCommonInputItem
        type="text"
        iconType="user"
        placeholder="请输入手机号"
        value={user}
        onChange={(v) => setUser(v)}
      />
      <LoginCommonInputItem
        type="text"
        iconType="password"
        placeholder="请输入验证码"
        value={password}
        onChange={(v) => setPassword(v)}
        extComponent={
          <div className="edit-password-code" onClick={onSendCode}>
            获取验证码
          </div>
        }
      />
      <LoginCommonAction
        isRemberPassword={isRemberPassword}
        onRemberClick={() => setRemberPassword(!isRemberPassword)}
        onForgetPasswordClick={() => {
          message.error('点击忘记密码');
        }}
        onSubmitClick={() => {
          message.error('点击立即登录');
        }}
      />
    </LoginCommonMask>
  );
}

export default EditPasswordPage;
