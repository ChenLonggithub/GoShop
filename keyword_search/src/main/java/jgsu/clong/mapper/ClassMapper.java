package jgsu.clong.mapper;

import java.util.List;

import jgsu.clong.bean.KEYWORDS_T_MALL_SKU;
import jgsu.clong.bean.OBJECT_T_MALL_SKU;
import jgsu.clong.bean.OBJECT_T_MALL_SKU;

public interface ClassMapper {
	List<KEYWORDS_T_MALL_SKU> select_list_by_flbh2(int flbh2);
}
