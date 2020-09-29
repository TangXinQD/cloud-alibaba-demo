package com.example.nacos.discovery.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author TX
 * @version 1.0
 * @description FeignTestService
 * @date 2020/9/16 5:48 下午
 */
@FeignClient(value = "sentinel",fallback = FeignTestServiceFallback.class)
public interface FeignTestService {
    @GetMapping(value = "/sentinel/demo/hello")
    String test();
}
