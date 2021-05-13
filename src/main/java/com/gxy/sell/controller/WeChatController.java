package com.gxy.sell.controller;

import com.gxy.sell.config.ProjectUrlConfig;
import com.gxy.sell.enums.ResultEnum;
import com.gxy.sell.exception.SellException;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

/**
 * @author GUO
 * @Classname WeChatController
 * @Description 微信认证接口
 * @Date 2020/11/27 19:11
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
@Api(tags = "微信认证接口")
public class WeChatController {

    @Autowired
    private WxMpService wxMpService;
    @Autowired
    private ProjectUrlConfig projectUrlConfig;
    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl){
//        WxMpService wxMpService=new WxMpServiceImpl();
        //1.配置
        //2.调用方法
        String url=projectUrlConfig.getWechatMpAuthorize()+"/sell/wechat/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_BASE, URLEncoder.encode(returnUrl));
        log.info("【微信网页授权】获取code,redirectUrl={}",redirectUrl);
        return "redirect:" + redirectUrl;

    }
    @GetMapping("/userInfo")
    public String  userInfo(@RequestParam("code") String code, @RequestParam("state") String returnUrl){

        WxMpOAuth2AccessToken  wxMpOAuth2AccessToken=new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken=wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            e.printStackTrace();
            log.error("【微信网页授权】{}",e);
            throw new SellException(ResultEnum.WXCHART_MP_ERROR.getCode(),e.getError().getErrorMsg());
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();
        log.info("openid={}",openId);
        return "redirect:" + returnUrl +"?openid=" + openId;
    }
}
