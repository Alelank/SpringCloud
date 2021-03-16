package com.yiran.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by Ale on 2021/3/16
 */
@EnableConfigServer
@SpringBootApplication
public class ApplicationConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfigServer.class, args);
    }
}
