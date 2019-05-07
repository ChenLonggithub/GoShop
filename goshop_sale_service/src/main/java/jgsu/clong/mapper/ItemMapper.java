package jgsu.clong.mapper;

import jgsu.clong.bean.DETAIL_T_MALL_SKU;
import jgsu.clong.bean.T_MALL_SKU;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ItemMapper {

    DETAIL_T_MALL_SKU queryDetailSku(HashMap<Object, Object> hashMap);

    List<T_MALL_SKU> querySkuListBySpu(int spu_id);
}
