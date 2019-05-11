package jgsu.clong.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import jgsu.clong.bean.OBJECT_T_MALL_ATTR;
import jgsu.clong.bean.OBJECT_T_MALL_SKU;
import jgsu.clong.bean.T_MALL_SKU_ATTR_VALUE;
import jgsu.clong.mapper.ListMapper;
import jgsu.clong.service.ListService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ListServiceImpl implements ListService {

    @Reference
    ListMapper listMapper;

    @Override
    public List<OBJECT_T_MALL_ATTR> getAttrList(int flbh2) {
        return listMapper.queryAttrList(flbh2);
    }

    @Override
    public List<OBJECT_T_MALL_SKU> get_sku(int flbh2) {
        return listMapper.querySkuList(flbh2);
    }

    @Override
    public List<OBJECT_T_MALL_SKU> getSkuByAttr(int flbh2, List<T_MALL_SKU_ATTR_VALUE> list_attr) {

        StringBuffer subSql = new StringBuffer("");

        // 根据属性集合动态拼接条件过滤的sql语句
        subSql.append(" and sku.id in ( select sku0.sku_id from ");

        if (list_attr != null && list_attr.size() > 0) {
            for (int i = 0; i < list_attr.size(); i++) {
                subSql.append(
                        " (select sku_id from t_mall_sku_attr_value where shxm_id = " + list_attr.get(i).getShxm_id()
                                + " and shxzh_id = " + list_attr.get(i).getShxzh_id() + ") sku" + i + " ");
                if ((i + 1) < list_attr.size() && list_attr.size() > 1) {
                    subSql.append(" , ");
                }
            }

            if (list_attr.size() > 1) {
                subSql.append(" where ");

                for (int i = 0; i < list_attr.size(); i++) {
                    if ((i + 1) < list_attr.size()) {
                        subSql.append(" sku" + i + ".sku_id=" + "sku" + (i + 1) + ".sku_id");

                        if (list_attr.size() > 2 && i < (list_attr.size() - 2)) {
                            subSql.append(" and ");
                        }
                    }
                }
            }

        }

        subSql.append(" ) ");

        Map<Object, Object> map = new HashMap<>();
        map.put("subSql", subSql.toString());
        map.put("flbh2", flbh2);
        return listMapper.quertSkuByAttr(map);
    }
}
