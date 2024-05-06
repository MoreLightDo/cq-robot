import React, { useState, useContext } from 'react';
import { Navigate, useNavigate } from 'react-router-dom';

import LoginCommonHooks from '../../hooks/login-common';
import LoginCommonMask from '../../components/login-common/mask';
import LoginCommonInputItem from '../../components/login-common/input-item';
import LoginCommonAction from '../../components/login-common/action';
import { login, getInfo } from '../../api/login'
import Message from '../../components/Message';
import { getToken, setToken } from '../../utils/auth'
import history from '../../utils/history';
import {useAppDispatch} from "../../redux/store";
import {updateUser} from "../../redux/reducers/UserReducer";
import {UserResponse} from "../../utils/domin";

function LoginPage() {
  console.log('LoginPage');
  const navigate = useNavigate()
  const dispatch = useAppDispatch()
  const { user, password, isRemberPassword, setUser, setPassword, setRemberPassword } = LoginCommonHooks();

  if (getToken()) {
    return <Navigate to="/center" replace />
  }

  const handleLogin = () => {
    if (!user.trim()) {
      Message.warning('请输入账号')
      return
    }

    if (!password.trim()) {
      Message.warning('请输入密码')
      return
    }

    login(user.trim(), password.trim()).then((r: any) => {
      setToken(r.token)
      getInfo().then(res => {
        dispatch(updateUser((res as UserResponse).user))
        history.push('/center')
      })
    }).catch(() => {
      Message.error('账号或密码有误')
    })
  }

  return (
    <LoginCommonMask
      title="招商车研实验室巡检机器人监控平台"
      subtitle="INSPECTION ROBOT MONITORING PLATFORM OF CHINAMERCHANTS AUTOMOBILE RESEARCH LABORATORY"
    >
      <LoginCommonInputItem
        type="text"
        iconType="user"
        placeholder="请输入账号"
        value={user}
        onChange={(v) => setUser(v)}
      />
      <LoginCommonInputItem
        type="password"
        iconType="password"
        placeholder="请输入密码"
        value={password}
        onChange={(v) => setPassword(v)}
      />
      <LoginCommonAction
        isRemberPassword={isRemberPassword}
        onRemberClick={() => setRemberPassword(!isRemberPassword)}
        onForgetPasswordClick={() => {
          navigate('/password')
        }}
        onSubmitClick={handleLogin}
      />
    </LoginCommonMask>
  );
}

export default LoginPage;
