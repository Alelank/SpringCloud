package com.yiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // 开启Eureka注册中心
@SpringBootApplication
public class YiranCloudEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YiranCloudEurekaServerApplication.class, args);
    }

}
