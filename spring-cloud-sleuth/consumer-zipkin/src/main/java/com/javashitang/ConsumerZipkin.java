package com.javashitang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:30
 */
@RestController
@SpringBootApplication
public class ConsumerZipkin {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerZipkin.class);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String hello() {
        return restTemplate.getForObject("http://localhost:8090/hello", String.class);
    }
}
