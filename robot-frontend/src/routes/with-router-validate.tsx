import React, {useContext} from 'react'
import { Navigate } from "react-router-dom"
import userContext from "../hooks/user";

const WithRouterValidate = (components) => {
  const { username } = useContext(userContext);
    if (!username) {
      return <Navigate to="/login" replace/>
    }

    return components
}

export default WithRouterValidate
