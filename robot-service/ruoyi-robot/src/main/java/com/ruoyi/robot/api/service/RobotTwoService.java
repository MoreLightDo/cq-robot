package com.ruoyi.robot.api.service;

import com.ruoyi.robot.api.request.TaskInfoRequest;
import com.ruoyi.robot.api.response.TaskInfoResponse;
import retrofit.http.Body;
import retrofit.http.POST;

public interface RobotTwoService {

    @POST("/task_infos")
    TaskInfoResponse getTaskInfo(@Body TaskInfoRequest request);

}
