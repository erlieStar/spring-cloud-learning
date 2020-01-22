package com.javashitang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:30
 * RibbonClient 指定某一个服务的负载均衡策略
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerEurekaRibbonApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerEurekaRibbonApp.class);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
