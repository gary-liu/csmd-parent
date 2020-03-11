package com.csmd.concul.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * create by gary 2020/3/11
 * 技术交流请加QQ:498982703
 */
@FeignClient("testConsulApp")
public interface SampleClient {

    @GetMapping("/choose")
    String choose();

}
