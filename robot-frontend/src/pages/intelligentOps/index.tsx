import React from 'react';
import { Form, Input, DatePicker, Select, Button, Table } from 'antd';
import HistoryLogChart from '@/components/HistoryLogChart';
import settingIcon from '@/assets/center/setting.png';
import './index.less';

const FormItem = Form.Item;

export default function IntelligentOps(props) {
  // 页面切换
  const pageChange = (path) => {
    // history.push(path);
  };

  const t = [
    {
      indexNo: '01',
      operationalStatus: '点位名称',
      abnormal: '2024/10/20 18:20',
      refRange: '10-100',
      key: '01',
      status: '0',
    },
    {
      indexNo: '02',
      operationalStatus: '点位名称',
      abnormal: '2024/10/20 18:20',
      refRange: '10-100',
      key: '02',
      status: '0',
    },
    {
      indexNo: '03',
      operationalStatus: '点位名称',
      abnormal: '2024/10/20 18:20',
      refRange: '10-100',
      key: '03',
      status: '0',
    },
    {
      indexNo: '04',
      operationalStatus: '点位名称',
      abnormal: '2024/10/20 18:20',
      refRange: '10-100',
      key: '04',
      status: '1',
    },
    {
      indexNo: '05',
      operationalStatus: '点位名称',
      abnormal: '2024/10/20 18:20',
      refRange: '10-100',
      key: '05',
      status: '0',
    },
    {
      indexNo: '06',
      operationalStatus: '点位名称',
      abnormal: '2024/10/20 18:20',
      refRange: '10-100',
      key: '06',
      status: '0',
    },
  ]

  // 机器人日志mock
  const t1 = [
    { label: '累计执行任务数', value: '100个' },
    { label: '工作次数', value: '70次' },
    { label: '累计时长', value: '50h' },
    { label: '电池循环次数', value: '100次' },
  ];

  return (
    <div className='intelligent-page'>
      <div className='intelligent-page-header'>
        <a className='page-button' onClick={() => pageChange('xxx')}>首页</a>
        <span className='header-left-elements'>
          <span className='data-and-time-item'>2024-01-25</span>
          <span className='data-and-time-item'>17:01:05</span>
          <span className='data-and-time-item'>星期一</span>
        </span>
        <span className='header-right-elements'>
          {/* 下列跳转可能本期还没有 */}
          <a className='page-button' onClick={() => pageChange('xxx')}>仪表识别</a>
          <a className='page-button' onClick={() => pageChange('xxx')}>智能运维</a>
          <a className='page-button' onClick={() => pageChange('xxx')}>智能群控系统</a>
          <a className='page-button' onClick={() => pageChange('xxx')}>数据记录</a>
          <img className='setting-icon' alt='settingIcon' src={settingIcon} />
        </span>
      </div>
      <div className='intelligent-page-body'>
        <div className='upper'>
          <div className='left'>
            <p className='title'>查询选项</p>
            <div className='content'>
              <Form>
                <FormItem name='dwmc' label='点位名称'>
                  <Input placeholder='请输入' />
                </FormItem>
                <FormItem name='bjqk' label='报警情况'>
                  <Select placeholder='请选择' allowClear options={[{ label: 's', value: 's' }]} />
                </FormItem>
                <FormItem name='kssj' label='开始时间'>
                  <DatePicker placeholder='请选择' showTime />
                </FormItem>
                <FormItem name='jssj' label='结束时间'>
                  <DatePicker placeholder='请选择' showTime />
                </FormItem>
                <FormItem name='ddmc' label='待定名称'>
                  <Select placeholder='请选择' />
                </FormItem>
                <FormItem name='ddmc1' label='待定名称'>
                  <Select placeholder='请选择' />
                </FormItem>
                <FormItem className='btns'>
                  <Button type='primary'>
                    查询
                  </Button>
                  <Button htmlType='button'>
                    重置
                  </Button>
                </FormItem>
              </Form>
              <Table
                className='intelligent-page-table table1'
                bordered={false}
                columns={[
                  {
                    title: '序号',
                    dataIndex: 'indexNo',
                  },
                  {
                    title: '点位名称',
                    dataIndex: 'operationalStatus',
                  },
                  {
                    title: '运维时间',
                    dataIndex: 'abnormal',
                  },
                  {
                    title: '数值',
                    dataIndex: 'refRange',
                  },
                  {
                    title: '情况',
                    dataIndex: 'status',
                    render: (v) => <span
                      style={{ color: v === '0' ? '#00FF48' : '#FFC000' }}
                    >{v === '0' ? '正常' : '异常'}</span>
                  },
                ]}
                pagination={{
                  current: 1,
                  pageSize: 6,
                  total: 30,
                }}
                dataSource={t}
              />
            </div>
          </div>
          <div className='right'>
            <p className='title'>机器人日志</p>
            <div className='robot-log'>
              <div className='robot-log-content'>
                {t1.map(item => (
                  <div key={item.label} className='label-item'>
                    <div className='value'>{item.value}</div>
                    <div className='label'>{item.label}</div>
                  </div>
                ))}
              </div>
              <div className='robot-maintenance'>
                <div className='maintenance-icon'></div>
                <div className='maintenance-content'>
                  <div className='percent'>50%</div>
                  <div className='maintenance-title'>部件保养</div>
                  <div className='progress'>
                    <div></div>
                  </div>
                  <div className='maintenance-info'>定时保养时间到，建议清理部件</div>
                  <div className='maintenance-btns'>
                    <Button ghost className='blue'>我已清理</Button>
                    <Button ghost className='white'>查看详情</Button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div className='lower'>
          <div className='left'>
            <p className='title'>历史数值</p>
            <div className='content'>
              <Form>
                <FormItem name='kssj' label='开始时间'>
                  <DatePicker placeholder='请选择' showTime />
                </FormItem>
                <FormItem name='jssj' label='结束时间'>
                  <DatePicker placeholder='请选择' showTime />
                </FormItem>
                <FormItem name='ddmc' label='待定名称'>
                  <Select placeholder='请选择' />
                </FormItem>
                <FormItem className='btns'>
                  <Button type='primary'>
                    查询
                  </Button>
                  <Button htmlType='button'>
                    重置
                  </Button>
                </FormItem>
              </Form>
              <Table
                className='intelligent-page-table table2'
                bordered={false}
                columns={[
                  {
                    title: '序号',
                    dataIndex: 'indexNo',
                  },
                  {
                    title: '点位名称',
                    dataIndex: 'operationalStatus',
                  },
                  {
                    title: '运维时间',
                    dataIndex: 'abnormal',
                  },
                  {
                    title: '数值',
                    dataIndex: 'refRange',
                  },
                  {
                    title: '情况',
                    dataIndex: 'status',
                    render: (v) => <span
                      style={{ color: v === '0' ? '#00FF48' : '#FFC000' }}
                    >{v === '0' ? '正常' : '异常'}</span>
                  },
                ]}
                pagination={{
                  current: 1,
                  pageSize: 5,
                  total: 30,
                }}
                dataSource={t}
              />
            </div>
          </div>
          <div className='right'>
            <p className='title'>历史记录</p>
            <div className='history'>
              <Form>
                <FormItem name='kssj' label='开始时间'>
                  <DatePicker placeholder='请选择' showTime />
                </FormItem>
                <FormItem name='jssj' label='结束时间'>
                  <DatePicker placeholder='请选择' showTime />
                </FormItem>
                <FormItem className='btns'>
                  <Button type='primary'>
                    查询
                  </Button>
                  <Button htmlType='button'>
                    重置
                  </Button>
                </FormItem>
                <HistoryLogChart />
              </Form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
