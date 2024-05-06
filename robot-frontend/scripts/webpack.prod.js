/* eslint-disable import/no-extraneous-dependencies */
/* eslint-disable @typescript-eslint/no-var-requires */
const { merge } = require('webpack-merge');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
const path = require("path");
const common = require('./webpack.common');

module.exports = merge(common, {
  mode: 'production',
  plugins: [
    new MiniCssExtractPlugin({
      filename: '[name].[contenthash:8].css',
      chunkFilename: '[name].[id].css',
    }),
    new CleanWebpackPlugin(),
  ],
  devServer: {
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
      '/dutang': {
        target: 'https://localhost:8080',
        changeOrigin: true,
        pathRewrite: {
          ['^' + process.env.VUE_APP_BASE_API]: ''
        }
      },
    },
  }
});
