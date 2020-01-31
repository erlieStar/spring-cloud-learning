package com.javashitang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:30
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class ConfigCluster {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCluster.class);
    }
}
