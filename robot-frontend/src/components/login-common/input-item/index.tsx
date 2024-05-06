import React from 'react'

import userPng from '../../../assets/login/user.png'
import passwordPng from '../../../assets/login/password.png'
import './index.less'

interface IInputItem {
  type: 'text' | 'password' // 输入框的类型
  iconType: 'user' | 'password' // icon的类型
  placeholder: string
  value: string
  extComponent?: any
  onChange: (v: string) => void
}
function index(props: IInputItem) {
  const { type, iconType, value, placeholder, extComponent, onChange } = props;

  return (
    <div className='login-common-input-item'>
      <img src={iconType === 'user' ? userPng: passwordPng} alt="" className='icon'/>
      <input
        type={type}
        className='item'
        placeholder={placeholder}
        value={value}
        onChange={e => onChange(e.target.value)}
      />
      {extComponent}
    </div>
  )
}

export default index