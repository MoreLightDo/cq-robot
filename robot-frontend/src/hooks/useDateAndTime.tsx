import { useState, useEffect } from 'react';
import moment from 'moment';
import { interval, intervalClear } from '../utils/interval';

enum Days {
  星期日,
  星期一,
  星期二,
  星期三,
  星期四,
  星期五,
  星期六,
}
type DayType = keyof typeof Days;
const getDay = (d: string | number): DayType => Days[d];

export const useDateAndTime = () => {
  const [dateAndTime, setDateAndTime] = useState<{
    date: string;
    time: string;
    day: DayType;
  }>({
    date: '',
    time: '',
    day: '星期日',
  });

  useEffect(() => {
    const showTime = () => {
      const t = moment(new Date());
      const date = t.format('YYYY-MM-DD');
      const time = t.format('HH:mm:ss');
      const day = getDay(t.format('e'));
      setDateAndTime({ date, time, day });
    };
    const timer = interval(showTime, 1000);

    return () => {
      intervalClear(timer);
    };
  }, []);

  return dateAndTime;
};
