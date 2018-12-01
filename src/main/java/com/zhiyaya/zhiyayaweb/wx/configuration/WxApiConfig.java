package com.zhiyaya.zhiyayaweb.wx.configuration;

import com.zhiyaya.zhiyayaweb.wx.WxApi;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yerunjie on 2018-12-01
 *
 * @author yerunjie
 */
@Configuration
public class WxApiConfig {

    @Value("${wx.AppID}")
    private String AppID;
    @Value("${wx.AppSecret}")
    private String AppSecret;


    @Bean
    public WxApi getApi() {
        WxApi wxApi = Feign.builder()
                .contract(new SpringMvcContract())
                .requestInterceptor(requestTemplate -> {
                    requestTemplate.query("appid", AppID).query("secret", AppSecret);
                })
                .encoder(new GsonEncoder()).decoder(new GsonDecoder())
                .target(WxApi.class, "https://api.weixin.qq.com/sns");
        return wxApi;
    }
}
