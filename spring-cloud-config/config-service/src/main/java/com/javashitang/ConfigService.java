package com.javashitang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:30
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigService {

    public static void main(String[] args) {
        SpringApplication.run(ConfigService.class);
    }
}
