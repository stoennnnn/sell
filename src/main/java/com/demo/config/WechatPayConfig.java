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
        //公众号配置
        WxPayH5Config wxPayH5Config =    new WxPayH5Config();
        wxPayH5Config.setAppId(weChatAccountConfig.getAppId());
        weChatAccountConfig.setKeyPath(weChatAccountConfig.getKeyPath());
        weChatAccountConfig.setMchId(weChatAccountConfig.getMchId());
        weChatAccountConfig.setMchKey(weChatAccountConfig.getMchKey());
        weChatAccountConfig.setSecretId(weChatAccountConfig.getSecretId());
        //支付类
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayH5Config(wxPayH5Config);
        return bestPayService;
    }

}
