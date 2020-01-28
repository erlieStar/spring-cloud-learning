package com.javashitang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
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
public class ConsumerFeignHystrix {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignHystrix.class);
    }

    @Autowired
    private SimpleClient simpleClient;

    @FeignClient(value = "producer-simple", fallback = SimpleClientHystrix.class)
    public interface SimpleClient {
        @RequestMapping("hello")
        String hello(@RequestParam String name);
    }

    @Component
    public class SimpleClientHystrix implements SimpleClient {
        public String hello(String name) {
            return "hello " + name + ", an error occur";
        }
    }

    @RequestMapping("hello")
    public String hello(@RequestParam String name) {
        return simpleClient.hello(name);
    }
}
