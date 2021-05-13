package com.gxy.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author GUO
 * @Classname SellerInfo
 * @Description TODO
 * @Date 2021/5/9 19:59
 */
@Data
@Entity
public class SellerInfo {
    @Id
    private String sellerId;

    private String username;

    private String password;

    private String phone;
}
