package com.yiran.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yiran.cloud.manage.JavaBookManage;
import com.yiran.cloud.response.ResponseData;
import com.yiran.cloud.response.ResponseStatus;
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


    /**
     * Hystrix 服务熔断降级处理
     * 通过在方法添加 @HystrixCommand(fallbackMethod = "error")
     * fallbackMethod 用来指定当前类的回掉方法
     *
     * 异常处理
     * commandProperties HystrixProperty 自定义响应超时时间 当响应超过此时间后进行熔断处理
     * @return
     */
    @HystrixCommand(
            fallbackMethod = "error",
            commandProperties = {
                    // 默认应用超时时间为 1000 毫秒，通过 commandProperties @HystrixProperty 来更改默认响应超时时间
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3500")
            }
    )
    @RequestMapping("/web/hystrix")
    public ResponseData hystrix() {
        return javaBookManage.doHello();
    }

    /**
     * 服务熔断的回掉方法
     * @param throwable Hystrix的服务降级熔断机制会通过 Throwable 参数 来封装异常信息
     * @return
     */
    public ResponseData error(Throwable throwable){
        System.out.println(throwable.getMessage());
        return new ResponseData().error(ResponseStatus.Error,false,"服务异常，请稍后试试...");
    }


    /**
     * Hystrix 服务熔断忽略异常处理
     * 通过在方法添加 @HystrixCommand(fallbackMethod = "error"，ignoreExceptions = Error.class)
     * @return
     */
    @HystrixCommand(fallbackMethod = "error", ignoreExceptions = RuntimeException.class,
            commandProperties = {
            // 默认应用超时时间为 1000 毫秒，通过 commandProperties @HystrixProperty 来更改默认响应超时时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3500")
    })
    @RequestMapping("/web/ignore")
    public ResponseData ignore() {
        return javaBookManage.doHello();
    }


    /**
     * 自定义的熔断异常处理
     * @return
     */
    @RequestMapping("/web/diyHystrix")
    public ResponseData diyHystrix(){
        return javaBookManage.doDiyHystrix();
    }


}
