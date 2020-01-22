package com.javashitang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:30
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApp {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApp.class);
    }
}
