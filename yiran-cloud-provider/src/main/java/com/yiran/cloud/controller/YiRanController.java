package com.yiran.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ale on 2021/3/10
 */
@RestController
public class YiRanController {


    @RequestMapping("/service/hello")
    public String hello(){
        System.out.println("Provider..");
        return "Hello Spring Cloud Provider";
    }

}
