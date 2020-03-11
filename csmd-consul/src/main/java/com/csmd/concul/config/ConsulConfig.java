package com.csmd.concul.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * create by gary 2020/3/11
 * 技术交流请加QQ:498982703
 */
@Configuration
public class ConsulConfig {
    @Bean
    public SampleProperties sampleProperties() {
        return new SampleProperties();
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }



}
