package com.yiran.cloud.controller;

import com.yiran.cloud.entity.JavaBook;
import com.yiran.cloud.manage.JavaBookManage;
import com.yiran.cloud.response.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 服务提供者
 * Created by Ale on 2021/3/10
 */
@RestController
public class YiRanController {

    @Resource
    private JavaBookManage javaBookManage;

    /**
     * 返回字符串信息
     *
     * @return
     */
    @RequestMapping("/service/hello")
    public ResponseData hello() {
        return javaBookManage.doHello();
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
    public ResponseData<List<JavaBook>> getBooks(@RequestParam("id") long id,
                                  @RequestParam("name") String name,
                                  @RequestParam("author") String author) {
        return javaBookManage.doGetBooks(id,name,author);
    }

    /**
     * 添加用户
     * @param data
     * @return
     */
    @RequestMapping(value = "/service/addBook", method = RequestMethod.POST)
    public ResponseData addBook(@RequestParam Map<String,Object> data){
        return javaBookManage.doAddBooks(data);
    }

    /**
     * 更新用户
     * @param data
     * @return
     */
    @RequestMapping(value = "/service/updateBook", method = RequestMethod.PUT)
    public ResponseData updateBook(@RequestParam Map<String,Object> data){
        return javaBookManage.doUpdateBooks(data);
    }

    @RequestMapping(value = "service/deleteBook", method = RequestMethod.DELETE)
    public ResponseData deleteBooks(@RequestParam("id") long id,
                                    @RequestParam("name") String name,
                                    @RequestParam("author") String author){
        return javaBookManage.doDeleteBooks(id,name,author);
    }

}
