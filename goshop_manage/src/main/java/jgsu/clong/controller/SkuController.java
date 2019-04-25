package jgsu.clong.controller;

import jgsu.clong.bean.*;
import jgsu.clong.service.AttributeService;
import jgsu.clong.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SkuController {

    @Autowired
    SkuService skuService;
    @Autowired
    AttributeService attributeService;


    /*保存sku的相关属性，t_mall_sku和t_mall_sku_attr_value这两个表中*/
    @RequestMapping("save_sku")
    public ModelAndView save_sku(T_MALL_PRODUCT product, MODEL_T_MALL_SKU_ATTR_VALUE list_attr, T_MALL_SKU sku,ModelMap map) {

        skuService.save_sku(product, sku, list_attr.getList_attr());

        ModelAndView mv = new ModelAndView("redirect:goto_sku_add.do");

        mv.addObject("flbh1", product.getFlbh1());
        mv.addObject("flbh2",product.getFlbh2());
        return mv;
    }

    /*获得T_MALL_PRODUCT对应表的值，在商品下拉栏中显示*/
    @RequestMapping("getSpuList")
    @ResponseBody
    public List<T_MALL_PRODUCT> getSpuList(int pp_id, int flbh2, ModelMap map) {
        List<T_MALL_PRODUCT> list_spu = skuService.getSpuList(pp_id, flbh2);
        return list_spu;
    }

    //    跳转到skuadd的页面
    @RequestMapping("goto_sku_add")
    public String goto_sku_add(int flbh1, int flbh2, ModelMap map) {

//        获取到t_mall_attr的属行和t_mall_attr_value的值
        List<OBJECT_T_MALL_ATTR> attr_list = attributeService.get_attr(flbh2);
        map.put("flbh1", flbh1);
        map.put("flbh2", flbh2);
        map.put("attr_list", attr_list);
        System.out.println("attr_list" + attr_list);
        return "sku/skuAdd";
    }
}
