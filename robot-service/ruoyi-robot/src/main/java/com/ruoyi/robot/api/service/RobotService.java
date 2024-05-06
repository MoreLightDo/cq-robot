package com.ruoyi.robot.api.service;



import com.ruoyi.robot.api.request.PtzRequest;
import com.ruoyi.robot.api.request.TaskDoRequest;
import com.ruoyi.robot.api.response.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;


import java.util.List;
import java.util.Map;

public interface RobotService {

    @GET("/agv_info")
    AGVInfoResponse getAGVInfo();

    @GET("/depth_camera")
    Float[][] getDepthCamera();

    @GET("/sensor_info")
    SensorInfo getSensorInfo();

    @GET("/arm_info")
    ArmInfo getArmInfo();

    @GET("/ptz_info")
    PtzInfo getPtzInfo();

    @POST("/ptz_pose_ctrl")
    PtzResponse ptzCtl(@Body PtzRequest request);

    @GET("/task_mould_list")
    List<TaskInfo> getTaskInfo();

    @POST("/task_do")
    PtzResponse doTask(@Body TaskDoRequest request);

    @GET("/task_log")
    List<TaskLog> getTaskLog();

    @GET("/map_list")
    List<MapListItem> getMapList();

    /**
     *
     * @param params map_id
     * @return
     */
    @POST("/map_info")
    MapInfoResponse getMapInfo(@Body Map<String, Object> params);

    @GET("/last_task_info")
    LastTaskResponse getLastTask();

}
