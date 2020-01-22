package com.ruleconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @Author: lilimin
 * @Date: 2019/8/1 14:43
 */
public class RibbonConfig {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

}
