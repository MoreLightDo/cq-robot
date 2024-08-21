/* eslint-disable import/no-extraneous-dependencies */
/* eslint-disable @typescript-eslint/no-var-requires */
const path = require('path');
const { merge } = require('webpack-merge');
const common = require('./webpack.common');

module.exports = merge(common, {
  mode: 'development',
  devtool: 'eval-source-map',
  devServer: {
    client: {
      overlay: false,
    },
    port: 9000, // 指定端口，默认是8080
    open: true, // 打开默认浏览器
    hot: true, // 热更新
    headers: { 'Access-Control-Allow-Origin': '*' },
    static: {
      // directory即webpack4中的contentBase
      directory: path.resolve(__dirname, '../dist'),
      publicPath: '/dist',
    },
    proxy: {
      // '/': {
      //   target: 'http://47.120.19.177:8080/',  // 任航
      //   changeOrigin: true,
      // },
      '/cqrobot': {
        target: 'http://81.70.48.42:7810/',        // 二期联调
        changeOrigin: true,
        pathRewrite: { '^/cqrobot': '' },
      },
    },
  },
});
