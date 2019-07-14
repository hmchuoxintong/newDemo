package com.nz.supplieritem.controller.async.queue;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.nz.supplieritem.controller.async.DeferredResultHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component //ApplicationListener 监听器
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MyQueue myQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;
    private Logger log = LoggerFactory.getLogger(getClass());
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        new Thread(()->{
            while(true){
                if(StringUtils.isNotEmpty(myQueue.getCompleteOrder())){
                    String orderNumber = myQueue.getCompleteOrder();

                    log.info("返回订单处理结果 : " + orderNumber);
                    deferredResultHolder.getMap().get(orderNumber).setResult("place order success");
                    myQueue.setCompleteOrder(null);
                }else{
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
