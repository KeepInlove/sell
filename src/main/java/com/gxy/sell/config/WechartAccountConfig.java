package com.gxy.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;

/**
 * @author GUO
 * @Classname WechartConfig
 * @Description TODO
 * @Date 2020/11/27 19:33
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechartAccountConfig {
    //    公众号AppId
    private String mpAppId;
    //    公众号密钥
    private String mpAppSecret;
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
    /**
     * 证书内容
     */
    private SSLContext sslContext;
    /**
     * 微信异步通知地址
     */
    private String notifyUrl;

}
