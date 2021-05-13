package com.gxy.sell.controller;

import com.gxy.sell.config.ProjectUrlConfig;
import com.gxy.sell.constant.CookieConstant;
import com.gxy.sell.constant.RedisConstant;
import com.gxy.sell.dataobject.SellerInfo;
import com.gxy.sell.enums.ResultEnum;
import com.gxy.sell.service.SellerService;
import com.gxy.sell.utils.CookieUtil;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author GUO
 * @Classname SellerUserController
 * @Description 卖家用户
 * @Date 2021/5/9 23:30
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @PostMapping("/login")
    public ModelAndView login(String username, String password, Map<String,Object>map, HttpServletResponse response){
        //1.登录查询
        SellerInfo sellerInfo = sellerService.findByUsernameAndPassword(username, password);
        if (sellerInfo==null){
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url","/sell/login.html");
            return new ModelAndView("common/error",map);
        }
        //2.设置token至缓存
        String token= UUID.randomUUID().toString();
        Integer expire= RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),sellerInfo.getPhone(),expire, TimeUnit.SECONDS);
        //3.设置Cookie
   /*     Cookie cookie=new Cookie("token",token);
        cookie.setPath("/");
        cookie.setMaxAge(7200);
        response.addCookie(cookie);*/
        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);
        return new ModelAndView("redirect:/seller/order/list");
    }
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,HttpServletResponse response,Map<String,Object>map){
        //1.从cookie里查询
        Cookie cookie=CookieUtil.get(request,CookieConstant.TOKEN);
        if (cookie!=null){
            //2.清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
            //清除cookie
            CookieUtil.set(response,CookieConstant.TOKEN,null,0);
        }
        map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url","/sell/login.html");
        return new ModelAndView("common/success",map) ;
    }
}
