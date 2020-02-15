package com.javashitang;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:30
 */
@Slf4j
@RestController
@SpringBootApplication
public class ProducerZipkin {

    public static void main(String[] args) {
        SpringApplication.run(ProducerZipkin.class);
    }

    @RequestMapping("hello")
    public String hello() {
        log.info("new request");
        return "hi zipkin";
    }
}
