package com.yiran.cloud.controller;

import com.yiran.cloud.entity.JavaBook;
import com.yiran.cloud.response.ResponseData;
import com.yiran.cloud.response.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务提供者
 * Created by Ale on 2021/3/10
 */
@RestController
public class YiRanController {

    /**
     * 返回字符串信息
     *
     * @return
     */
    @RequestMapping("/service/hello")
    public String hello() {
        System.out.println("Provider..");
        return "Hello Spring Cloud Provider";
    }

    /**
     * 返回实体对象信息
     *
     * @return
     */
    @RequestMapping("/service/book")
    public JavaBook getBook() {
        JavaBook javaBook = new JavaBook.JavaBookBuilder()
                .builderId(1001L)
                .builderName("《Java从入门到入土》")
                .builderAuthor("Ale")
                .builderContent("第一章：入土必知")
                .builderDesc("还在为Java忧虑吗，那就来看看《Java从入门到入土》吧！")
                .builderPublishingHouse("xxx出版社")
                .builderPublishingDate("2021-3-10")
                .builder();
        return javaBook;
    }

    /**
     * 获取书籍
     * 消费者端带参数请求
     * @param id     书籍ID
     * @param name   书籍名称
     * @param author 书籍作者
     * @return
     */
    @RequestMapping("/service/getBook")
    public ResponseData<List<JavaBook>> findBooks(@RequestParam("id") long id,
                                  @RequestParam("name") String name,
                                  @RequestParam("author") String author) {

        // 首先对参数进行简单逻辑验证
        ResponseData<List<JavaBook>> responseData = new ResponseData<>();
        if(id < 1L || "".equals(name) || "".equals(author.trim())){
            return responseData.error(ResponseStatus.Error,false,"参数有误");
        }

        // 模拟数据库数据
        List<JavaBook> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            JavaBook javaBook = new JavaBook.JavaBookBuilder()
                    .builderId(1001L + i)
                    .builderName("《Java从入门到入土》")
                    .builderAuthor("Ale" + i)
                    .builderContent("第一章：入土必知")
                    .builderDesc("还在为Java忧虑吗，那就来看看《Java从入门到入土》吧！")
                    .builderPublishingHouse("xxx出版社")
                    .builderPublishingDate("2021-3-10")
                    .builder();
            data.add(javaBook);
        }

        // 对数据进行过滤
        List<JavaBook> javaBooks = new ArrayList<>();
        data.forEach(item -> {
            if(id == item.getId() && item.getName().equals(name) && item.getAuthor().equals(author)){
                javaBooks.add(item);
            }
        });
        if(javaBooks.size() < 1){
            return responseData.error(ResponseStatus.Error,false,"暂无记录");
        }

        return responseData.success(ResponseStatus.SUCCESS,true,"",javaBooks);
    }

}
