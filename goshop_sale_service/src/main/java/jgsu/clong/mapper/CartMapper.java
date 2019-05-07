package jgsu.clong.mapper;

import jgsu.clong.bean.T_MALL_SHOPPINGCAR;

import java.util.List;

public interface CartMapper {
    void insert_cart(T_MALL_SHOPPINGCAR cart);

    void update_cart(T_MALL_SHOPPINGCAR cart);

    int select_cart_exists(T_MALL_SHOPPINGCAR cart);

    List<T_MALL_SHOPPINGCAR> select_list_cart_by_user(int id);
}
