import React from 'react';
import { unstable_HistoryRouter as Router, Routes, Route  } from 'react-router-dom';
import { ConfigProvider } from 'antd';
import history from '../utils/history';
import locale from 'antd/es/locale/zh_CN';

const Login = React.lazy(() => import('../pages/login'));
const EditPassword = React.lazy(() => import('../pages/editPassword'));
const CenterPage = React.lazy(() => import('../pages/home'));
const InstrumentPannel = React.lazy(() => import('../pages/instrumentPannel'));
const MonitorPlatForm = React.lazy(() => import('../pages/instrument'));
const IntelligentOps = React.lazy(() => import('../pages/intelligentOps'));

export default function RootRoute() {
  return (
    // 未正常使用createHashRouter而是用history库中的createHashHistory，所以有类型警告
    <ConfigProvider locale={locale}>
      <Router history={history}>
        <React.Suspense fallback={<div>loading...</div>}>
          <Routes>
            <Route path="/login" element={<Login />} />
            <Route path="/password" element={<EditPassword />} />
            <Route path="/center" element={<CenterPage />} />
            {/* 仪表识别页面 */}
            <Route path="/instrument" element={<InstrumentPannel />} />
            {/* 监控平台页面 */}
            <Route path="/monitorPlatform" element={<MonitorPlatForm />} />
            {/* 智能运维页面 */}
            <Route path="/intelligentOps" element={<IntelligentOps />} />
            <Route path="/" element={<Login />} />
          </Routes>
        </React.Suspense>
      </Router>
    </ConfigProvider>
  );
}
