package com.javashitang;

import com.ruleconfig.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:30
 * RibbonClient 指定某一个服务的负载均衡策略
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PROVIDER-PRODUCT", configuration = RibbonConfig.class)
@EnableFeignClients("com.st.service")
public class ConsumerFeignApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApp.class);
    }
}
