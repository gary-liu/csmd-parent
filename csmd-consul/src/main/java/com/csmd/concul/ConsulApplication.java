package com.csmd.concul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * create by gary 2020/3/11
 * 技术交流请加QQ:498982703
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ConsulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulApplication.class);

    }
}
