package com.gxy.sell.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author GUO
 * @Classname WXController
 * @Description 微信测试接口
 * @Date 2020/11/23 19:59
 */
@Api(tags = "微信测试接口")
@RestController
@RequestMapping("/wx")
@Slf4j
public class WXController {
    //微信认证接口
    @ApiOperation("微信认证接口")
    @GetMapping("/auth")
    public void auth(@RequestParam("code")String code){
        log.info("进入auth方法...");
        log.info("code={}",code);
//        String url=" https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx6ae5e9be2a11ab4f&secret=345063d51bee0ea74810762bfed39ce7&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate=new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}",response);
    }
}
