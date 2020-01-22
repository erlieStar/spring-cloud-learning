package com.javashitang.controller;

import com.javashitang.service.IProductClientService;
import org.hibernate.validator.constraints.ParameterScriptAssert;
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

import javax.annotation.Resource;

/**
 * @Author: lilimin
 * @Date: 2019/8/1 14:55
 */
@RestController
@RequestMapping("consumer")
public class ConsumerProductController {

    @Resource
    private IProductClientService iProductClientService;

    @RequestMapping("product/get/{id}")
    public Object getProduct(@PathVariable("id") long id) {
        return iProductClientService.getProduct(id);
    }
}
