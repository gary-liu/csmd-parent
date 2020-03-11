package com.csmd.concul.controller;

import com.csmd.concul.config.SampleProperties;
import com.csmd.concul.feign.SampleClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * create by gary 2020/3/11
 * 技术交流请加QQ:498982703
 */
@RestController
@Slf4j
public class ConsulHomeController {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Environment environment;

    @Autowired
    private SampleClient sampleClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Registration registration;

    @Autowired
    private SampleProperties sampleProperties;


    @Value("${spring.application.name:testConsulApp}")
    private String appName;


    @GetMapping("/home")
    public String  home() {
        return "hello world";
    }


    @GetMapping("/me")
    public ServiceInstance me() {
        return this.registration;
    }


    @GetMapping("/")
    public ServiceInstance loadBalance() {

        return this.loadBalancer.choose(this.appName);
    }

    @GetMapping("/rest")
    public String rest() {
        return this.restTemplate.getForObject("http://" + this.appName + "/me", String.class);
    }

    @GetMapping("/choose")
    public String choose() {
        return this.loadBalancer.choose(this.appName).getUri().toString();
    }

    @GetMapping("/myenv")
    public String env(@RequestParam("prop") String prop) {
        return this.environment.getProperty(prop, "Not Found");
    }

    @GetMapping("/prop")
    public String prop() {
        return sampleProperties.getProp();
    }

    @GetMapping("/instances")
    public List<ServiceInstance> instances() {
        return discoveryClient.getInstances(this.appName);
    }

    @GetMapping("/feign")
    public String feign() {
        return this.sampleClient.choose();
    }






}
