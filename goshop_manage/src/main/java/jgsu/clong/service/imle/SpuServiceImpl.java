package jgsu.clong.service.imle;

import jgsu.clong.bean.T_MALL_PRODUCT;
import jgsu.clong.mapper.SpuMapper;
import jgsu.clong.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpuServiceImpl implements SpuService {
    @Autowired
    SpuMapper spuMapper;
    @Override
    public void save_spu(List<String> list_image, T_MALL_PRODUCT spu) {

        //插入图片名称,spu的ID值会返回回来
        spu.setShp_tp(list_image.get(0));
        spuMapper.insert_spu(spu);

        //批量插入图片
        Map<Object,Object> map = new HashMap<Object,Object>();
        map.put("shp_id",spu.getId());
        map.put("list_image",list_image);
        spuMapper.insert_image(map);
    }
}
