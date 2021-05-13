package com.gxy.sell.service.impl;

import com.gxy.sell.dataobject.SellerInfo;
import com.gxy.sell.repository.SellerInfoRepository;
import com.gxy.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GUO
 * @Classname SellerServiceImpl
 * @Description TODO
 * @Date 2021/5/9 20:10
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;
    /**
     * @param username,password
     * @return
     */
    @Override
    public SellerInfo findByUsernameAndPassword(String username,String password) {
        return sellerInfoRepository.findByUsernameAndPassword(username,password);
    }
}
