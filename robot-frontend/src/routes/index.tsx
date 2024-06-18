import React from 'react';
import { unstable_HistoryRouter as Router, Routes, Route  } from 'react-router-dom';
import history from '../utils/history';

const Login = React.lazy(() => import('../pages/login'));
const EditPassword = React.lazy(() => import('../pages/editPassword'));
const CenterPage = React.lazy(() => import('../pages/home'));
const Instrument = React.lazy(() => import('../pages/instrument'));

export default function RootRoute() {
  return (
    // 未正常使用createHashRouter而是用history库中的createHashHistory，所以有类型警告
    <Router history={history}>
      <React.Suspense fallback={<div>loading...</div>}>
        <Routes>
          {/* <Route path="/login" element={<Login />} />
          <Route path="/password" element={<EditPassword />} />
          <Route path="/center" element={<CenterPage />} /> */}
          {/* 仪表识别页面 */}
          <Route path="/instrument" element={<Instrument />} />
          {/* <Route path="/" element={<Login />} /> */}
        </Routes>
      </React.Suspense>
    </Router>
  );
}
