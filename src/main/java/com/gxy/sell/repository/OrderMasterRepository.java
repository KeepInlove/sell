package com.gxy.sell.repository;

import com.gxy.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author GUO
 * @Classname OrderMasterRepository
 * @Description TODO
 * @Date 2020/9/27 19:57
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String>{
    Page<OrderMaster>findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
