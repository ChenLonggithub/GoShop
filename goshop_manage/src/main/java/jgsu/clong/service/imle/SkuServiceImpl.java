package jgsu.clong.service.imle;

import jgsu.clong.bean.MODEL_T_MALL_ATTR;
import jgsu.clong.bean.T_MALL_PRODUCT;
import jgsu.clong.bean.T_MALL_SKU;
import jgsu.clong.bean.T_MALL_SKU_ATTR_VALUE;
import jgsu.clong.mapper.SkuMapper;
import jgsu.clong.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    SkuMapper skuMapper;
    @Override
    public List<T_MALL_PRODUCT> getSpuList(int pp_id, int flbh2) {
        Map<Object,Object> map = new HashMap<>();
        map.put("pp_id",pp_id);
        map.put("flbh2",flbh2);
        return skuMapper.querySpu(map);
    }

    @Override
    public void save_sku(T_MALL_PRODUCT product, T_MALL_SKU sku, List<T_MALL_SKU_ATTR_VALUE> list_attr) {
        /*插入sku,在t_nall_sku表中增加数据，返回主键*/
        sku.setShp_id(product.getId());
        skuMapper.insert_sku(sku);

        // 根据sku主键批量保存属性关联表，t_mall_sku_attr_value
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("shp_id",product.getId());
        map.put("sku_id",sku.getId());
        map.put("list_value",list_attr);
        skuMapper.insert_sku_value(map);
    }
}
