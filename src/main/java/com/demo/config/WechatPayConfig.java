package com.demo.config;

import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by 26725 on 2018/12/19.
 */
@Component
public class WechatPayConfig {
    @Autowired
    private WeChatAccountConfig weChatAccountConfig;

    @Bean
    public BestPayServiceImpl payConfig(){
        //支付类
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayH5Config(this.wxPayH5Config());
        return bestPayService;
    }

    @Bean
    public WxPayH5Config wxPayH5Config(){
        //公众号配置
        WxPayH5Config wxPayH5Config = new WxPayH5Config();
        wxPayH5Config.setAppId(weChatAccountConfig.getAppId());
        wxPayH5Config.setKeyPath(weChatAccountConfig.getKeyPath());
        wxPayH5Config.setMchId(weChatAccountConfig.getMchId());
        wxPayH5Config.setMchKey(weChatAccountConfig.getMchKey());
        wxPayH5Config.setAppSecret(weChatAccountConfig.getSecretId());
        wxPayH5Config.setNotifyUrl(weChatAccountConfig.getNotifyUrl());
        return wxPayH5Config;
    }
}
