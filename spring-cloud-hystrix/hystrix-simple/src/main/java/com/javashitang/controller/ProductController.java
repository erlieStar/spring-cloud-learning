package com.javashitang.controller;

import com.javashitang.service.IProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.javashitang.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @Author: lilimin
 * @Date: 2019/7/31 20:33
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "get/{id}")
    @HystrixCommand(fallbackMethod = "getFallback")
    public Object get(@PathVariable("id") long id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            throw new RuntimeException("该产品已下架");
        }
        return product;
    }

    public Object getFallback(@PathVariable("id") long id) {
        Product product = new Product();
        product.setProductName("HystrixName");
        product.setProductDesc("HystrixDesc");
        product.setProductId(0L);
        return product;
    }

}
