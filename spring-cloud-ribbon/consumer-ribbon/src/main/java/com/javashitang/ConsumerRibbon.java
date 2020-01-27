package com.javashitang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:30
 */
@RestController
@EnableEurekaClient
@SpringBootApplication
public class ConsumerRibbon {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbon.class);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("hello")
    public String hello(@RequestParam String name) {
        return restTemplate.getForObject("http://PRODUCER-SIMPLE/hello?name=" + name, String.class);
    }
}
