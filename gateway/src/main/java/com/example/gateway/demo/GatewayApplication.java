package com.example.gateway.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author TX
 * @version 1.0
 * @description GatewayApplication
 * @date 2020/9/22 5:22 下午
 */
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(GatewayApplication.class, args);
    }
}
