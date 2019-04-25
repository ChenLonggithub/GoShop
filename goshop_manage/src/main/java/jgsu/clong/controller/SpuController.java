package jgsu.clong.controller;

import jgsu.clong.bean.T_MALL_PRODUCT;
import jgsu.clong.service.SpuService;
import jgsu.clong.util.MyFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SpuController {

    @Autowired
    SpuService spuService;

    /*跳转到商品add页面*/
    @RequestMapping("goto_spu_add")
    public String goto_spu_add(ModelMap modelMap, T_MALL_PRODUCT spu){
        modelMap.put("spu",spu);
        return "spu/spu_add";
    }
    /*添加商品属性*/
    @RequestMapping("spu_add")
    public ModelAndView spu_add(@RequestParam("files") MultipartFile[] files, T_MALL_PRODUCT spu){
        //上传图片
        List<String> list_image = MyFileUpload.upload_image(files);
        //上传商品信息
        spuService.save_spu(list_image,spu);
        ModelAndView mv = new ModelAndView("redirect:/goto_spu_add.do");
        mv.addObject("flbh1",spu.getFlbh1());
        mv.addObject("flbh2",spu.getFlbh2());
        mv.addObject("pp_id",spu.getPp_id());
        return  mv;
    }
}
