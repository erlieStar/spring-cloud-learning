package com.javashitang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:30
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.javashitang.msdao")
public class ConsumerFeign {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign.class);
    }
}
