module.exports = {
  env: {
    browser: true,
    es2021: true,
    node: true,
  },
  extends: [
    'airbnb',
    'airbnb/hooks',
    // react相关eslint配置请参考
    // https://github.com/jsx-eslint/eslint-plugin-react#configuration
    'plugin:react/recommended',
    'plugin:react/jsx-runtime',
    // typescript相关eslint配置请参考
    // https://github.com/typescript-eslint/typescript-eslint/tree/main/packages/eslint-plugin#usage
    'plugin:@typescript-eslint/recommended',
    // 处理prettier和eslint的冲突
    'prettier',
  ],
  parser: '@typescript-eslint/parser',
  parserOptions: {
    ecmaFeatures: {
      jsx: true,
    },
    ecmaVersion: 'latest',
    sourceType: 'module',
  },
  plugins: ['react', '@typescript-eslint'],
  rules: {
    // https://github.com/jsx-eslint/eslint-plugin-react#jsx-specific-rules
    // 防止 import react from 'xxx' 中react标红报错
    'react/jsx-uses-react': 'error',
    // https://github.com/jsx-eslint/eslint-plugin-react/blob/master/docs/rules/jsx-filename-extension.md#extensions-default-jsx
    // 默认支持jsx语法的只有jsx文件，这里设置为tsx，jsx，js，ts都可以
    'react/jsx-filename-extension': [1, { extensions: ['.js', '.jsx', '.ts', '.tsx'] }],
    // 加上'import/extensions'，否则import文件时不加扩展名会报错 missing ext
    'import/extensions': [
      'error',
      'ignorePackages',
      {
        ts: 'never',
        tsx: 'never',
        js: 'never',
        jsx: 'never',
      },
    ],
    // 不采用以下规范
    'jsx-a11y/click-events-have-key-events': 0,
    'jsx-a11y/no-static-element-interactions': 0,
    'import/prefer-default-export': 0,
    '@typescript-eslint/no-unnecessary-type-constraint': 0,
    'react/require-default-props': 0,
    '@typescript-eslint/no-explicit-any': 0,
    'react/function-component-definition': 0,
    'react/jsx-props-no-spreading': 0,
    'react/destructuring-assignment': 0,
    'no-console': 0,
    'no-plusplus': 0,
    'no-shadow': 'off',
    '@typescript-eslint/no-shadow': ['error'],
    'react/no-array-index-key': 0,
  },
  // https://eslint.bootcss.com/docs/user-guide/configuring#adding-shared-settings
  settings: {
    // 配合'import/extensions'使用，防止import不加扩展名时报错 cannot resolve module xxx
    'import/resolver': {
      node: {
        extensions: ['.tsx', '.ts', '.js', '.jsx', '.json'],
      },
    },
  },
};
