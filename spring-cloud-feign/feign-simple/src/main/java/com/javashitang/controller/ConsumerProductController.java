package com.javashitang.controller;


import com.javashitang.msdao.ProductClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: lilimin
 * @Date: 2019/8/1 14:55
 */
@RestController
@RequestMapping("consumer")
public class ConsumerProductController {

    @Resource
    private ProductClient productClient;

    @RequestMapping("product/get/{id}")
    public Object getProduct(@PathVariable("id") long id) {
        return productClient.getProduct(id);
    }
}
