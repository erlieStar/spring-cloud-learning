package com.javashitang.msdao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: lilimin
 * @Date: 2019/8/9 0:57
 */
@FeignClient(name = "CLOUD-PROVIDER-PRODUCT")
public interface UserClient {

    @RequestMapping("product/get/{id}")
    String getProduct(@PathVariable("id") long id);
}
