// 图片资源模块声明
declare module '*.svg';
declare module '*.png';
declare module '*.jpg';
declare module '*.jpeg';
declare module '*.gif';
declare module '*.bmp';
declare module '*.webp';

// 样式文件模块声明
declare module '*.css';
declare module '*.less';
declare module '*.scss';
 
// 声明合并，扩展全局变量window的类型
declare global {
  interface Window {
    // 添加的属性或方法
    __DEV__: boolean;
  }
}

// 让其变成一个module，防止ts报错
// https://stackoverflow.com/questions/57132428/augmentations-for-the-global-scope-can-only-be-directly-nested-in-external-modul
export {}
