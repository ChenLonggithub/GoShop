package jgsu.clong.controller;

import jgsu.clong.bean.OBJECT_T_MALL_ATTR;
import jgsu.clong.bean.OBJECT_T_MALL_SKU;
import jgsu.clong.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

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

        //查询属性集合列表
        List<OBJECT_T_MALL_ATTR> list_attr = listService.getAttrList(flbh2);
        /*查询商品列表*/
        List<OBJECT_T_MALL_SKU> list_sku = listService.get_sku(flbh2);

        map.put("list_attr", list_attr);
        map.put("list_sku", list_sku);
        map.put("flbh2", flbh2);

        return "list";
    }
}
