package jgsu.clong.controller;


import jgsu.clong.bean.DETAIL_T_MALL_SKU;
import jgsu.clong.bean.MODEL_T_MALL_SKU_ATTR_VALUE;
import jgsu.clong.bean.OBJECT_T_MALL_SKU;
import jgsu.clong.bean.T_MALL_SKU;
import jgsu.clong.service.ItemServiceI;
import jgsu.clong.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ListController {

    @Autowired
    ListService listService;
    @Autowired
    ItemServiceI itemServiceI;

    @RequestMapping("get_list_by_attr")
    public String get_list_by_attr(MODEL_T_MALL_SKU_ATTR_VALUE list_attr, int flbh2, ModelMap map) {

        /*根据属性查询商品列表*/
        List<OBJECT_T_MALL_SKU> list_sku = listService.getSkuByAttr(flbh2,list_attr.getList_attr());
        map.put("list_sku",list_sku);
        return "sku_list";
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
