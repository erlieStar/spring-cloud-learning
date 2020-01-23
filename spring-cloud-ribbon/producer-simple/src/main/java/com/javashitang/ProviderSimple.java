package com.javashitang;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:30
 */
@RestController
@EnableEurekaClient
@SpringBootApplication
public class ProviderSimple {

    public static void main(String[] args) {
        SpringApplication.run(ProviderSimple.class);
    }

    @Value("${server.port}")
    private String port;

    @RequestMapping("hello")
    public String hello() {
        return "hello, i am from port:" + port;
    }
}
