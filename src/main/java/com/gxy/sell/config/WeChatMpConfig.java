package com.gxy.sell.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author GUO
 * @Classname WeChatMpConfig
 * @Description 微信第三方SDK配置
 * @Date 2020/11/27 19:22
 */
@Component
@Configuration(proxyBeanMethods = true)
public class WeChatMpConfig {
    @Autowired
    private WechartConfig wechartConfig;
    @Bean
    public WxMpService wxMpService(){
        WxMpService wxMpService=new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage(){
        WxMpInMemoryConfigStorage wxMpConfigStorage=new WxMpInMemoryConfigStorage();
        wxMpConfigStorage.setAppId(wechartConfig.getMpAppId());
        wxMpConfigStorage.setSecret(wechartConfig.getMpAppSecret());
        return  wxMpConfigStorage;
    }
}
