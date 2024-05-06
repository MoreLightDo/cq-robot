import React, {useCallback, useEffect, useRef, useState} from "react";

import {XYZ} from "ol/source";
import {Tile as TileLayer} from 'ol/layer'
import {
    olMap,
    View,
    ImageLayer,
    Static,
    VectorSource,
    VectorLayer,
    Point,
    Polygon,
    LineString,
    MultiLineString,
    MultiPoint,
    Projection,
    Style,
    Icon,
    Stroke,
    Fill,
    Circle,
    Feature,
    Select,
    Translate,
    Draw,
    arrowRedStyle,
    arrowGreenStyle,
    renderStyle,
    linePointStyle,
} from "../../hooks/mapMod";
import {getMapInfo} from "../../api/robot";

import {
    BorderBuild,
    PointCloudBUild,
    RobotBuild,
    PointBuild,
    PathsBuild,
    AreasBuild
} from "./render";
import {Map} from "../../utils/domin";
import './index.less';
import {useAppSelector} from "../../redux/store";
import {interval, intervalClear} from "../../utils/interval";


export default function MapCase() {

    const map = useRef({});
    const target = useRef({});
    const [data, setData] = useState<Map>(null)

    const [hwInfo, setHWinfo] = useState({
        height: 100,
        width: 100
    })

    const [currentMapId, setCurrentMapId] = useState('b723fe854bebcbbb')

    const robotInfo = useAppSelector((state) => state.robot.robotInfo)

    const [mapObj, setMapObj] = useState({
        layer: {
            // 边线层
            border: new VectorLayer({
                source: new VectorSource({}),
            }),

            // 点云层
            pointClouds: new VectorLayer({
                source: new VectorSource({}),
            }),
            // 区域层
            polygonLayer: new VectorLayer({
                source: new VectorSource({}),
                style: renderStyle,
            }),
            // 线段层
            lineLayer: new VectorLayer({
                source: new VectorSource({}),
                style: renderStyle,
            }),
            // 正向箭头
            forwardLayer: new VectorLayer({
                source: new VectorSource({}),
                style: arrowRedStyle,
            }),
            // 反向箭头
            reverseLayer: new VectorLayer({
                source: new VectorSource({}),
                style: arrowGreenStyle,
            }),
            // 点层
            pointLayer: new VectorLayer({
                source: new VectorSource({}),
                style: renderStyle,
            }),
            // 机器人图层
            robotLayer: new VectorLayer({
                source: new VectorSource({}),
            }),
        }
    });


    const initMap = () => {
        const {height, width} = hwInfo
        const extent = [0, 0, width, height];

            const layerArr = [];
            for (const key in mapObj.layer) {
                layerArr.push(mapObj.layer[key]);
            }
            map.current = new olMap({
                layers: [
                    ...layerArr
                ],
                target: target.current,
                view: new View({
                    projection: new Projection({
                        code: "xkcd-image",
                        units: "pixels",
                        extent,
                    }),
                    center: [width / 2, height / 2],
                    // center: [0,0],
                    zoom: 2,
                }),
                controls: [],
            });

    }

    const renderGraph = () => {
        for (let key in mapObj.layer) {
            mapObj.layer[key].getSource().clear();
        }

        const border = BorderBuild(data);
        mapObj.layer.border.getSource().addFeature(border);

        const pointClouds = PointCloudBUild(data.point_clouds);
        mapObj.layer.pointClouds.getSource().addFeatures(pointClouds);

        const robots = RobotBuild(robotInfo.location);
        mapObj.layer.robotLayer.getSource().addFeatures([robots]);

        const navPoints = PointBuild(data.points);
        mapObj.layer.pointLayer.getSource().addFeatures(navPoints);

        const paths = PathsBuild(data.paths);
        mapObj.layer.lineLayer.getSource().addFeatures(paths.paths);
        mapObj.layer.forwardLayer.getSource().addFeatures(paths.forwards);
        mapObj.layer.reverseLayer.getSource().addFeatures(paths.reverses);

        const areas = AreasBuild(data.areas);
        mapObj.layer.polygonLayer.getSource().addFeatures(areas);

        return data;
    }

    const getData = () => {
        getMapInfo(currentMapId).then(res => {
            setData(res.data.data)
        })
    }

    useEffect(() => {
        getData()
        const timer = interval(getData, 2000)
        return () => {
            intervalClear(timer)
        }
    }, [target])

    useEffect(() => {
        if (data != null) {
            if (data.height != hwInfo.height) {
                setHWinfo({
                    height: data.height,
                    width: data.width
                })
            }
        }
    }, [data])

    useEffect(() => {
        if (data != null && robotInfo != null) {
            renderGraph()
        }
    }, [data, robotInfo])

    useEffect(() => {
        if (robotInfo != null) {
            if (robotInfo.mapping.map_id != currentMapId) {
                setCurrentMapId(robotInfo.mapping.map_id)
            }
        }
    }, [robotInfo])

    useEffect(() => {
        if (hwInfo.height != 100) {
            initMap()
        }
    }, [hwInfo])

    return (
        <div id="mapCase" className="mapCase">
            <div className="mapCase" ref={target}/>
        </div>
    )
}
