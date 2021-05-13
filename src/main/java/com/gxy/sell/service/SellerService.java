package com.gxy.sell.service;

import com.gxy.sell.dataobject.SellerInfo;

/**
 * @author GUO
 * @Classname SellerService
 * @Description TODO
 * @Date 2021/5/9 20:08
 */
public interface SellerService {
    /**
     * 通过openid查询
     * @param username,password
     * @return
     */
    SellerInfo findByUsernameAndPassword(String username,String password);
}
