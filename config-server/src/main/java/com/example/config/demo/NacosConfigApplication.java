package com.example.config.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TX
 * @version 1.0
 * @description NacosConfigApplication
 * @date 2020/9/22 9:53 上午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(NacosConfigApplication.class);
        String serverAddr = configurableApplicationContext.getEnvironment().getProperty("spring.cloud.nacos.discovery.server-addr");
        String dashboard = configurableApplicationContext.getEnvironment().getProperty("spring.cloud.sentinel.transport.dashboard");
        System.out.println(serverAddr);
        System.out.println(dashboard);
    }

    /*@Slf4j
    @RestController
    @RefreshScope
    static class TestController {

        @Value("${test.name}")
        private String name;

        @Value("${test.pwd}")
        private String pwd;

        @GetMapping("/test")
        public String hello() {
            return name;
        }

        @GetMapping("/pwd")
        public String hello1() {
            return pwd;
        }

    }*/
}
