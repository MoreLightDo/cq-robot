// @babel/preset-env的使用entry方式，在入口文件引入corejs和regenerator
import 'core-js/stable';
import 'regenerator-runtime/runtime';

import React, {useEffect, useState} from 'react';
import {Provider} from "react-redux";
import ReactDOM from 'react-dom';
import RootRoute from './routes';


import './styles/common.css';

import store from "./redux/store";


const App = () => (
        <Provider store={store}>
            <React.StrictMode>

                <RootRoute/>

            </React.StrictMode>
        </Provider>
    );

ReactDOM.render(<App/>, document.querySelector('#root'));
