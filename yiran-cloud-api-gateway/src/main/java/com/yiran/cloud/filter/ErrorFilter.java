package com.yiran.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ale on 2021/3/16
 */
//@Component
public class ErrorFilter extends ZuulFilter {
    private final Logger logger = LoggerFactory.getLogger(ErrorFilter.class);

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        ZuulException exception = (ZuulException) context.getThrowable();
        logger.error("进入异常", exception);
        HttpServletResponse response = context.getResponse();
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(exception.nStatusCode);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.println("{code:" + exception.nStatusCode + ",massage:\"" + exception.getMessage() + "\"}");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
        return null;
    }
}
