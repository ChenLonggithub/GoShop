package jgsu.clong.mapper;

import jgsu.clong.bean.OBJECT_T_MALL_FLOW;
import jgsu.clong.bean.OBJECT_T_MALL_ORDER;
import jgsu.clong.bean.T_MALL_ORDER_INFO;

import java.util.Map;

public interface OrderMapper {
    public void insert_order(Map<Object, Object> map_order);

    void insert_flow(Map<Object, Object> map_flow);

    void insert_infos(Map<Object, Object> map_info);

    void delete_carts(Map<Object, Object> map_cart);

    void update_order(OBJECT_T_MALL_ORDER order);

    void update_flow(OBJECT_T_MALL_FLOW flow);

    long select_count_kc(int sku_id);

    long select_kc(Map<Object, Object> map);

    void update_kc(T_MALL_ORDER_INFO info);
}
