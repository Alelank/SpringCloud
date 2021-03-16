package com.yiran.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ale on 2021/3/16
 */
@RestController
public class ConfigClientController {

    @Value("${action}")
    private String action;

    @Autowired
    private Environment environment;

    @RequestMapping("/cloud/url")
    public String url(){
        System.out.println(environment.getProperty("action"));
        return action;
    }
}
