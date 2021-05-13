package com.gxy.sell.handler;

import com.gxy.sell.config.ProjectUrlConfig;
import com.gxy.sell.exception.SellException;
import com.gxy.sell.exception.SellerAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author GUO
 * @Classname ExceptionHandler
 * @Description TODO
 * @Date 2021/5/12 16:45
 */
@ControllerAdvice
public class SellExceptionHandler {
//    @Autowired
//    private ProjectUrlConfig projectUrlConfig;
    //拦截登陆异常
    @ExceptionHandler(value = SellerAuthorizeException.class )
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:/login.html");
    }
}
