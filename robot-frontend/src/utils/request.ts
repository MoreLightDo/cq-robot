
import axios, {InternalAxiosRequestConfig} from "axios"
import {Modal,message as Msg} from "antd";
import cache from './cache'

import {getToken, removeToken} from "./auth";
import Message from "../components/Message";
import history from "./history";

// const {baseUrl,logOut}= BaseHooks()

export const isRelogin = { show: false };

export const tansParams = (params)=> {
    let result = ''
    for (let i = 0; i < Object.keys(params).length; i++){
        const propName = Object.keys(params)[i];
        const value = params[propName];
        const part = `${propName}=`;
        if (value !== null && typeof (value) !== "undefined") {
            if (typeof value === 'object') {
                // eslint-disable-next-line no-restricted-syntax
                for (const key of Object.keys(value)) {
                    if (value[key] !== null && typeof (value[key]) !== 'undefined') {
                        const param = `${propName}[${key}]`;
                        const subPart = `${encodeURIComponent(param)}=`;
                        result += `${subPart + encodeURIComponent(value[key])}&`;
                    }
                }
            } else {
                result += `${part + encodeURIComponent(value)}&`;
            }
        }
    }
    return result
}

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'
// 创建axios实例
const service = axios.create({
    // axios中请求配置有baseURL选项，表示请求URL公共部分
    // req-url
    baseURL: window.__DEV__ ? 'cqrobot' : 'req-url',
    // 超时
    timeout: 10000
})

export interface Config{
    params?:any
    data?:any
    headers:{
        isToken?:boolean
        repeatSubmit?:boolean
        Authorization:string
    }
    method:string
    url:string
}

const errorCode = {
    '401': '认证失败，无法访问系统资源',
    '403': '当前操作没有权限',
    '404': '访问资源不存在',
    'default': '系统未知错误，请反馈给管理员'
}

// request拦截器
// eslint-disable-next-line @typescript-eslint/ban-ts-comment
// @ts-ignore
service.interceptors.request.use((config:Config) => {
    const token = getToken();
    // 是否需要设置 token
    const isToken = (config.headers || {}).isToken === false
    // 是否需要防止数据重复提交
    const isRepeatSubmit = (config.headers || {}).repeatSubmit === false
    if (token && !isToken) {
        config.headers.Authorization = `Bearer ${token}` // 让每个请求携带自定义token 请根据实际情况自行修改
    }
    // get请求映射params参数
    if (config.method === 'get' && config.params) {
        let url = `${config.url}?${tansParams(config.params)}`;
        url = url.slice(0, -1);
        config.params = {};
        config.url = url;
    }
    if (!isRepeatSubmit && (config.method === 'post' || config.method === 'put')) {
        const requestObj = {
            url: config.url,
            data: typeof config.data === 'object' ? JSON.stringify(config.data) : config.data,
            time: new Date().getTime()
        }
        const sessionObj = cache.session.getJSON('sessionObj')
        if (sessionObj === undefined || sessionObj === null || sessionObj === '') {
            cache.session.setJSON('sessionObj', requestObj)
        } else {
            const s_url = sessionObj.url;                  // 请求地址
            const s_data = sessionObj.data;                // 请求数据
            const s_time = sessionObj.time;                // 请求时间
            const interval = 1000;                         // 间隔时间(ms)，小于此时间视为重复提交
            if (s_data === requestObj.data && requestObj.time - s_time < interval && s_url === requestObj.url) {
                const message = '数据正在处理，请勿重复提交';
                console.warn(`[${s_url}]: ` + message)
                return Promise.reject(new Error(message))
            } else {
                cache.session.setJSON('sessionObj', requestObj)
            }
        }
    }
    return config
}, error => {
    console.log(error)
    Promise.reject(error)
})

// 响应拦截器
service.interceptors.response.use(res => {
        // 未设置状态码则默认成功状态
        const code = res.data.code || 200;
        // 获取错误信息
        const msg = errorCode[code] || res.data.msg || errorCode.default
        // 二进制数据则直接返回
        if(res.request.responseType ===  'blob' || res.request.responseType ===  'arraybuffer'){
            return res.data
        }
        if (code === 401) {
            if (!isRelogin.show) {
                isRelogin.show = true;
                Modal.confirm({
                    title: '系统提示',
                    content: '登录状态已过期，您可以继续留在该页面，或者重新登录',
                    okText: '重新登录',
                    cancelText: '取消',
                    onOk:() => {
                        isRelogin.show = false;
                        removeToken()
                        history.push("/login")
                    },
                    onCancel:()=>{
                        isRelogin.show = false;
                    }
                })
            }
            return Promise.reject('无效的会话，或者会话已过期，请重新登录。')
        } if (code === 500) {
            Message.error(msg)
            return Promise.reject(new Error(msg))
        } if (code !== 200) {
            Message.error(msg)
            return Promise.reject('error')
        }
            return res.data

    },
    error => {
        console.log(`err${  error}`)
        let { message } = error;
        if (message === "Network Error") {
            message = "后端接口连接异常";
        }
        else if (message.includes("timeout")) {
            message = "系统接口请求超时";
        }
        else if (message.includes("Request failed with status code")) {
            message = `系统接口${  message.substr(message.length - 3)  }异常`;
        }
        Message.error(
            message,
            5 * 1000)
        return Promise.reject(error)
    }
)

export default service
