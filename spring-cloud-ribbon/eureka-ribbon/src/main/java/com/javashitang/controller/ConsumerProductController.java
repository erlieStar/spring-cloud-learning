package com.javashitang.controller;

import com.javashitang.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: lilimin
 * @Date: 2019/8/1 14:55
 */
@RestController
@RequestMapping("consumer")
public class ConsumerProductController {

    public static final String PRODUCT_GET_URL = "http://CLOUD-PROVIDER-PRODUCT/product/get/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    @RequestMapping("product/get/{id}")
    public Object getProduct(@PathVariable("id") long id) {
        Product product = restTemplate.exchange(PRODUCT_GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), Product.class).getBody();
        return product;
    }

//    @RequestMapping("product/get/{id}")
//    public Object getProduct(@PathVariable("id") long id) {
//        Product product = restTemplate.getForObject(PRODUCT_GET_URL + id, Product.class);
//        return product;
//    }
}
