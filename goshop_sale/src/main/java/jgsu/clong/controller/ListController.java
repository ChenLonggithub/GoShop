package jgsu.clong.controller;


import jgsu.clong.bean.*;
import jgsu.clong.service.ItemServiceI;
import jgsu.clong.service.ListService;
import jgsu.clong.until.JedisGetCacheUtil;
import jgsu.clong.until.MyHttpGetUtil;
import jgsu.clong.until.MyJsonUtil;
import jgsu.clong.until.MyPropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListController {

    @Autowired
    ListService listService;
    @Autowired
    ItemServiceI itemServiceI;

    @RequestMapping("keywords")
    public String keywords(String keywords, ModelMap map) {

        // 调用keywords的关键词查询接口
        String doGet = "";
        String keywords_url = MyPropertiesUtil.getMyProperty("ws.properties", "keywords_url") + "?keywords=" + keywords;
        try {
            doGet = MyHttpGetUtil.doGet(keywords_url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<KEYWORDS_T_MALL_SKU> list_sku = MyJsonUtil.json_to_list(doGet, KEYWORDS_T_MALL_SKU.class);
        map.put("list_sku", list_sku);
        map.put("keywords", keywords);
        return "search";
    }

    @RequestMapping("get_list_by_attr")
    public String get_list_by_attr(MODEL_T_MALL_SKU_ATTR_VALUE list_attr, int flbh2, ModelMap map) {
// 根据属性查询列表的业务
        List<OBJECT_T_MALL_SKU> list_sku = new ArrayList<OBJECT_T_MALL_SKU>();
        // 缓存检索
        List<T_MALL_SKU_ATTR_VALUE> list_attr2 = list_attr.getList_attr();
        String[] keys = new String[list_attr2.size()];
        for (int i = 0; i < list_attr2.size(); i++) {
            keys[i] = "attr_" + flbh2 + "_" + list_attr2.get(i).getShxm_id() + "_" + list_attr2.get(i).getShxzh_id();
        }

        // 交叉检索，返回生成的key
        String interKeys = JedisGetCacheUtil.interKeys(keys);
        list_sku = JedisGetCacheUtil.getList(interKeys, OBJECT_T_MALL_SKU.class);

        if (list_sku == null || list_sku.size() < 1) {
            // 当前交叉检索结果
            list_sku = listService.getSkuByAttr(flbh2, list_attr.getList_attr());

            // 同步redis
            for (int i = 0; i < list_attr2.size(); i++) {
                String key = keys[i];// attr_28_1_2

                // 判断redis中是否存在
                boolean if_key = JedisGetCacheUtil.if_key(key);

                if (!if_key) {
                    // 根据属性id，查询出属性值集合
                    // 循环属性值，拼接出attr的key
                    // key对应的sku集合
                    List<T_MALL_SKU_ATTR_VALUE> list_attr_for_redis = new ArrayList<T_MALL_SKU_ATTR_VALUE>();
                    List<OBJECT_T_MALL_SKU> list_sku_for_redis = new ArrayList<OBJECT_T_MALL_SKU>();
                    T_MALL_SKU_ATTR_VALUE attr_value = new T_MALL_SKU_ATTR_VALUE();
                    attr_value.setShxm_id(list_attr2.get(i).getShxm_id());
                    attr_value.setShxzh_id(list_attr2.get(i).getShxzh_id());
                    list_attr_for_redis.add(attr_value);
                    list_sku_for_redis = listService.getSkuByAttr(flbh2, list_attr_for_redis);

                    // 再根据属性和属性值可以查询 出对应的sku集合
                    // attr的可以和sku的集合循环 插入到redis
                    JedisGetCacheUtil.setKey(key, list_sku_for_redis);
                }

            }
        }

        map.put("list_sku", list_sku);
        return "skuList";
    }

    @RequestMapping("goto_sku_detail")
    public String goto_sku_detail(int sku_id, int spu_id, ModelMap map) {

        // 查询商品详细信息对象
        DETAIL_T_MALL_SKU obj_sku = itemServiceI.getSkuDetail(sku_id);

        // 查询同spu下的相关的其他sku信息
        List<T_MALL_SKU> list_sku = itemServiceI.getSkuListBySpu(spu_id);

        // 查询商品销售属性列表
        // 颜色列表
        // 版本列表
        map.put("obj_sku", obj_sku);
        map.put("list_sku", list_sku);
        return "sku_detail";
    }
}
