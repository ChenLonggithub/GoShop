package jgsu.clong.service;

import jgsu.clong.bean.OBJECT_T_MALL_ATTR;

import java.util.List;

public interface AttributeService {
    /*插入属性*/
    void insert_attr(int flbh2, List<OBJECT_T_MALL_ATTR> list_attr);

    List<OBJECT_T_MALL_ATTR> get_attr(int flbh2);
}
