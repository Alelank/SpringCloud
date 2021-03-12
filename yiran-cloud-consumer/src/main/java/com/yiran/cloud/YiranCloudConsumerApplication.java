package com.yiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class YiranCloudConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YiranCloudConsumerApplication.class, args);
    }

}
