import {createSlice, Draft, PayloadAction} from "@reduxjs/toolkit";
import {User} from "../../utils/domin";
import {RootState} from "../store";

interface UserState{
    userInfo:User
}

const initialState: UserState = {
    userInfo:null
}

export const userSlice = createSlice({
    name:'User',
    initialState,
    reducers:{
        updateUser:(state:Draft<UserState>, action:PayloadAction<User>)=>{
            state.userInfo = action.payload
        }
    }
})

export const {updateUser} = userSlice.actions

export const userInfo = (state:RootState)=>state.user.userInfo


export default userSlice.reducer
