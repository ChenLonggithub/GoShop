package jgsu.clong.controller;

import jgsu.clong.bean.MODEL_T_MALL_ATTR;
import jgsu.clong.bean.OBJECT_T_MALL_ATTR;
import jgsu.clong.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AttrController {

    @Autowired
    AttributeService attributeService;

    /**
     * 获得商品的属性值，将查询的数据封装到一个OBJECT_T_MALL_ATTR集合中，
     * @param flbh2
     * @param map
     * @return
     */
    @RequestMapping("get_attr")
    public String get_attr(int flbh2, ModelMap map) {
        List<OBJECT_T_MALL_ATTR> list_attr = attributeService.get_attr(flbh2);
        map.put("flbh2", flbh2);
        map.put("list_attr",list_attr);
        return "attr/attr_list";
    }

    @RequestMapping("goto_attr_add")
    public String goto_attr_add(int flbh2, ModelMap map) {
        map.put("flbh2", flbh2);
        return "attr/attr_add";
    }

    /**
     * 方法将页面获取到的商品属性和属性值参数，插入到数据库中
     * 获取参数是对象的同步表单参数提交，需要封装数据，确保有setter方法才可以封装到参数，
     *
     * 这里注意，表单的数据包括两个表的值，一个是 t_mall_attr,另一个是t_mall_value，所以要写
     * 一个包装类OBJECT_MALL_ATTR 来继承 t_mall_attr,和一个list<T_MALL_VALUE>集合 的value属性
     * @param flbh2
     * @param list_attr
     * @return
     */
    @RequestMapping("attr_add")
    public ModelAndView attr_add(int flbh2, MODEL_T_MALL_ATTR list_attr) {

        /*插入数据*/
        attributeService.insert_attr(flbh2, list_attr.getList_attr());
        /*页面跳转*/
        ModelAndView mv = new ModelAndView("redirect:/goto_attr_add.do");
        /*。*/
        mv.addObject("flbh2", flbh2);

        return mv;
    }
}
