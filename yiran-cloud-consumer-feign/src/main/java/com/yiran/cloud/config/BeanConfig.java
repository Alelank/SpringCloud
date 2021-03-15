package com.yiran.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ale on 2021/3/15
 */
@Configuration
public class    BeanConfig {

    // @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
