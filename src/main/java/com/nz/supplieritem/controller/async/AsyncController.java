package com.nz.supplieritem.controller.async;

import com.nz.supplieritem.controller.async.queue.MyQueue;
import net.bytebuddy.utility.RandomString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * 异步处理Controller
 */
@RestController
public class AsyncController {
    private Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private MyQueue myQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;
    /**
     * 异步返回的第一种方式
     * 使用Runable异步处理Rest服务
     * @return
     * @throws Exception
     */
    @GetMapping("/order")
    public Callable<String> order() throws Exception {
        log.info("主线程开始");
        Callable<String> result = new Callable<String>(){
            @Override
            public String call() throws Exception {
                System.out.println("副线程");
                log.info("副线程开始");
                Thread.sleep(3000);
                log.info("副线程返回");
                return "ok";
            }
        };
        log.info("主线程返回");
        return result;
    }

    /**
     * 第二种异步返回的方法
     * 使用DeferedResult异步处理Rest服务
     * @return
     * @throws Exception
     */
    @GetMapping("/order2")
    public DeferredResult<String> order2() throws Exception {
        log.info("主线程开始");
        String oderNumber = RandomString.make(8);
        myQueue.setPlaceOrder(oderNumber);
        System.out.println("order id " + oderNumber);
        DeferredResult<String> result = new DeferredResult<String>();
        deferredResultHolder.getMap().put(oderNumber,result);
        log.info("主线程返回");
        return result;
    }

}
