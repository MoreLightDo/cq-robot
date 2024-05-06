package com.ruoyi.robot.api.config;

import com.ruoyi.robot.api.service.RobotService;
import com.ruoyi.robot.api.service.RobotTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit.RestAdapter;

@Configuration
public class APIsConfig {

    @Bean
    public RobotService getRobotAPI(){
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://192.168.1.124:10101")
                .build();
        return adapter.create(RobotService.class);
    }

    @Bean
    public RobotTwoService getTwoService() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://192.168.1.21:10001")
                .build();
        return adapter.create(RobotTwoService.class);
    }
}
