package com.javashitang.controller;

import com.javashitang.vo.Product;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("consumer2")
public class ConsumerProductControllerType2 {

    public static final String PRODUCT_GET_URL = "http://CLOUD-PROVIDER-PRODUCT/product/get/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    /** 在服务的消费方获取服务提供方的具体信息 */
    @Resource
    private LoadBalancerClient loadBalancerClient;

    /**
     * ribbon基于eureka来实现负载均衡
     * @param id
     * @return
     */
    @RequestMapping("product/get/{id}")
    public Object getProduct(@PathVariable("id") long id) {
        Product product = restTemplate.exchange(PRODUCT_GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), Product.class).getBody();
        return product;
    }

    @RequestMapping("product/list")
    public Object getServer(@PathVariable("id") long id) {
        ServiceInstance instance = this.loadBalancerClient.choose("cloud-provider-product");
        System.out.println(String.format("host %s , port %s, serverId %s", instance.getHost(), instance.getPort(), instance.getServiceId()));
        return "success";
    }
}
