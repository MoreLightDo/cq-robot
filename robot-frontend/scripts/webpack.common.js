/* eslint-disable import/no-extraneous-dependencies */
/* eslint-disable @typescript-eslint/no-var-requires */
const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');

const isDev = process.env.NODE_ENV !== 'production';

module.exports = {
  resolve: {
    extensions: ['.js', '.jsx', '.ts', '.tsx'],
  },
  entry: {
    app: path.resolve(__dirname, '../src/index.tsx'),
  },
  output: {
    filename: `[name]${isDev ? '' : '.[hash:8]'}.js`,
    path: path.resolve(__dirname, '../dist'),
  },
  module: {
    rules: [
      {
        test: /\.m?js$/,
        resolve: {
          fullySpecified: false, // https://webpack.docschina.org/configuration/module/#resolve-fully-specified
        },
      },
      {
        test: /.(jsx?|tsx?)$/,
        use: 'babel-loader',
      },
      {
        test: /.css$/,
        use: [isDev ? 'style-loader' : MiniCssExtractPlugin.loader, 'css-loader'],
      },
      {
        test: /.less$/,
        use: [
          isDev ? 'style-loader' : MiniCssExtractPlugin.loader,
          {
            loader: 'css-loader',
            // css模块化与antd按需加载冲突，待处理
            // options: {
            //   modules: {
            //     localIdentName: '[path][name]__[local]--[hash:base64:5]',
            //   },
            // },
          },
          {
            loader: 'less-loader',
            options: {
              lessOptions: { javascriptEnabled: true },
            },
          },
        ],
      },
      {
        test: /.(png|jpg|jpeg|svg|gif|bmp|webp)$/,
        use: [
          {
            loader: 'url-loader',
            options: {
              limit: 10240,
            },
          },
        ],
      },
    ],
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: path.resolve(__dirname, '../public/index.html'),
      filename: 'index.html',
      title: 'cq-robot-web',
      // minify参考给出的Minification例子 https://www.npmjs.com/package/html-webpack-plugin
      minify: isDev
        ? false
        : {
            collapseWhitespace: true,
            keepClosingSlash: true,
            removeComments: true,
            removeRedundantAttributes: true,
            removeScriptTypeAttributes: true,
            removeStyleLinkTypeAttributes: true,
            useShortDoctype: true,
          },
    }),
  ],
  optimization: {
    splitChunks: {
      cacheGroups: {
        react: {
          test: /[\\/]node_modules[\\/](react|react-dom)[\\/]/,
          name: 'react',
          chunks: 'initial',
          filename: '[name].chunk.[id].js',
          priority: 100,
        },
        antd: {
          test: /[\\/]node_modules[\\/](antd|@ant-design)[\\/]/,
          name: 'antd',
          chunks: 'all',
          filename: '[name].chunk.[id].js',
          priority: 90,
        },
        antv: {
          test: /[\\/]node_modules[\\/]@antv[\\/]/,
          name: 'antv',
          chunks: 'all',
          filename: '[name].chunk.[id].js',
          priority: 80,
        },
        vendors: {
          test: /[\\/]node_modules[\\/]/,
          name: 'vendors',
          chunks: 'all',
          filename: '[name].chunk.[id].js',
          priority: 10,
        },
      },
    },
  },
};
