package com.yiran.cloud.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.yiran.cloud.response.ResponseData;
import com.yiran.cloud.response.ResponseStatus;
import org.springframework.web.client.RestTemplate;

/**
 * 自定义的服务容错处理
 * Created by Ale on 2021/3/14
 */
public class MyHystrixCommand extends HystrixCommand<ResponseData> {

    private RestTemplate restTemplate;
    private String url;

    public MyHystrixCommand(Setter setter, RestTemplate restTemplate, String url) {
        super(setter);
        this.restTemplate = restTemplate;
        this.url = url;
    }

    @Override
    protected ResponseData run() throws Exception {
        return restTemplate.getForEntity(url,ResponseData.class).getBody();
    }

    @Override
    protected ResponseData getFallback() {
        return new ResponseData().error(ResponseStatus.Error,false,"服务异常..");
    }
}
