package jgsu.clong.service;

import jgsu.clong.bean.OBJECT_T_MALL_ATTR;
import jgsu.clong.bean.OBJECT_T_MALL_SKU;
import jgsu.clong.bean.T_MALL_SKU_ATTR_VALUE;

import java.util.List;

public interface ListService {

    List<OBJECT_T_MALL_ATTR> getAttrList(int flbh2);

    List<OBJECT_T_MALL_SKU> get_sku(int flbh2);

    List<OBJECT_T_MALL_SKU> getSkuByAttr(int flbh2,List<T_MALL_SKU_ATTR_VALUE> list_attr);
}
