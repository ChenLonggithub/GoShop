package jgsu.clong.service;

import jgsu.clong.bean.MODEL_T_MALL_ATTR;
import jgsu.clong.bean.T_MALL_PRODUCT;
import jgsu.clong.bean.T_MALL_SKU;
import jgsu.clong.bean.T_MALL_SKU_ATTR_VALUE;

import java.util.List;

public interface SkuService {
    List<T_MALL_PRODUCT> getSpuList(int pp_id, int flbh2);

    void save_sku(T_MALL_PRODUCT product, T_MALL_SKU sku, List<T_MALL_SKU_ATTR_VALUE> list_attr);
}
