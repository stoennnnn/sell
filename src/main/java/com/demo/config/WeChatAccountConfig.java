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
    /**
     * 商户号
     */
    private String mchId;

    /**
     * 商户密钥
     */
    private String mchKey;

    /**
     * 商户证书路径
     */
    private String keyPath;

    private String notifyUrl;

}
