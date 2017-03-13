package com.fernandocchaves.ca.configurations;

import com.fernandocchaves.ca.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobotServiceConfig {

    @Bean
    public RobotService robotService() {
        return new RobotService(leftRotateService(), rightRotateService(), walkXService(), walkYService());
    }

    @Bean
    public LeftRotateService leftRotateService() {
        return new LeftRotateService();
    }

    @Bean
    public RightRotateService rightRotateService() {
        return new RightRotateService();
    }

    @Bean
    public WalkXService walkXService() {
        return new WalkXService();
    }

    @Bean
    public WalkYService walkYService() {
        return new WalkYService();
    }
}
