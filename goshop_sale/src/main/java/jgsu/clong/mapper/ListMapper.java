package jgsu.clong.mapper;

import jgsu.clong.bean.OBJECT_T_MALL_ATTR;
import jgsu.clong.bean.OBJECT_T_MALL_SKU;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ListMapper {
    List<OBJECT_T_MALL_ATTR> queryAttrList(int flbh2);

    List<OBJECT_T_MALL_SKU> querySkuList(int flbh2);

    List<OBJECT_T_MALL_SKU> quertSkuByAttr(Map<Object, Object> map);
}
