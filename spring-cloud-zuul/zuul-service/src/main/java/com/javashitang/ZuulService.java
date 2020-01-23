package com.javashitang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:30
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZuulService {

    public static void main(String[] args) {
        SpringApplication.run(ZuulService.class);
    }
}
