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

import java.net.URI;

/**
 * @Author: lilimin
 * @Date: 2019/8/1 14:55
 */
@Slf4j
@RestController
@RequestMapping("consumer")
public class ConsumerProductControllerType2 {

    public static final String PRODUCT_TOPIC = "CLOUD-PROVIDER-PRODUCT";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders httpHeaders;

    /** 在服务的消费方获取服务提供方的具体信息 */
    @Resource
    private LoadBalancerClient loadBalancerClient;

    /**
     * 不使用eureka，直接使用ribbon来调用
     * @param id
     * @return
     */
    @RequestMapping("product/get/{id}")
    public Object getServer(@PathVariable("id") long id) {
        ServiceInstance instance = this.loadBalancerClient.choose(PRODUCT_TOPIC);
        System.out.println(String.format("host %s , port %s, serverId %s", instance.getHost(), instance.getPort(), instance.getServiceId()));
        URI uri =  URI.create(String.format("http://%s:%s/product/get/%s", instance.getHost(), instance.getPort(), String.valueOf(id)));
        Product product = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), Product.class).getBody();
        return product;
    }
}
