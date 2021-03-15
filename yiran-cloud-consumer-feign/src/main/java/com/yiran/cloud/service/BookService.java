package com.yiran.cloud.service;

import com.yiran.cloud.fallback.MyFallback;
import com.yiran.cloud.fallback.MyFallbackFactory;
import com.yiran.cloud.response.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用Feign客户端注解绑定远程服务
 * 服务名称不区分大小写
 * Created by Ale on 2021/3/15
 */
@Service
@FeignClient(name = "yiran-cloud-provider",fallbackFactory = MyFallbackFactory.class)
public interface BookService {

    /**
     * 通过@RequestMapping 来绑定远程服务接口
     * @return
     */
    @RequestMapping("/service/hello")
    ResponseData hello();

}
