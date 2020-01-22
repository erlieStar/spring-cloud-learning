package com.javashitang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:33
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "get/{id}")
    public Object get(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }

    /**
     * 直接返回发现服务信息
     */
    @RequestMapping("discover")
    public Object discover() {
        return client;
    }

}
