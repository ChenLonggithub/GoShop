package jgsu.clong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("goto_sku")
    public String goto_sku(){
        return "sku/index_sku";
    }

    /*跳转到商品属性页面*/
    @RequestMapping("goto_attr")
    public String goto_attr(){
        return "attr/index_attr";
    }

    /*跳转到spu商品管理页面*/
    @RequestMapping("goto_spu")
    public String goto_spu(){
        return "spu/spu";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }





}
