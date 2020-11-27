package com.gxy.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author GUO
 * @Classname WechartConfig
 * @Description TODO
 * @Date 2020/11/27 19:33
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechartConfig {
    private String mpAppId;

    private String mpAppSecret;

}
