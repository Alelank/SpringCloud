package com.yiran.cloud.controller;

import com.yiran.cloud.manage.JavaBookManage;
import com.yiran.cloud.response.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 服务消费者
 * Created by Ale on 2021/3/10
 */
@RestController
public class WebController {

    @Resource
    private JavaBookManage javaBookManage;

    /**
     * get
     * hello
     * @return
     */
    @RequestMapping("/web/hello")
    public ResponseData Hello() {
        return javaBookManage.doHello();
    }

    /**
     * get
     * 返回对象实体信息
     * @return
     */
    @RequestMapping("/web/getBook")
    public ResponseData getBook() {
        return javaBookManage.doGetBooks();
    }

    /**
     * post
     * @return
     */
    @RequestMapping("/web/addBook")
    public ResponseData addBook() {
        return javaBookManage.doAddBooks();
    }

    /**
     * put
     * @return
     */
    @RequestMapping("/web/updateBook")
    public ResponseData updateBook(){
        return javaBookManage.doUpdateBook();
    }

    /**
     * delete
     * @return
     */
    @RequestMapping("/web/deleteBook")
    public ResponseData deleteBook(){
        return javaBookManage   .doDeleteBook();
    }

}
