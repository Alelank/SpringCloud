package com.yiran.cloud.controller;

import com.yiran.cloud.response.ResponseData;
import com.yiran.cloud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ale on 2021/3/15
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    @RequestMapping("/web/hello")
    public ResponseData hello(){
        return bookService.hello();
    }
}
