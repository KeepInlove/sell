package com.gxy.sell.repository;

import com.gxy.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author GUO
 * @Classname OrderDetailRepository
 * @Description TODO
 * @Date 2020/9/27 20:02
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    List<OrderDetail>findByOrderId(String orderId);
}
