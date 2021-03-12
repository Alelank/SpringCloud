package com.yiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient //开启Eureka客户端功能
@SpringBootApplication
public class YiranCloudProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(YiranCloudProviderApplication.class, args);
    }

}
