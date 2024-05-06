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
    greenPoint,
    bluePoint,
    robotRed
} from "../../hooks/mapMod";
import {bezier} from "../../hooks/bezier";
import {Location, Mapping} from "../../utils/domin";

export const BorderBuild = (data) => {
    const borderData = [
        [0, 0],
        [data.width, 0],
        [data.width, data.height],
        [0, data.height],
        [0, 0],
    ];
    const border = new Feature({
        geometry: new LineString(borderData),
        name: "line",
    });
    border.setStyle(
        new Style({
            stroke: new Stroke({
                color: "rgba(15, 125, 255, .3)",
                width: 1,
            }),
        })
    );
    return border;
};

export const PointCloudBUild = (data) => data.map((it) => {
        const feature = new Feature({
            geometry: new MultiPoint(it.points),
            name: "cloud",
        });
        feature.setStyle(
            new Style({
                image: new Circle({
                    radius: 1,
                    fill: new Fill({
                        color: '#1649f6',
                    }),
                }),
            })
        );
        return feature;
    });

export const RobotBuild = (location:Location) => {
    const robot = new Feature({
        geometry: new Point([location.x, location.y]),
        name: "robot",
    });
    robot.setId('0000000000000001');
    robot.setStyle(
        new Style({
            image: new Icon({
                anchor: [8, 8],
                anchorXUnits: "pixels",
                anchorYUnits: "pixels",
                src: robotRed,
                // 角度制
                rotation: [(-location.yaw * Math.PI) / 180],
                // 弧度制度
                // rotation: [-point.yaw],
            }),
        })
    );
    return robot;
}

export const PointBuild = (data) => data.map((point) => {
        let color = bluePoint;
        if (data.color) {
            color = point.color;
        }
        const navPoint = new Feature({
            geometry: new Point([point.x, point.y]),
            name: "point",
        });
        navPoint.setId(point.point_id);
        navPoint.setStyle(
            new Style({
                image: new Icon({
                    anchor: [25, 25],
                    anchorXUnits: "pixels",
                    anchorYUnits: "pixels",
                    src: color,
                    rotation: -(point.yaw * Math.PI) / 180,
                }),
            })
        );
        return navPoint;
    });

export const PathsBuild = (data) => {
    const paths = [];
    const forwards = [];
    const reverses = [];
    data.forEach((path) => {
        const line = [
            {
                x: path.path.begin.x,
                y: path.path.begin.y,
            },
            {
                x: path.path.ctrl0.x,
                y: path.path.ctrl0.y,
            },
            {
                x: path.path.ctrl1.x,
                y: path.path.ctrl1.y,
            },
            {
                x: path.path.end.x,
                y: path.path.end.y,
            },
        ];
        const lineArr = bezier(3, line);
        let forWardArr = [];
        if (path.forward.enable) {
            forWardArr = [lineArr[49], lineArr[50]];
        }
        let reverseArr = [];
        if (path.reverse.enable) {
            reverseArr = [lineArr[51], lineArr[50]];
        }
        const lF = new Feature({
            geometry: new LineString(lineArr),
            name: "path",
        });
        const fF = new Feature({
            geometry: new LineString(forWardArr),
            name: "path",
        });
        const rF = new Feature({
            geometry: new LineString(reverseArr),
            name: "path",
        });
        lF.setId(path.path_id);
        paths.push(lF);
        forwards.push(fF);
        reverses.push(rF);
    });
    return {
        paths,
        forwards,
        reverses,
    };
};

export const AreasBuild = (data) => data.map((area) => {
        const arr = area.points.map((point) => [point.x, point.y]);
        const f = new Feature({
            geometry: new Polygon([arr]),
            name: "area",
        });
        f.setId(area.area_id);
        return f;
    });
