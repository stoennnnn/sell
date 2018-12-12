package com.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 26725 on 2018/12/12.
 */
@Component
@ConfigurationProperties(prefix = "weixin")
@Data
public class WeChatAccountConfig {
    private String appId;
    private String secretId;

}
