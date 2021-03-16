package com.yiran.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ale on 2021/3/15
 */
@RestController
public class GatewayController {

    @RequestMapping("/api/local")
    public String gateway(){

        return "hello Api";
    }
}
