package com.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * 手工方式获取openid
 * Created by 26725 on 2018/12/11.
 */
@Controller
@RequestMapping
@Slf4j
public class WeChatManualController {
    @GetMapping( "/auth")
    public  void  auth(@RequestParam("code") String  code){
        /*
          1.在公众号端设置回调地址
          2.用户授权后访问下面地址获取code，
          3.通过code换取token_id,scope=snsapi_base则这步直接获取到open_id
          4.如果是snsapi_userinfo,z则需要用户确认授权后才可以拉取信息
             https://open.weixin.qq.com/connect/oauth2/authorize?
             appid=wx5271c0fec72093db&
             redirect_uri=http://zhangql.natapp1.cc/sell/auth&
             response_type=code&
             scope=snsapi_userinfo&
             state=STATE#wechat_redirect
             ***************************
             https://api.weixin.qq.com/sns/oauth2/access_token?
             appid=wx5271c0fec72093db&
             secret=SECRET&
             code=CODE&
             grant_type=authorization_code
        */
        String url =  "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid=wx5271c0fec72093db&" +
                "secret=246690309fedaf15eb62ac16ce12bae9&" +
                "code="+code+"&" +
                "grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        Object forObject = restTemplate.getForObject(url,String.class );
        System.out.println(forObject);
    }
}
