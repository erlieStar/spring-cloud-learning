package com.javashitang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:30
 * RibbonClient 指定某一个服务的负载均衡策略
 */
@SpringBootApplication
//@RibbonClient(name = "CLOUD-PROVIDER-PRODUCT", configuration = RibbonConfig.class)
public class ConsumerRibbonApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonApp.class);
    }
}
