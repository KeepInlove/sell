package com.gxy.sell.config;

import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author GUO
 * @Classname WechartPayConfig
 * @Description TODO
 * @Date 2021/4/28 0:20
 */
@Component
public class WechartPayConfig {
    @Autowired
    private WechartAccountConfig accountConfig;

    @Bean
    private BestPayServiceImpl bestPayService(){
//        WxPayConfig wxPayConfig=new WxPayConfig();
//        wxPayConfig.setAppAppId(accountConfig.getMpAppId());
//        wxPayConfig.setAppSecret(accountConfig.getMpAppSecret());
//        wxPayConfig.setMchId(accountConfig.getMchId());
//        wxPayConfig.setMchKey(accountConfig.getMchKey());
//        wxPayConfig.setKeyPath(accountConfig.getKeyPath()); //路径
        BestPayServiceImpl bestPayService=new BestPayServiceImpl();
        bestPayService.setWxPayConfig(wxPayConfig());
        return bestPayService;
    }
    public WxPayConfig wxPayConfig(){
        WxPayConfig wxPayConfig=new WxPayConfig();
        wxPayConfig.setAppId(accountConfig.getMpAppId());
        wxPayConfig.setAppSecret(accountConfig.getMpAppSecret());
        wxPayConfig.setMchId(accountConfig.getMchId());
        wxPayConfig.setMchKey(accountConfig.getMchKey());
        wxPayConfig.setNotifyUrl(accountConfig.getNotifyUrl());
        wxPayConfig.setKeyPath(accountConfig.getKeyPath()); //路径
        return wxPayConfig;
    }
}
