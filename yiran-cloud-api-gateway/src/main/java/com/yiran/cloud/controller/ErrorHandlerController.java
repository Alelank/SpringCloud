package com.yiran.cloud.controller;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ale on 2021/3/16
 */
@RestController
public class ErrorHandlerController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }


    @RequestMapping("/error")
    public String SysError(){
        RequestContext context = RequestContext.getCurrentContext();
        ZuulException zuulException = (ZuulException)context.getThrowable();
        return zuulException.nStatusCode + "---" + zuulException.getMessage();
    }
}
