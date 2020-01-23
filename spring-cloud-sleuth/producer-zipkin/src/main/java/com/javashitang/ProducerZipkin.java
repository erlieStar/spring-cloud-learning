package com.javashitang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:30
 */
@RestController
@SpringBootApplication
public class ProducerZipkin {

    public static void main(String[] args) {
        SpringApplication.run(ProducerZipkin.class);
    }

    public String hello() {
        return "hi zipkin";
    }
}
