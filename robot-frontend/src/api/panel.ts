// 仪表识别页面相关接口
export function getInstrumentState() {
  // mock
  return Promise.resolve({
    currentState: '85%',
    location: 'A区',
    instrumentNo: 'A456561',
    reading: '005',
    time: '2024/10/20 50:20',
  });
}

//
export function getRealTimeInfo() {
  // mock
  return Promise.resolve([
    {
      indexNo: '01',
      operationalStatus: '正常',
      abnormal: '电量不足',
      refRange: '10-100',
    },
    {
      indexNo: '02',
      operationalStatus: '正常',
      abnormal: '电量不足',
      refRange: '10-100',
    },
    {
      indexNo: '03',
      operationalStatus: '正常',
      abnormal: '电量不足',
      refRange: '10-100',
    },
    {
      indexNo: '04',
      operationalStatus: '正常',
      abnormal: '电量不足',
      refRange: '10-100',
    },
    {
      indexNo: '05',
      operationalStatus: '正常',
      abnormal: '电量不足',
      refRange: '10-100',
    },
    {
      indexNo: '06',
      operationalStatus: '正常',
      abnormal: '电量不足',
      refRange: '10-100',
    },
  ]);
}
