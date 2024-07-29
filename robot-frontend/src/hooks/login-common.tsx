import { useState } from 'react';

const LoginCommonHooks = () => {
  const [user, setUser] = useState('')
  const [password, setPassword] = useState('')
  const [isRemberPassword, setRemberPassword] = useState(false)

  return {
    user,
    password,
    isRemberPassword,
    setUser,
    setPassword,
    setRemberPassword,
  }
}

export default LoginCommonHooks
