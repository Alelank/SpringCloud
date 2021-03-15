package com.yiran.cloud.fallback;

import com.yiran.cloud.response.ResponseData;
import com.yiran.cloud.response.ResponseStatus;
import com.yiran.cloud.service.BookService;
import org.springframework.stereotype.Component;

/**
 * 通过@Component来注入bean
 * Created by Ale on 2021/3/15
 */
@Component
public class MyFallback implements BookService {
    @Override
    public ResponseData hello() {
        return new ResponseData().error(ResponseStatus.Error,false,"自定义熔断异常处理");
    }
}
