package com.gxy.sell.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GUO
 * @Classname CookieUtil
 * @Description TODO
 * @Date 2021/5/12 15:49
 */
public class CookieUtil {

    //设置cookie
    public static void set(HttpServletResponse response,String name,
                            String value,int maxAge){
        Cookie cookie=new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(7200);
        response.addCookie(cookie);
    }

    /**
     * 获取cookie
     * @param request
     * @param name
     * @return
     */
    public static Cookie get(HttpServletRequest request,String name){
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name)){
            return cookieMap.get(name);
        }else {
            return null;
        }
    }

    /**
     * 将cookie封装成map
     * @param request
     * @return
     */
    private static Map<String,Cookie>readCookieMap(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        Map<String,Cookie>cookieMap=new HashMap<>();
        if (cookies!=null){
            for (Cookie cookie:cookies){
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }
}
