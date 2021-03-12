package com.yiran.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Bean配置类
 * Created by Ale on 2021/3/10
 */
@Configuration
public class BeanConfig {


    /**
     * @Bean 等价于Spring xml中<bean id="restTemplate" class="xxx.xxx.xx.RestTemplate"></bean>
     * @LoadBalanced 使用Ribbon 实现了客户端负载均衡调用
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
