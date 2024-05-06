import request from '../utils/request';
import {Response, RobotObject} from "../utils/domin";

export function getAgvInfo():Promise<Response<RobotObject>> {
  return request({
    url: '/robot/agv_info',
    method: 'get',
  });
}

export function getSensors() {
  return request({
    url: '/robot/sensors',
    method: 'get',
  });
}

export function getRobotInfo() {
  return request({
    url: '/robot/info',
    method: 'get',
  });
}

export function getLastTask(){
  return request({
    url: '/robot/last_task',
    method:'get'
  })
}

export function getPtzInfo() {
  return request({
    url: '/robot/ptz',
    method: 'get',
  });
}

export function ctrlPtz(data) {
  return request({
    url: '/robot/ptz_ctrl',
    method: 'post',
    data,
  });
}

export function getTaskList() {
  return request({
    url: '/robot/tasks',
    method: 'get',
  });
}

export function doTask(taskId) {
  return request({
    url: `/robot/dotask/${taskId}`,
    method: 'get',
  });
}

export function getTaskLog() {
  return request({
    url: '/robot/task_log',
    method: 'get',
  });
}

export function getMapList() {
  return request({
    url: '/robot/mapList',
    method: 'get',
  });
}

export function getMapInfo(id) {
  return request({
    url: `/robot/mapInfo/${id}`,
    method: 'get',
  });
}

export function getAlarmLog(data){
  return request({
    url: '/robot/alarm/log/list',
    method:'get',
    params:data
  })
}

export function getSensorInfo(data){
  return request({
    url:'/robot/sensor/list',
    method:'get',
    params:data
  })
}

export function getAlarmTablerule(){
  return request({
    url:'/alarm/rule/list',
    method:'get',
  })
}

export function setScheduledtask(data) {
  return request({
    url:'/cornjob/job',
    method:'post',
    data
  })
}

export function getScheduledtaskList(data) {
  return request({
    url:`/cornjob/job/list`,
    params:data,
    method:'get',
  })
}

export function delScheduledtaskList(id) {
  return request({
    url:`/cornjob/job/${id}`,
    method:'delete',
  })
}

export function getFeas(corn) {
  return request({
    url:`/cornjob/job/features`,
    method:'get',
    params:{
      corn
    }
  })
}

export function update(data){
  return request({
    url:'/alarm/rule',
    method:'post',
    data
  })
}
