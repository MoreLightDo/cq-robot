import olMap from "ol/Map"; // 地图
import View from "ol/View"; // 视图
import ImageLayer from "ol/layer/Image"; // 图片图层
import Static from "ol/source/ImageStatic"; // 静态图片
import VectorSource from "ol/source/Vector"; // 矢量源
import VectorLayer from "ol/layer/Vector"; // 矢量图层
import {
    Point,
    Polygon,
    LineString,
    MultiLineString,
    MultiPoint,
} from "ol/geom"; // 点,多边形,线,多线,多点
import Projection from "ol/proj/Projection"; // 投影
import { Style, Icon, Stroke, Fill, Circle } from "ol/style"; // 样式
import Feature from "ol/Feature"; // 特性
import {
    Select,
    Translate,
    Draw,
    defaults as defaultInteractions,
} from "ol/interaction"; // 交互
import "ol/ol.css";
// openlayers

import arrowGreen from '../assets/map/arrowGreen.png'
import arrowRed from '../assets/map/arrowRed.png'
import greenPoint from '../assets/map/green_point.png'
import bluePoint from '../assets/map/blue_point.png'
import robotRed from '../assets/map/robot_red.png'


// 箭头样式
const arrowRedStyle = function (feature) {
    const geometry = feature.getGeometry();
    const styles = [];
    geometry.forEachSegment((start, end) => {
        const dx = end[0] - start[0];
        const dy = end[1] - start[1];
        const rotation = Math.atan2(dy, dx);
        // arrows
        styles.push(
            new Style({
                geometry: new Point(end),
                image: new Icon({
                    src: arrowRed,
                    anchor: [11, -3],
                    anchorXUnits: "pixels",
                    anchorYUnits: "pixels",
                    rotateWithView: true,
                    rotation: -rotation,
                }),
            })
        );
    });
    return styles;
};
// 箭头样式
const arrowGreenStyle = function (feature) {
    const geometry = feature.getGeometry();
    const styles = [];
    geometry.forEachSegment((start, end) => {
        const dx = end[0] - start[0];
        const dy = end[1] - start[1];
        const rotation = Math.atan2(dy, dx);
        // arrows
        styles.push(
            new Style({
                geometry: new Point(end),
                image: new Icon({
                    src: arrowGreen,
                    anchor: [11, -3],
                    anchorXUnits: "pixels",
                    anchorYUnits: "pixels",
                    rotateWithView: true,
                    rotation: -rotation,
                }),
            })
        );
    });
    return styles;
};

// 渲染样式
const renderStyle = new Style({
    fill: new Fill({
        color: "rgba(150, 155, 255, 0.6)",
    }),
    stroke: new Stroke({
        color: "rgba(245, 155, 5, .5)",
        width: 4,
    }),
    image: new Circle({
        radius: 4,
        fill: new Fill({
            color: "rgba(212, 55, 25, 1)",
        }),
    }),
});

// 控制点样式
const linePointStyle = new Style({
    image: new Circle({
        radius: 5,
        fill: new Fill({ color: "rgba(255, 155, 25, 1)" }),
    }),
});

export {
    olMap, View, ImageLayer, Static, VectorSource, VectorLayer, Point,Polygon, LineString, MultiLineString, MultiPoint, Projection, Style, Icon, Stroke, Fill, Circle, Feature, Select,
    Translate,
    Draw,
    arrowRedStyle,
    arrowGreenStyle,
    renderStyle,
    linePointStyle,
    greenPoint,
    bluePoint,
    robotRed
}
