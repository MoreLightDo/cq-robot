import {createSlice, Draft, PayloadAction} from "@reduxjs/toolkit";
import {AlarmLog, PtzInfo, RobotObject, Sensors, User} from "../../utils/domin";
import {RootState} from "../store";

interface RobotState {
    robotInfo: RobotObject
    sensors: Sensors
    ptz:PtzInfo
    selectd:boolean
}

const initialState: RobotState = {
    robotInfo: null,
    sensors: null,
    ptz:null,
    selectd:false
}

export const robotSlice = createSlice({
    name: 'Robot',
    initialState,
    reducers: {
        updateRobotInfo: (state: Draft<RobotState>, action: PayloadAction<RobotObject>) => {
            state.robotInfo = action.payload
        },
        updateSensors: (state: Draft<RobotState>, action: PayloadAction<Sensors>)=>{
            state.sensors = action.payload
        },
        updateAlertLog : (state: Draft<RobotState>, action: PayloadAction<boolean>)=>{
            state.selectd = action.payload
        }
    }
})

export const {updateRobotInfo,updateSensors,updateAlertLog} = robotSlice.actions

export const robotInfo = (state: RootState) => state.robot.robotInfo

export const sensors = (state: RootState) => state.robot.sensors

export const ptz = (state: RootState) => state.robot.ptz

export default robotSlice.reducer
