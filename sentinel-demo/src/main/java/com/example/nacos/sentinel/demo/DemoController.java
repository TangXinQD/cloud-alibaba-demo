package com.example.nacos.sentinel.demo;

import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author TX
 * @version 1.0
 * @description DemoController
 * @date 2020/8/12 5:08 下午
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping(value = "/hello")
    @SentinelResource("hello-demo")
    public Mono<String> hello() {
        return Mono.just("hello sentinel");
    }

    @GetMapping(value = "/hello1")
    @SentinelResource("hello-demo")
    public String hello1() {
        return "hello sentinel";
    }
}
