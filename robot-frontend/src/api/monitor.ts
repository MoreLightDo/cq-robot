// 视频监控列表
export function getVideoList(params) {
  // mock
  return Promise.resolve({
    "monitorList": [
      {
        "name": "实时监控",
        "videoUrl": "xx"
      },
      {
        "name": "热成型监控",
        "videoUrl": "xx1"
      },
      {
        "name": "xx监控",
        "videoUrl": "xx2"
      }
    ]
  });
}

// 实时抓拍列表
export function getSnapshotList(params) {
  // mock
  return Promise.resolve({
    "monitorList": [
      {
        "name": "实时监控",
        "videoUrl": "qqqqqq",
        "time": "2024/03/20 15:20:09",
        "tip": "未戴安全帽"
      },
    ]
  });
}

// 获取安全趋势数据
export function getSafeData(params) {
  // mock
  return Promise.resolve({
    todayScore: 99.9,
    todayEquipped: 100,
    todayFanguang: 92.6,
  });
}

// 近n天安全数据
export function getRecentData(n) {
  // safeItem为安全项，有安全帽和反光背心两项
  // mock背心数据
  const beixinData = [
    { date: '1', safeItem: '背心', score: 4.3 },
    { date: '2', safeItem: '背心', score: 4.9 },
    { date: '3', safeItem: '背心', score: 7.9 },
    { date: '4', safeItem: '背心', score: 5.2 },
    { date: '5', safeItem: '背心', score: 6.5 },
    { date: '6', safeItem: '背心', score: 7.7 },
    { date: '7', safeItem: '背心', score: 15.5 },
    { date: '8', safeItem: '背心', score: 9.5 },
    { date: '9', safeItem: '背心', score: 8.4 },
    { date: '10', safeItem: '背心', score: 14.9 },
    { date: '11', safeItem: '背心', score: 20.5 },
    { date: '12', safeItem: '背心', score: 14.2 },
    { date: '13', safeItem: '背心', score: 24.2 },
    { date: '14', safeItem: '背心', score: 15 },
    { date: '15', safeItem: '背心', score: 24.5 },
    { date: '16', safeItem: '背心', score: 14.6 },
    { date: '17', safeItem: '背心', score: 25.3 },
    { date: '18', safeItem: '背心', score: 13.2 },
    { date: '19', safeItem: '背心', score: 12.3 },
    { date: '20', safeItem: '背心', score: 13.3 },
    { date: '21', safeItem: '背心', score: 15.9 },
    { date: '22', safeItem: '背心', score: 7.6 },
    { date: '23', safeItem: '背心', score: 7.6 },
    { date: '24', safeItem: '背心', score: 8.8 },
    { date: '25', safeItem: '背心', score: 5.6 },
    { date: '26', safeItem: '背心', score: 10.6 },
    { date: '27', safeItem: '背心', score: 16.6 },
    { date: '28', safeItem: '背心', score: 16.6 },
    { date: '29', safeItem: '背心', score: 19.6 },
    { date: '30', safeItem: '背心', score: 14.8 },
  ];
  // mock安全帽数据
  const anquanmaoData = [
    { date: '1', safeItem: '安全帽', score: 3.3 },
    { date: '2', safeItem: '安全帽', score: 3.9 },
    { date: '3', safeItem: '安全帽', score: 6.9 },
    { date: '4', safeItem: '安全帽', score: 4.2 },
    { date: '5', safeItem: '安全帽', score: 9.5 },
    { date: '6', safeItem: '安全帽', score: 5.7 },
    { date: '7', safeItem: '安全帽', score: 14.5 },
    { date: '8', safeItem: '安全帽', score: 8.5 },
    { date: '9', safeItem: '安全帽', score: 18.4 },
    { date: '10', safeItem: '安全帽', score: 11.9 },
    { date: '11', safeItem: '安全帽', score: 21.5 },
    { date: '12', safeItem: '安全帽', score: 15.2 },
    { date: '13', safeItem: '安全帽', score: 25.2 },
    { date: '14', safeItem: '安全帽', score: 17 },
    { date: '15', safeItem: '安全帽', score: 26.5 },
    { date: '16', safeItem: '安全帽', score: 16.6 },
    { date: '17', safeItem: '安全帽', score: 23.3 },
    { date: '18', safeItem: '安全帽', score: 14.2 },
    { date: '19', safeItem: '安全帽', score: 18.3 },
    { date: '20', safeItem: '安全帽', score: 10.3 },
    { date: '21', safeItem: '安全帽', score: 13.9 },
    { date: '22', safeItem: '安全帽', score: 6.6 },
    { date: '23', safeItem: '安全帽', score: 9.6 },
    { date: '24', safeItem: '安全帽', score: 4.8 },
    { date: '25', safeItem: '安全帽', score: 6.6 },
    { date: '26', safeItem: '安全帽', score: 9.6 },
    { date: '27', safeItem: '安全帽', score: 6.6 },
    { date: '28', safeItem: '安全帽', score: 6.6 },
    { date: '29', safeItem: '安全帽', score: 9.6 },
    { date: '30', safeItem: '安全帽', score: 4.8 },
  ];
  return Promise.resolve([...beixinData, ...anquanmaoData]);
}

// 告警事故统计
export function getWarningEventData() {
  return Promise.resolve({
    // 未戴安全帽
    anquanmao: {
      today: 150,
      trend: 'up',
      average: 60,
    },
    // 未穿工作服
    gongzuofu: {
      today: 150,
      trend: 'up',
      average: 60,
    },
    // 疑似明火
    lightFire: {
      today: 150,
      trend: 'down',
      average: 60,
    },
    // 设备故障
    equipmentFailure: {
      today: 150,
      trend: 'down',
      average: 60,
    },
  }).then((res) => {
    const getText = (k) => {
      switch (k) {
        case 'anquanmao': return '未戴安全帽';
        case 'gongzuofu': return '未穿工作服';
        case 'lightFire': return '疑似明火';
        case 'equipmentFailure': return '设备故障';
        default: return k;
      }
    };
    const data = Object.keys(res).map((k) => ({
      eventName: getText(k),
      todayTimes: res[k].today,
      average: res[k].average,
      trend: res[k].trend,
    }));
    return data;
  });
}
