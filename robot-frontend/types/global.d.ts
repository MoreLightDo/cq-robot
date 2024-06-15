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
