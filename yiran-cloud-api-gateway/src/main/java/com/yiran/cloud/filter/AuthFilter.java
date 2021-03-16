package com.yiran.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ale on 2021/3/15
 */
@Component
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 运行顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 代表是否开启过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        System.out.println("123");
        // 测试 error 模式
        int n = 10 / 0;
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        if(token == null || "".equals(token)){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            currentContext.addZuulResponseHeader("content-type","text/html;charset=utf-8");
            currentContext.setResponseBody("非法访问");
        }
        return null;
    }
}
