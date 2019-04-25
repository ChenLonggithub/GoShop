package jgsu.clong.mapper;

import jgsu.clong.bean.T_MALL_PRODUCT;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface SpuMapper {
    /*插入Spu信息*/
    void insert_spu(T_MALL_PRODUCT sku);
    /*插入Spu的图片*/
    void insert_image(Map<Object, Object> map);
}
