package jgsu.clong.service;

import jgsu.clong.bean.T_MALL_SHOPPINGCAR;
import jgsu.clong.bean.T_MALL_USER_ACCOUNT;

import java.util.List;

public interface CartService {

    void add_cart(T_MALL_SHOPPINGCAR cart);

    void update_cart(T_MALL_SHOPPINGCAR cart);

    boolean if_cart_exists(T_MALL_SHOPPINGCAR cart);

    List<T_MALL_SHOPPINGCAR> get_list_cart_by_user(T_MALL_USER_ACCOUNT user);
}
