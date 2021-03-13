package com.yiran.cloud.manage;

import com.yiran.cloud.entity.JavaBook;
import com.yiran.cloud.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * RestTemplate 操作案例
 * Created by Ale on 2021/3/13
 */
@Service
public class JavaBookManage {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * get
     * @return
     */
    public ResponseData doHello() {
        ResponseEntity<ResponseData> responseEntity = restTemplate.getForEntity("http://YIRAN-CLOUD-PROVIDER/service/hello", ResponseData.class);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getStatusCodeValue());
        System.out.println(responseEntity.getHeaders());
        System.out.println(responseEntity.getBody());
        return responseEntity.getBody();
    }

    /**
     * get
     * @return
     */
    public ResponseData doGetBooks() {
        /**
         * 方式一 通过可变参数数组入参
         * getForEntity 的使用案例
         * String[] params = {"1001", "《Java从入门到入土》", "Ale0"};
         * restTemplate.getForEntity("http://YIRAN-CLOUD-PROVIDER/service/getBook?id={0}&name={1}&author={2}", ResponseData.class, params);
         * 注意: 当入参为可变数组时对应的参数占位为数组索引
         */

        /**
         * 方式二 通过Map入参
         * getForEntity 与 getForObject 的使用案例
         * 注意: 当入参为Map时对应参数占位为Map中Key的值
         */
        Map<String, Object> params = new ConcurrentHashMap<>();
        params.put("id", 1001);
        params.put("name", "《Java从入门到入土》");
        params.put("author", "Ale0");
        return restTemplate.getForObject("http://YIRAN-CLOUD-PROVIDER/service/getBook?id={id}&name={name}&author={author}", ResponseData.class, params);
    }

    /**
     * post
     * @return
     */
    public ResponseData doAddBooks() {
        /**
         * 简单测试，不从前端带参数，直接在代码层写死
         * 由于是用Post请求 所以 使用 postForEntity() 与 postForObject()
         * 上述两方法与 get 的请求操作类似 只不过参数需要用 MultiValueMap 来传入
         */
        MultiValueMap<String,Object> map = new LinkedMultiValueMap();
        JavaBook book = new JavaBook.JavaBookBuilder()
                .builderId(1002L)
                .builderName("《Java 从入门到高级》")
                .builderAuthor("Ale")
                .builderContent("序言")
                .builderDesc("look look")
                .builderPublishingHouse("xxx出版社")
                .builderPublishingDate("2021-03-15")
                .builder();
        map.add("books",book);
        return restTemplate.postForEntity("http://YIRAN-CLOUD-PROVIDER/service/addBook", map, ResponseData.class).getBody();
    }

    /**
     * put
     * @return
     */
    public ResponseData doUpdateBook() {
        MultiValueMap<String,Object> map = new LinkedMultiValueMap();
        map.add("id",1001);
        map.add("name","dream");
        restTemplate.put("http://YIRAN-CLOUD-PROVIDER/service/updateBook",map);
        return new ResponseData().success();
    }

    /**
     * delete
     * @return
     */
    public ResponseData doDeleteBook() {
        String[] params = {"1001", "《Java从入门到入土》", "Ale0"};
        restTemplate.delete("http://YIRAN-CLOUD-PROVIDER/service/deleteBook?id={0}&name={1}&author={2}", params);
        return new ResponseData().success();
    }
}
