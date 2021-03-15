package com.yiran.cloud.fallback;

import com.yiran.cloud.response.ResponseData;
import com.yiran.cloud.response.ResponseStatus;
import com.yiran.cloud.service.BookService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Ale on 2021/3/15
 */
@Component
public class MyFallbackFactory implements FallbackFactory<BookService> {
    @Override
    public BookService create(Throwable throwable) {
        System.out.println("服务端异常");
        return () -> new ResponseData().error(ResponseStatus.Error,false,throwable.getMessage());
    }
}
