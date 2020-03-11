package com.csmd.concul.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * create by gary 2020/3/11
 * 技术交流请加QQ:498982703
 */
@SuppressWarnings("ConfigurationProperties")
@ConfigurationProperties("sample")
@Data
public class SampleProperties {

    private String prop = "default value";
}
