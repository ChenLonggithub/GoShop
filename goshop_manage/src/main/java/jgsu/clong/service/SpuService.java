package jgsu.clong.service;

import jgsu.clong.bean.T_MALL_PRODUCT;

import java.util.List;

public interface SpuService {
    void save_spu(List<String> list_image, T_MALL_PRODUCT spu);
}
