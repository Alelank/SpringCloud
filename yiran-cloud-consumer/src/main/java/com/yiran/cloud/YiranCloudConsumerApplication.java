package com.yiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

//@EnableHystrix
//@EnableEurekaClient     // 开启注册中心客户端注解
//@EnableCircuitBreaker   // 开启熔断器注解
//@SpringBootApplication  // SpringBoot 启动类注解
@SpringCloudApplication // 开启熔断器注解
public class YiranCloudConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YiranCloudConsumerApplication.class, args);
    }

}
