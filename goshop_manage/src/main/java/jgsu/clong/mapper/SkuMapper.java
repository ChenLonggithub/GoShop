package jgsu.clong.mapper;

import jgsu.clong.bean.T_MALL_PRODUCT;
import jgsu.clong.bean.T_MALL_SKU;

import java.util.List;
import java.util.Map;

public interface SkuMapper {

    List<T_MALL_PRODUCT> querySpu(Map<Object, Object> map);

    void insert_sku(T_MALL_SKU sku);

    void insert_sku_value(Map<Object, Object> map);
}
