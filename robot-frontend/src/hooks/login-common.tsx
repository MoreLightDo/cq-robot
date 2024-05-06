import { useState, useRef } from "react"
import {login} from "../api/login";

const LoginCommonHooks = () => {
  const [user, setUser] = useState('')
  const [password, setPassword] = useState('')
  const [isRemberPassword, setRemberPassword] = useState(false)
  const isRequesting = useRef(false) // 预留接口调用拦截

  const handleLogin = () => {
    login(user,password).then(res=>{
      console.log(res)
    })
  }

  return {
    user,
    password,
    isRemberPassword,
    setUser,
    setPassword,
    setRemberPassword,
    handleLogin
  }
}

export default LoginCommonHooks
