package jgsu.clong.service.imle;

import jgsu.clong.bean.OBJECT_T_MALL_ATTR;
import jgsu.clong.bean.T_MALL_ATTR;
import jgsu.clong.bean.T_MALL_VALUE;
import jgsu.clong.mapper.AttributeMapper;
import jgsu.clong.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    AttributeMapper attributeMapper;

    @Override
    public void insert_attr(int flbh2, List<OBJECT_T_MALL_ATTR> list_attr) {

        /*循环list_attr，分别获得每组属性值*/
        for (int i = 0; i < list_attr.size(); i++) {
            // 插入属性，返回主键
            OBJECT_T_MALL_ATTR attr = list_attr.get(i);
            attributeMapper.insert_attr(flbh2, attr);

            // 根据获得返回主键批量插入属性值
            attributeMapper.insert_values(attr.getId(), attr.getList_value());
        }
    }

    @Override
    public List<OBJECT_T_MALL_ATTR> get_attr(int flbh2) {

        return attributeMapper.queryAttrList(flbh2);
    }

}
