package jgsu.clong.bean;

import java.util.List;

public class OBJECT_T_MALL_ATTR extends T_MALL_ATTR {

    //因为属性管理里面包含：属性名称和属性值在两个表中，所以使用这样的数据结构
    private List<T_MALL_VALUE> list_value;

    public List<T_MALL_VALUE> getList_value() {
        return list_value;
    }

    public void setList_value(List<T_MALL_VALUE> list_value) {
        this.list_value = list_value;
    }

    @Override
    public String toString() {
        return "OBJECT_T_MALL_ATTR{" +
                "list_value=" + list_value +
                '}';
    }
}
