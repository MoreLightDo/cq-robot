import Cron from "qnn-react-cron";
import React, {useEffect, useRef, useState} from 'react';
import dayjs from "dayjs";
import {Button, Col, Row, Dropdown, MenuProps, message, Space, Input, Select, Modal, Table, Tag, Alert} from 'antd';
import cls from 'classnames';
import {useDateAndTime} from '../../hooks';
import taskMenu from '../../assets/homePage/task-menu.png';
import './index.less';
import {
    delScheduledtaskList,
    doTask,
    getAgvInfo, getFeas, getLastTask,
    getScheduledtaskList,
    getTaskList,
    getTaskLog,
    setScheduledtask
} from "../../api/robot";
import {LastTask, RobotObject, Task, TaskInfo, TaskLog} from "../../utils/domin";
import {timestampToTime} from "../../utils/timeUtil";
import Message from "../Message";


export default function TaskMenu(props) {
    const [activeTab, setActiveTab] = useState('curTask');
    const {date, day} = useDateAndTime();
    const [cron, setcron] = useState("");
    const [jobName, setjobName] = useState("")
    const [robotInfo, setRobotInfo] = useState<RobotObject>(null)
    const [ScheduledtaskList, setScheduledtaskList] = useState([])
    const CronRef = useRef<Cron.CronFns>(null)
    const [messageApi, contextHolder] = message.useMessage();
    const [queryParma, setQueryParma] = useState({
        pageNum: 1,
        pageSize: 10
    })

    const [dataTimes,setDataTimes] = useState()

    const [info, setinfo] = useState({
        taskId: '',
        jobName: '',
        jobCorn: '',
        taskName: ''
    })

    const [taskid, settaskid] = useState("")
    const [id, setid] = useState("")
    const [name, setname] = useState("")
    const Tabs = [
        {label: '当前任务', value: 'curTask'},
        {label: '任务日志', value: 'preTask'},
        {label: '任务管理', value: 'newTask'},
    ];

    const [currentTask, setCurrentTask] = useState({
        dateAndTime: {label: '今日日期', value: `${date}  ${day}`},
        checkPoint: {label: '巡检点', value: '已完42个，共42个'},
        startDate: {label: '开始日期', value: '2022-09-15 12:20:50'},
        taskName: {label: '任务名称', value: '定时巡检'},
        checkItem: {label: '巡检项', value: '电池实验室'},
    });

    const [lastTask,setLastTask] = useState({
        lastTask: {label: '上一任务', value: `${date}  ${day}`},
        checkPoint: {label: '巡检点', value: '已完42个，共42个'},
        startDate: {label: '开始日期', value: '2022-06-25'},
        status: {label: '状态', value: '正常'}
    })

    const [taskLogs, setTaskLog] = useState<Array<TaskLog>>([{
        task_name:'',
        state:"",
        info:"",
        begin_time:"",
        end_time:''
    }])
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [isTaskdetailsModalOpen, setIsTaskdetailsModalOpen] = useState(false);
    const [tasks, setTasks] = useState<Array<TaskInfo>>(null)

    const success = (msg:string) => {
        messageApi.open({
            type: 'success',
            content: msg,
            duration: 1,
        });
    };

    const closeCron = (cron) => {
        setcron(cron)
        setIsModalOpen(false);
    }

    const getAgv = () => {
        getAgvInfo().then(res => {
            setRobotInfo(res.data)
        })
    }

    const getLog = () => {
        getTaskLog().then(res => {
            setTaskLog(res.data)
        })
    }

    const getTasks = () => {
        getTaskList().then(res => {
            setTasks(res.data)
            console.log(res.data)
        })
    }

    const getScheduledtask = () => {
        getScheduledtaskList(queryParma).then(res => {
            setScheduledtaskList(res.rows)
            console.log(res)
        })
    }

    const delScheduledtask = (id) => {
        delScheduledtaskList(id).then(res => {
            messageApi.open({
                type: 'success',
                content: res.msg,
                duration: 1,
            });
            getScheduledtask()
            console.log(res)
        })
    }

    const pageOnChange = (val) => {
        setQueryParma({
            ...queryParma,
            pageNum: val
        })
    };
    const pageSizeChange = (page, pageSize) => {
        setQueryParma({
            ...queryParma,
            pageSize
        })
    };

    const language = {

        // 面板标题,
        // panel title,
        paneTitle:{
            second: "秒",
            minute: "分",
            hour: "时",
            day: "日",
            month: "月",
            week: "周",
            year: "年",
        },

        // assign  指定
        assign: "指定",
        // Don't assign  不指定
        donTAssign: "不指定",
        // Every minute ...   每一秒钟、每一分钟
        everyTime: {
            second: "每一秒钟",
            minute: "每一分钟",
            hour: "每一小时",
            day: "每一日",
            month: "每一月",
            week: "每一周",
            year: "每年",
        },

        // weel option  周选项
        week: {
            sun: "星期日",
            mon: "星期一",
            tue: "星期二",
            wed: "星期三",
            thu: "星期四",
            fri: "星期五",
            sat: "星期六",
        },

        // from [a] to [b] [unit], executed once [unit]    a 到 b 每一个时间单位执行一次
        aTob: {
            second: (AInput, BInput) => (
                <span>
                    从{AInput}-{BInput}秒，每秒执行一次
                </span>
            ),
            minute: (AInput, BInput) => (
                <span>
                    从{AInput}-{BInput}分，每分钟执行一次
                </span>
            ),
            hour: (AInput, BInput) => (
                <span>
                    从{AInput}-{BInput}时，每小时执行一次
                </span>
            ),
            day: (AInput, BInput) => (
                <span>
                    从{AInput}-{BInput}日，每日执行一次
                </span>
            ),
            month: (AInput, BInput) => (
                <span>
                    从{AInput}-{BInput}月，每月执行一次
                </span>
            ),
            week: (AInput, BInput) => (
                <span>
                    从{AInput}-{BInput}，每星期执行一次
                </span>
            ),
            year: (AInput, BInput) => (
                <span>
                    从{AInput}-{BInput}年，每年执行一次
                </span>
            ),
        },

        // from [a] [unit] start, every [b] Execute once [unit]   从 a 开始, 每一个时间单位执行一次
        aStartTob: {
            second: (AInput, BInput) => (
                <span>
                    从{AInput}秒开始，每{BInput}秒执行一次
                </span>
            ),
            minute: (AInput, BInput) => (
                <span>
                    从{AInput}分开始，每{BInput}分执行一次
                </span>
            ),
            hour: (AInput, BInput) => (
                <span>
                    从{AInput}时开始，每{BInput}小时执行一次
                </span>
            ),
            day: (AInput, BInput) => (
                <span>
                    从{AInput}日开始，每{BInput}日执行一次
                </span>
            ),
            month: (AInput, BInput) => (
                <span>
                    从{AInput}月开始，每{BInput}月执行一次
                </span>
            ),

            // [n] in the NTH week of this month    本月第 n 周的 星期[n] 执行一次
            week: (AInput, BInput) => (
                <span>
                    本月第{AInput}周的{BInput}执行一次
                </span>
            ),

            // 本月的最后一个 星期[n] 执行一次
            week2: (AInput) => <span>月的最后一个{AInput}执行一次</span>,

            year: (AInput, BInput) => (
                <span>
                    从{AInput}年开始，每{BInput}年执行一次
                </span>
            ),
        }

    };

    const columns = [
        {
            title: '任务名称',
            dataIndex: 'taskName',
            key: 'taskName',
        },
        {
            title: '定时任务备注',
            dataIndex: 'jobName',
            key: 'jobName',
        },
        {
            title: '定时任务corn表达式',
            dataIndex: 'jobCorn',
            key: 'jobCorn',
        },
        {
            title: '最后次运行时间',
            dataIndex: 'lastTriggerTime',
            key: 'lastTriggerTime',
            render: (v, row) => {
                if (row.lastTriggerTime === null) {
                    return (
                        <div style={{color: "rgb(222,188,38)"}}>未查询到最后运行时间</div>
                    )

                }
                    const day = dayjs(row.lastTriggerTime)
                    return day.format('YYYY/MM/DD HH/mm/ss')

            }
        },
        {
            title: '任务状态',
            dataIndex: 'status',
            key: 'status',
            render: (v, row) => {
                if (row.status === 0) {
                    return "正在运行"
                } else if (row.status === 1) {
                    return "停止状态"
                }
            }
        },
        {
            title: '触发次数',
            dataIndex: 'triggerTimes',
            key: 'triggerTimes',
        },
        {
            title: '操作',
            key: 'action',
            render: (v, row) => (
                <Space size="middle">
                    <a onClick={() => delScheduledtask(row.id)}>删除任务</a>
                </Space>
            ),
        },
    ];

    const getLastTaskInfo = ()=> {
        getLastTask().then(res => {
            const last: LastTask = res.data
            setLastTask(prevState => ({
                lastTask: {label: "上个任务", value: last.name},
                checkPoint: {label: '巡检点', value: last.tasks},
                startDate: {label: '开始日期', value: last.begin_time},
                status: {label: '状态', value: last.state}
            }))
        })
    }

    const taskDo = (id) => {
        doTask(taskid).then(res => {
            if (res.data.ack === 0) {
                Message.success("操作成功")
            } else {
                Message.error(res.data.msg)
            }
        })
    }

    const showModal = () => {
        setIsModalOpen(true);
    };

    const handleOk = () => {
        setIsModalOpen(false);
    };

    const handleCancel = () => {
        setIsModalOpen(false);
    };

    const showTaskdetails = () => {
        setIsTaskdetailsModalOpen(true);
        getScheduledtask()
    };

    const handleTaskdetailsOk = () => {
        setIsTaskdetailsModalOpen(false);
    };

    const handleTaskdetailsCancel = () => {
        setIsTaskdetailsModalOpen(false);
    };

    const handleChange = (v: string) => {
        setid(tasks[v].task_id)
        setname(tasks[v].name)
    };

    const handleChangenow = (v: string) => {
        settaskid(tasks[v].task_id)
        setname(tasks[v].name)
    };


    const settingcron = () => {
        if ((id && jobName && name ) !== "") {
            info.taskId = id
            info.jobName = jobName
            info.taskName = name
            info.jobCorn = cron

            setScheduledtask(info).then(res => {
                console.log(res)
                if(res.code === 200){
                    success(res.msg)
                }
            })

            setinfo({
                ...info,
                taskId:'',
                jobName: '',
                jobCorn: '',
                taskName: ''
            })
            setcron("")
            setjobName("")
            setIsModalOpen(false)

        } else {
           alert("请确保信息输入完整")
        }
    }

    const showParse = () => {
        const value : string = CronRef.current.getValue();
        const s1 = value.split(" ").filter((i, index, a)=>index !== a.length-1)
            .map((i,index)=>index === 0 ? "0" : i)
            .map((i,index)=>(index === 1 && i === "?") ? "*" : i)
            .map((i,index)=>(index === 2 && i === "?") ? "*" : i)
            .join(" ");

        console.log(s1)

        getFeas(s1).then(res=>{
            setDataTimes(res.data.map(it=>dayjs(it).format("YYYY/MM/DD HH:mm:ss")))
        })
    }

    useEffect(() => {
        getAgv()
        getLog()
        getTasks()
        getLastTaskInfo()
    }, [])

    useEffect(()=>{
        if (dataTimes != null){
            Modal.confirm({
                title:<div style={{color:"white",textAlign:"center"}}>
                    预计接下来10次运行时间
                </div>,
                icon:null,
                content:<ul>
                    {
                        dataTimes.map((it,i)=><li style={{color:"white"}} key={i}>{it}</li>)
                    }
                </ul>
            })
        }
    },[dataTimes])


    useEffect(() => {
        if (robotInfo == null) {
            return
        }
        setCurrentTask((v) => ({
            ...v,
            checkPoint: {
                label: '任务状态',
                value: robotInfo.task.state
            },
            startDate: {
                label: '开始日期',
                value: timestampToTime(robotInfo.task.ts / 1000)
            },
            taskName: {label: '任务名称', value: robotInfo.task.name},
            checkItem: {
                label: '任务进度',
                value: `${robotInfo.task.progress.toFixed(2)}%`
            }
        }))
    }, [robotInfo])

    const getValue = () => {
        const cronStr  = CronRef.current.getValue()
        const s1 = cronStr.split(" ").filter((i, index, a)=>index !== a.length-1)
            .map((i,index)=>index === 0 ? "0" : i)
            .map((i,index)=>(index === 1 && i === "?") ? "*" : i)
            .map((i,index)=>(index === 2 && i === "?") ? "*" : i)
            .join(" ")
            .concat(" ","*");

        console.log(s1)
        closeCron(s1)
    }

    return (

        <div className="task-menu">
             {contextHolder}
            <img src={taskMenu} alt="taskMenu" className="task-menu-img"/>
            <div className="task-menu-tabs">
                {Tabs.map((item) => (
                    <Button
                        key={item.value}
                        className={cls({
                            'task-menu-tab': true,
                            'tab-active': activeTab === item.value,
                        })}
                        onClick={() => setActiveTab(item.value)}
                    >
                        {item.label}
                    </Button>
                ))}
            </div>
            {
                activeTab === Tabs[0].value && <div>
                    <div className="task-menu-content">
                        {Object.entries(currentTask).map(([k, v]) => (
                            <div className="task-menu-row" key={k}>
                                <span className="task-menu-label">{v.label}：</span>
                                <span className="task-menu-value">{v.value}</span>
                            </div>
                        ))}
                    </div>
                    <div className="task-menu-divider"/>
                    <div className="task-menu-content">
                        {Object.entries(lastTask).map(([k, v]) => (
                            <div className="task-menu-row" key={k}>
                                <span className="task-menu-label">{v.label}：</span>
                                <span className="task-menu-value">{v.value}</span>
                            </div>
                        ))}
                    </div>
                </div>
            }
            {
                activeTab === Tabs[1].value &&
                <div className="task-menu-content">
                    <div className="task-list-content">
                        {
                            taskLogs.map((v, k) => (
                                <div className="task-list-item" key={k}>
                                    <div className="task-list-row">
                                        <span className="task-item-label">任务名称：</span>
                                        <span className="task-item-value">{v.task_name}</span>
                                    </div>
                                    <div className="task-list-row">
                                        <span className="task-item-label">任务状态：</span>
                                        <span className="task-item-value">{v.state}</span>
                                    </div>
                                    <div className="task-list-row">
                                        <span className="task-item-label">任务信息：</span>
                                        <span className="task-item-value">{v.info == "" ? '无错误信息' : v.info}</span>
                                    </div>
                                    <div className="task-list-row">
                                        <span className="task-item-label">开始时间：</span>
                                        <span className="task-item-value">{v.begin_time}</span>
                                    </div>
                                    <div className="task-list-row">
                                        <span className="task-item-label">结束时间：</span>
                                        <span className="task-item-value">{v.end_time}</span>
                                    </div>
                                </div>
                            ))
                        }
                    </div>

                </div>
            }
            {
                activeTab === Tabs[2].value &&
                <div className="task-menu-content">
                    <div className="task-list-content">
                        <div className="task-list-item">
                            <div className="task-list-row">
                                <Row>
                                    <Col span={6}>
                                        <span className="task-item-label">巡检任务：</span>
                                    </Col>
                                    <Col span={12}>
                                        <Select style={{width:150}} onChange={handleChangenow}>
                                            {
                                                (tasks || []).map((v, k) => (
                                                    <span key={k}>{v.name}</span>
                                                ))
                                            }
                                        </Select>
                                    </Col>
                                    <Col span={6}>
                                        <Button onClick={taskDo}>执行</Button>
                                    </Col>
                                </Row>
                            </div>
                        </div>
                        <div style={{color: "white"}}>手动设置定时任务</div>
                        <div className="task-list-item">
                            <div className="task-list-row">
                                <span className="task-item-label">巡检任务：</span>
                                <span className="task-item-value">
                                     <Select
                                         className="Input"
                                         onChange={handleChange}
                                     >
                                    {
                                        (tasks || []).map((v, k) => (
                                            <span key={k}>{v.name}</span>
                                        ))
                                    }
                                </Select>
                                </span>
                            </div>

                            <div className="task-list-row">
                                <span className="task-item-label">任务备注：</span>
                                <span className="task-item-value">
                                     <Input onChange={e => setjobName(e.target.value)}
                                            value={jobName}
                                            style={{
                                                backgroundColor: "#0c2256e3",
                                                border: "1px solid aqua;",
                                                color: "#d4eaf6",
                                                width: "220px"
                                            }}
                                            className="Input">
                                     </Input>
                                </span>
                            </div>

                            <div className="task-list-row">
                                <span className="task-item-label">时间：</span>
                                <span className="task-item-value">
                                        <Input
                                            onClick={showModal}
                                            value={cron}
                                            style={{
                                                backgroundColor: "#0c2256e3",
                                                border: "1px solid aqua",
                                                color: "#d4eaf6",
                                                width: "220px"
                                            }}
                                            className="Input">
                                        </Input>
                                </span>
                            </div>

                            <Row align="middle" justify="center">
                                <Col span={12}>
                                    <Row>
                                        <Col span={14}>
                                            <Button onClick={settingcron} >添加任务</Button>
                                        </Col>
                                        <Col span={10}>
                                            <Button onClick={showTaskdetails}  style={{backgroundColor: "rgb(255,255,255)"}}>查看任务</Button>
                                        </Col>
                                    </Row>


                                </Col>
                            </Row>


                            <Modal
                                title="定时任务"
                                open={isModalOpen}
                                onOk={handleOk}
                                onCancel={handleCancel}
                                style={{color: "white"}}
                                footer={null}>
                                <Space direction='vertical' style={{width: '100%'}}>
                                    <Cron.Provider value={{
                                        language
                                    }}>
                                    <Cron
                                        defaultType='customize'
                                        onOk={closeCron}
                                        style={{left: 0, top: 0}}
                                        getCronFns={fns => {
                                            CronRef.current = fns
                                        }}
                                        panesShow={{
                                            second: false,
                                            minute: true,
                                            hour: true,
                                            day: true,
                                            month: true,
                                            week: false,
                                            year: false,
                                        }}
                                        defaultTab={"minute"}
                                        footer={[
                                            <>
                                                <Button type="dashed" onClick={showParse}>
                                                    预览
                                                </Button>
                                                <Button type="primary" onClick={getValue}>
                                                    生成
                                                </Button>
                                            </>,
                                        ]}
                                    />
                                    </Cron.Provider>
                                </Space>
                            </Modal>
                        </div>

                        <Modal
                            width={1000}
                            title="定时任务"
                            open={isTaskdetailsModalOpen}
                            onOk={handleTaskdetailsOk}
                            onCancel={handleTaskdetailsCancel}
                            style={{color: "white"}}
                            footer={null}>
                            <div className="task-list-item">
                                <Table
                                    dataSource={ScheduledtaskList}
                                    columns={columns}
                                    className="warning-info-table"
                                    pagination={{
                                        position: ['bottomCenter'],
                                        onChange: pageOnChange, // 页码变化回调函数
                                        showQuickJumper: false, // 是否显示快速跳转
                                        defaultPageSize: 5,
                                        showSizeChanger: true,  // 是否显示页面大小变化选择框
                                        onShowSizeChange: pageSizeChange,
                                        pageSizeOptions: ["5", "10", "20", "50"],  // 页面大小变化选择框中可选变化
                                    }}
                                />
                            </div>

                        </Modal>
                    </div>

                </div>
            }
        </div>
    );
}
