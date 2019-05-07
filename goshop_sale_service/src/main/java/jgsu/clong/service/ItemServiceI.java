package jgsu.clong.service;

import jgsu.clong.bean.DETAIL_T_MALL_SKU;
import jgsu.clong.bean.T_MALL_SKU;

import java.util.List;

public interface ItemServiceI {

    DETAIL_T_MALL_SKU getSkuDetail(int sku_id);

    List<T_MALL_SKU> getSkuListBySpu(int spu_id);
}
