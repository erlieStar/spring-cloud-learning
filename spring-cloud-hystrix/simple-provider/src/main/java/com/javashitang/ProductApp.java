package com.javashitang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:30
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.st.dao")
public class ProductApp {

    public static void main(String[] args) {
        SpringApplication.run(ProductApp.class);
    }
}
