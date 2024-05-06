import React from 'react'

import checkboxPng from '../../../assets/common/checkbox.png'
import checkboxActivePng from '../../../assets/common/checkbox-active.png'
import './index.less'

interface IAction {
  isRemberPassword: boolean
  onRemberClick: () => void
  onForgetPasswordClick: () => void
  onSubmitClick: () => void
}
function Action(props: IAction) {
  const { isRemberPassword, onRemberClick, onForgetPasswordClick, onSubmitClick } = props
  return (
    <>
      <div className='login-common-action'>
        <div className="rember" onClick={onRemberClick}>
          <img src={isRemberPassword ? checkboxActivePng : checkboxPng} alt="" />
          记住密码
        </div>
        <div className="forget" onClick={onForgetPasswordClick}>忘记密码？</div>
      </div>
      <div className='login-common-submit' onClick={onSubmitClick}>点 击 登 录</div>
    </>
  )
}

export default Action