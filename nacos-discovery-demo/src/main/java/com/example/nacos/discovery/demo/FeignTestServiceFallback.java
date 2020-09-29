package com.example.nacos.discovery.demo;

import org.springframework.stereotype.Component;

/**
 * @author TX
 * @version 1.0
 * @description FeignTestServiceFallback
 * @date 2020/9/16 5:49 下午
 */
@Component
public class FeignTestServiceFallback implements FeignTestService {
    @Override
    public String test() {
        return "2222";
    }
}
