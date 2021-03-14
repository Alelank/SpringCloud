package com.yiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard  // 开启Hystrix 仪表盘功能
@SpringBootApplication
public class YiranCloudHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(YiranCloudHystrixDashboardApplication.class, args);
    }

}
