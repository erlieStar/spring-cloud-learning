package com.javashitang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:30
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ConsumerFeign {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign.class);
    }

    @Autowired
    private SimpleClient simpleClient;

    @FeignClient(value = "producer-simple")
    public interface SimpleClient {
        @RequestMapping("hello")
        String hello(@RequestParam("name") String name);
    }

    @RequestMapping("hello")
    public String hello(@RequestParam String name) {
        return simpleClient.hello(name);
    }
}
