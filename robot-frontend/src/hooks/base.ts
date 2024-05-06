import {useState} from "react";
import {useNavigate} from "react-router-dom";
import {getToken, setToken} from "../utils/auth";

const BaseHooks = ()=>{
    const token = getToken()
    const profile = 'dev'
    const urls = {
        'dev':'localhost:8080/'
    }

    const logOut = ()=>{
        setToken('')
    }

    return {
        token,
        baseUrl:urls[profile],
        logOut
    }
}

export default BaseHooks
