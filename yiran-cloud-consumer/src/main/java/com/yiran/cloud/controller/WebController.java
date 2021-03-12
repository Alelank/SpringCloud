package com.yiran.cloud.controller;

import com.yiran.cloud.entity.JavaBook;
import com.yiran.cloud.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 服务消费者
 * Created by Ale on 2021/3/10
 */
@RestController
public class WebController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/web/hello")
    public String hello() {

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://YIRAN-CLOUD-PROVIDER/service/hello", String.class);
        // 获取http响应状态
        HttpStatus statusCode = responseEntity.getStatusCode();

        // 获取响应状态值
        int statusCodeValue = responseEntity.getStatusCodeValue();

        // 获取响应头
        HttpHeaders headers = responseEntity.getHeaders();

        // 获取响应体
        String body = responseEntity.getBody();

        System.out.println(statusCode);
        System.out.println(statusCodeValue);
        System.out.println(headers);
        System.out.println(body);

        return body;
    }

    /**
     * 返回对象实体信息
     * @return
     */
    @RequestMapping("/web/book")
    public JavaBook getBook() {
        ResponseEntity<JavaBook> responseEntity = restTemplate.getForEntity("http://YIRAN-CLOUD-PROVIDER/service/book", JavaBook.class);
        JavaBook body = responseEntity.getBody();
        System.out.println(body);
        return body;
    }


    /**
     * 返回对象实体信息
     * @return
     */
    @RequestMapping("/web/getBook")
    public ResponseData findBook() {
        /**
         * getForEntity 的使用案例
         * 方式一 通过可变参数数组入参
         * 注意: 当入参为可变数组时对应的参数占位为数组索引
         */
        // String[] params = {"1001", "《Java从入门到入土》", "Ale0"};
        //  ResponseEntity<ResponseData> forEntity = restTemplate.getForEntity("http://YIRAN-CLOUD-PROVIDER/service/getBook?id={0}&name={1}&author={2}", ResponseData.class, params);

        /**
         * getForEntity 与 getForObject 的使用案例
         * 方式二 通过Map入参
         * 注意: 当入参为Map时对应参数占位为Map中Key的值
         */
        Map<String,Object> params = new ConcurrentHashMap<>();
        params.put("id",1001);
        params.put("name","《Java从入门到入土》");
        params.put("author","Ale0");
        // getForEntity 的使用
        // ResponseEntity<ResponseData> forEntity = restTemplate.getForEntity("http://YIRAN-CLOUD-PROVIDER/service/getBook?id={id}&name={name}&author={author}", ResponseData.class, params);

        // getForObject 的使用
        ResponseData responseData = restTemplate.getForObject("http://YIRAN-CLOUD-PROVIDER/service/getBook?id={id}&name={name}&author={author}", ResponseData.class, params);
        return responseData;
    }
}
