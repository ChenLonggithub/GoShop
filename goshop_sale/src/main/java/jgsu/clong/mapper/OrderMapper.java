package jgsu.clong.mapper;

import java.util.Map;

public interface OrderMapper {
    public void insert_order(Map<Object, Object> map_order);

    void insert_flow(Map<Object, Object> map_flow);

    void insert_infos(Map<Object, Object> map_info);

    void delete_carts(Map<Object, Object> map_cart);
}
