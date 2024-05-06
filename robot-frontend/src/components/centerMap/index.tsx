import React, {useEffect, useState} from "react";
import {Map, PointCloud} from "../../utils/domin";
import {getAgvInfo, getMapInfo} from "../../api/robot";

import './index.less';
import MapCase from "./MapCase";

export default function CenterMap(){

    return(
        <div className="drawPine">
            <MapCase/>
        </div>
    )
}
