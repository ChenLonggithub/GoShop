package jgsu.clong.service;

import jgsu.clong.bean.OBJECT_T_MALL_ORDER;
import jgsu.clong.bean.T_MALL_ADDRESS;

public interface OrderService {
    void save_order(T_MALL_ADDRESS get_address, OBJECT_T_MALL_ORDER order);

    void pay_success(OBJECT_T_MALL_ORDER order) throws OverSaleException;
}
