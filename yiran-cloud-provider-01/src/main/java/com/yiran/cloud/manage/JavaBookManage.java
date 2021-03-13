package com.yiran.cloud.manage;

import com.yiran.cloud.entity.JavaBook;
import com.yiran.cloud.response.ResponseData;
import com.yiran.cloud.response.ResponseStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 服务端处理类
 * Created by Ale on 2021/3/13
 */
@Service
public class JavaBookManage {

    /**
     * get
     * @return
     */
    public ResponseData doHello() {
        return new ResponseData().success(ResponseStatus.SUCCESS,true,"Hello SpringCloud - 02");
    }


    /**
     * get
     * @param id
     * @param name
     * @param author
     * @return
     */
    public ResponseData<List<JavaBook>> doGetBooks(long id, String name, String author) {
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

    /**
     * post
     * @param data
     * @return
     */
    public ResponseData doAddBooks(Map<String, Object> data) {
        System.out.println(data.get("books").toString());
        return new ResponseData().success(ResponseStatus.SUCCESS,true);
    }

    /**
     * put
     * @param data
     * @return
     */
    public ResponseData doUpdateBooks(Map<String, Object> data) {
        System.out.println(data.toString());
        return  new ResponseData().success(ResponseStatus.SUCCESS,true);
    }

    /**
     * delete
     * @param id
     * @param name
     * @param author
     * @return
     */
    public ResponseData doDeleteBooks(long id, String name, String author) {
        System.out.println("编号：" + id + "，名称：" + name + "，作者：" + author);
        return new ResponseData().success(ResponseStatus.SUCCESS,true);
    }
}
