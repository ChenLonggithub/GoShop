package jgsu.clong.service.impl;

import org.springframework.stereotype.Service;
import jgsu.clong.bean.DETAIL_T_MALL_SKU;
import jgsu.clong.bean.T_MALL_SKU;
import jgsu.clong.mapper.ItemMapper;
import jgsu.clong.service.ItemServiceI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemServiceI {

    @Autowired
    ItemMapper itemMapper;
    @Override
    public DETAIL_T_MALL_SKU getSkuDetail(int sku_id) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put("sku_id", sku_id);
        DETAIL_T_MALL_SKU obj_sku = itemMapper.queryDetailSku(hashMap);
        return obj_sku;
    }

    @Override
    public List<T_MALL_SKU> getSkuListBySpu(int spu_id) {
        return itemMapper.querySkuListBySpu(spu_id);
    }
}
