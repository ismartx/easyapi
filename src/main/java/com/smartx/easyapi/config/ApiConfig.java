package com.smartx.easyapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * <b>Creation Time:</b> 2018/4/21
 *
 * @author kext
 */
@ConfigurationProperties(prefix = "easyapi")
@Component
@Getter
@Setter
public class ApiConfig {

    private String secret;
}
