package com.javashitang.service;

import com.javashitang.vo.Product;
import com.javashitang.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: lilimin
 * @Date: 2019/8/9 0:57
 */
@FeignClient(name = "CLOUD-PROVIDER-PRODUCT", configuration = FeignClientConfig.class)
public interface IProductClientService {

    @RequestMapping("product/get/{id}")
    public Product getProduct(@PathVariable("id") long id);
}
