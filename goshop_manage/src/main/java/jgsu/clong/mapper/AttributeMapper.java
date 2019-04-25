package jgsu.clong.mapper;

import jgsu.clong.bean.OBJECT_T_MALL_ATTR;
import jgsu.clong.bean.T_MALL_ATTR;
import jgsu.clong.bean.T_MALL_VALUE;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttributeMapper {

    //插入属性
    void insert_attr(@Param("flbh2") int flbh2, @Param("attr") OBJECT_T_MALL_ATTR attr);
    /*插入属性的值*/
    void insert_values(@Param("id") int id,@Param("list_value") List<T_MALL_VALUE> list_value);
    /*查询属性值*/
    List<OBJECT_T_MALL_ATTR> queryAttrList(int flbh2);
}
