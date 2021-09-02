package com.javashitang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:30
 */
@RestController
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ConsumerFeign {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign.class);
    }

    @Autowired
    private SimpleClient simpleClient;

    // producer-simple:8001
    // 可以不通过eureka获取producer-simple的地址，直接通过url指定地址，例如
    // @FeignClient(value = "producer-simple", url = "127.0.0.1:8001")
    @FeignClient(value = "producer-simple")
    public interface SimpleClient {
        @RequestMapping("hello")
        String hello(@RequestParam String name);
    }

    @RequestMapping("hello")
    public String hello(@RequestParam String name) {
        return simpleClient.hello(name);
    }
}
