package com.javashitang;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:30
 */
@RestController
@EnableEurekaClient
@SpringBootApplication
public class ConsumerConfigCluster {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerConfigCluster.class);
    }

    @Value("${from}")
    private String from;

    @RequestMapping("from")
    public String from() {
        return this.from;
    }
}
