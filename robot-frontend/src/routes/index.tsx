import React from 'react';
import { unstable_HistoryRouter as Router, Routes, Route  } from 'react-router-dom';
import history from '../utils/history';

const Login = React.lazy(() => import('../pages/login'));
const EditPassword = React.lazy(() => import('../pages/editPassword'));
const CenterPage = React.lazy(() => import('../pages/home'));

export default function RootRoute() {
  return (
    <Router history={history}>
      <React.Suspense fallback={<div>loading...</div>}>
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/password" element={<EditPassword />} />
          <Route path="/center" element={<CenterPage />} />
          <Route path="/" element={<Login />} />
        </Routes>
      </React.Suspense>
    </Router>
  );
}
