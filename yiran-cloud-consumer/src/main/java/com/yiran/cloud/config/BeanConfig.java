package com.yiran.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
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

    /**
     * 覆盖掉默认的轮询负载均衡策略
     * @return
     */
    @Bean
    public IRule iRule(){
        // 采用随机的负载均衡策略
        // return new RandomRule();

        // 先按照 RoundRobinRule(轮询) 策略分发，如果分发到的服务不能访问，则在指定时间内进行重试，分发其它可用服务。
        return new RetryRule();
    }

}
