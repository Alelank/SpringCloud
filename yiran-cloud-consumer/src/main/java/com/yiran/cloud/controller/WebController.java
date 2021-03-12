package com.yiran.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Ale on 2021/3/10
 */
@RestController
public class WebController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/web/hello")
    public String hello() {
        return restTemplate.getForEntity("http://YIRAN-CLOUD-PROVIDER/service/hello", String.class).getBody();
    }
}
