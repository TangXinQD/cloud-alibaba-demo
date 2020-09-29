package com.example.nacos.discovery.demo;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author TX
 * @version 1.0
 * @description TestController
 * @date 2020/9/16 5:05 下午
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private FeignTestService feignTestService;

    @GetMapping("/one")
    @SentinelResource("one")
    public Mono<String> one(){
        /*Mono<String> stringMono = webClientBuilder.build()
                .get()
                .uri("http://sentinel/sentinel/demo/hello")
                .retrieve()
                .bodyToMono(String.class);*/

        String test = feignTestService.test();
        return Mono.just(test);
    }

}
