package com.javashitang;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
public class ConsumerRibbonHystrix {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonHystrix.class);
    }

    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("hello")
    @HystrixCommand(fallbackMethod = "hiError")
    public String hello(@RequestParam String name) {
        return restTemplate.getForObject("http://PRODUCER-SIMPLE/hello?name=" + name, String.class);
    }

    public String helloError(String name) {
        return "hello " + name + " an error occur";
    }
}
