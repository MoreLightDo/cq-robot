export  interface Response<T>{
    msg:string
    data:T
    rows:Array<T>
    code:number
    total:number
}

export interface State {
    name: string;
    located: boolean;
    mapping: boolean;
    tasking: boolean;
    charging: boolean;
    emcyed: boolean;
    faulted: boolean;
    online?: any;
    low_power: boolean;
}

export interface Emcy {
    emcyed: boolean;
    hardware: boolean;
    software: boolean;
}

export interface Battery {
    soc: number;
    voltage: number;
    current: number;
    charging: boolean;
}

export interface Location {
    located: boolean;
    map_id: string;
    x: number;
    y: number;
    yaw: number;
}

export interface Task {
    tasking: boolean;
    name: string;
    task_id: string;
    ts: number;
    state: string;
    progress: number;
    info: string;
    code: number;
    sub_task_index: number;
}

export interface Cpu {
    freq: number;
    usage: number;
}

export interface Disk {
    total: number;
    usage: number;
    used: number;
}

export interface Memory {
    total: number;
    usage: number;
    used: number;
}

export interface Network {
    in: number;
    out: number;
}

export interface Temperature {
    cpu: number;
}

export interface Controller {
    cpu: Cpu;
    disk: Disk;
    memory: Memory;
    network: Network;
    temperature: Temperature;
}

export interface Mapping {
    floor: number;
    height: number;
    map_id: string;
    mapping: boolean;
    name: string;
    progress: number;
    resolution: number;
    rotation: number;
    ts: number;
    version: string;
    width: number;
}

export interface Vel {
    x: number;
    y: number;
    yaw: number;
}

export interface Motion {
    in_nav: boolean;
    obstacle_slow: boolean;
    obstacle_stop: boolean;
    vel: Vel;
}

export interface Static {
    this_dist: number;
    this_on_time: number;
    this_task: number;
    this_task_time: number;
    total_dist: number;
    total_on_time: number;
    total_task: number;
    total_task_time: number;
}

export interface RobotObject {
    robot_id?: string;
    name?: string;
    type?: string;
    model?: string;
    state?: State;
    emcy?: Emcy;
    battery?: Battery;
    location?: Location;
    task?: Task;
    controller?: Controller;
    mapping?: Mapping;
    motion?: Motion;
    statistics:Static
}



export interface SensorItem {
    online: boolean;
    value: number;
}

export interface Sensors {
    smoke: SensorItem;
    co: SensorItem;
    h2s: SensorItem;
    ch4: SensorItem;
    h2: SensorItem;
    temp: SensorItem;
    humi: SensorItem;
    noise: SensorItem;
}

export interface PtzInfo{
    status: string,
    horizontalDeg:string,
    verticalDeg: string,
}

export interface PtzResponse {
    level: number;
    online: boolean;
    vertical: number;
}

export interface TaskLog{
     begin_time?: string;
     end_time?: string;
     info?: string;
     parent_task_id?: string;
     state?: string;
     task_id?: string;
     task_name?: string;
}

export interface LastTask{
    begin_time: string,
    name: string,
    state: string,
    tasks: string
}

export interface TaskInfo{
    task_id: string
    name: string
}

export interface AlarmRule {
    createBy?: any;
    createTime: string;
    updateBy?: any;
    updateTime?: any;
    remark?: any;
    id: number;
    label: string;
    type: string;
    alarmValue: number;
    alarmUnit: string;
    alarmLevel: number;
    status: string;
}

export interface AlarmLog {
    createBy?: any;
    createTime: string;
    updateBy?: any;
    updateTime?: any;
    remark?: any;
    id: number;
    index: number;
    ruleId: number;
    triggerTime: string;
    message: string;
    alarmValue: number;
    alarmJson: string;
    status?: any;
    infoId: number;
    rule:AlarmRule
}

export interface AlarmLogRule {
    id:number,
    label: string;
    type: string;
    alarmUnit: string;
    alarmLevel: number;
    alarmValue: number;
}

export interface Forward {
    enable: boolean;
    max_x: number;
    max_y: number;
    max_yaw: number;
    orientation: number;
}

export interface Begin {
    point_id: string;
    x: number;
    y: number;
    yaw: number;
}

export interface Ctrl0 {
    point_id: string;
    x: number;
    y: number;
}

export interface Ctrl1 {
    point_id: string;
    x: number;
    y: number;
}

export interface End {
    point_id: string;
    x: number;
    y: number;
    yaw: number;
}

export interface Path {
    begin: Begin;
    ctrl0: Ctrl0;
    ctrl1: Ctrl1;
    end: End;
}

export interface Reverse {
    enable: boolean;
    max_x: number;
    max_y: number;
    max_yaw: number;
    orientation: number;
}

export interface PathInfo {
    forward: Forward;
    name: string;
    path: Path;
    path_id: string;
    reverse: Reverse;
    type: string;
}

export interface PointCloud {
    depth: number;
    points: number[][];
}

export interface Point {
    map_id: string;
    name: string;
    point_id: string;
    type: string;
    x: number;
    y: number;
    yaw: number;
}

export interface Map {
    areas: any[];
    floor: number;
    height: number;
    map_id: string;
    name: string;
    paths: PathInfo[];
    point_clouds: PointCloud[];
    points: Point[];
    resolution: number;
    rotation: number;
    ts: number;
    version: string;
    width: number;
}

export interface Dept {
    createBy?: any;
    createTime?: any;
    updateBy?: any;
    updateTime?: any;
    remark?: any;
    deptId: number;
    parentId: number;
    ancestors: string;
    deptName: string;
    orderNum: number;
    leader: string;
    phone?: any;
    email?: any;
    status: string;
    delFlag?: any;
    parentName?: any;
    children: any[];
}

export interface Role {
    createBy?: any;
    createTime?: any;
    updateBy?: any;
    updateTime?: any;
    remark?: any;
    roleId: number;
    roleName: string;
    roleKey: string;
    roleSort: number;
    dataScope: string;
    menuCheckStrictly: boolean;
    deptCheckStrictly: boolean;
    status: string;
    delFlag?: any;
    flag: boolean;
    menuIds?: any;
    deptIds?: any;
    permissions?: any;
    admin: boolean;
}

export interface User {
    createBy: string;
    createTime: string;
    updateBy?: any;
    updateTime?: any;
    remark: string;
    userId: number;
    deptId: number;
    userName: string;
    nickName: string;
    email: string;
    phonenumber: string;
    sex: string;
    avatar: string;
    password: string;
    status: string;
    delFlag: string;
    loginIp: string;
    loginDate: string;
    dept: Dept;
    roles: Role[];
    roleIds?: any;
    postIds?: any;
    roleId?: any;
    admin: boolean;
}

export interface UserResponse {
    msg: string;
    code: number;
    permissions: string[];
    roles: string[];
    user: User;
}


export interface SensorInfo {
    createBy?: any;
    createTime: string;
    updateBy?: any;
    updateTime?: any;
    remark?: any;
    id: number;
    type: string;
    isOnline: number;
    value: number;
    status: string;
    logId: number;
}

export interface SensorLog {
    createBy?: any;
    createTime: string;
    updateBy?: any;
    updateTime: string;
    remark?: any;
    id: number;
    name: string;
    status: string;
    sensorInfos: SensorInfo[];
}
