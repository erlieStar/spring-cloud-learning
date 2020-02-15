package com.javashitang;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:30
 */
@Slf4j
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

    @GetMapping("hello")
    public String hello() {
        log.info("start invoke");
        return restTemplate.getForObject("http://localhost:8090/hello", String.class);
    }
}
