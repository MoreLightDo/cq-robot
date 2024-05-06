// 生成贝塞尔曲线插值点 n {number} 控制点数量 arrPoints {array} 控制点坐标集合
export const factorial = (num) => {
    if (num <= 1) {
        return 1;
    }
    return num * factorial(num - 1);

}

export const fooBezier = (n, i, t, d) => {
    const a = factorial(n) / (factorial(i) * factorial(n - i));
    const b = (1 - t)**(n - i);
    const c = t**i;
    const r = a * b * c * d;
    return r;
}

export const bezier = (n, arrPoints) => {
    let Ptx = 0;
    let Pty = 0;
    const arrbline = [];
    for (let t = 0; t <= 1; t += 0.01) {
        Ptx = 0;
        Pty = 0;
        for (let i = 0; i <= n; i++) {
            Ptx += fooBezier(n, i, t, arrPoints[i].x);
            Pty += fooBezier(n, i, t, arrPoints[i].y);
        }
        arrbline.push([Ptx, Pty]);
    }

    arrbline.push([
        arrPoints[arrPoints.length - 1].x,
        arrPoints[arrPoints.length - 1].y,
    ]);
    return arrbline;
}

// 阶乘


// 公式计算

