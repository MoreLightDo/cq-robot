import request from "../utils/request";

export function getVideoTree(){
    return request({
        url:'/robot/video/list',
        method:'get'
    })
}

export function getVideoUrl(fileName){
    return request({
        url:`/robot/view/video`,
        method:'get',
        params:{
            fileName
        }
    })
}
