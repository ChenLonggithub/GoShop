package jgsu.clong.controller;

import jgsu.clong.bean.OBJECT_T_MALL_ATTR;
import jgsu.clong.bean.OBJECT_T_MALL_SKU;
import jgsu.clong.service.ListService;
import jgsu.clong.until.JedisGetCacheUtil;
import jgsu.clong.until.JedisPoolUtils;
import jgsu.clong.until.MyJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Controller
public class IndexController {

    @Autowired
    ListService listService;

    @RequestMapping("main")
    public String main(){
        return "main";
    }

    @RequestMapping("goto_list")
    public String goto_list(int flbh2, ModelMap map) {

        /*属性的集合*/
        List<OBJECT_T_MALL_ATTR> list_attr = listService.getAttrList(flbh2);

        /*查询商品列表*/
        List<OBJECT_T_MALL_SKU> list_sku = new ArrayList<OBJECT_T_MALL_SKU>();

        // 缓存检索
        String key = "class_2_" + flbh2;
        list_sku = JedisGetCacheUtil.getList(key, OBJECT_T_MALL_SKU.class);

        if (list_sku == null || list_sku.size() < 1) {
            // mysql检索
            list_sku = listService.get_sku(flbh2);

            // 将检索结果同步到redis
            JedisGetCacheUtil.setKey(key, list_sku);
        }


        map.put("list_attr", list_attr);
        map.put("list_sku", list_sku);
        map.put("flbh2", flbh2);

        return "list";
    }
}
