import React from 'react'

import LoginMaskPng from '../../../assets/login/login-mask.png'
import LoginMaskTopPng from '../../../assets/login/login-mask-top.png'
import './index.less'

interface IUserPasseordCommon {
  title: string
  subtitle: string
  children: any
}

function UserPasseordCommon(props: IUserPasseordCommon) {
  const { title, subtitle, children } = props;
  return (
    <div className='login-common-mask'>
      <img src={LoginMaskPng} alt="" className='mask'/>
      <img src={LoginMaskTopPng} alt="" className='mask-top'/>
      <div className='content'>
        <div className='title'>{title}</div>
        <div className='subtitle'>{subtitle}</div>
        {children}
      </div>
    </div>
  )
}

export default UserPasseordCommon