package com.gxy.sell.repository;

import com.gxy.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author GUO
 * @Classname SellerInfoDao
 * @Description TODO
 * @Date 2021/5/9 20:00
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByUsernameAndPassword(String username,String password);
}

