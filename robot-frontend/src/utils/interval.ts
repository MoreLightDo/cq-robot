// 公共interval方法，使用settimeout代替setInterval
const TimerMap = new Map<number, NodeJS.Timeout>();

export const interval = (fn: () => void, time: number) => {
  const id = Math.random();
  const intervalTodo = () => {
    const timeoutId = setTimeout(() => {
      fn();
      intervalTodo();
    }, time);
    TimerMap.set(id, timeoutId);
  };
  intervalTodo();
  return id;
};

export const intervalClear = (t: number) => {
  clearTimeout(TimerMap.get(t));
  TimerMap.delete(t);
};
