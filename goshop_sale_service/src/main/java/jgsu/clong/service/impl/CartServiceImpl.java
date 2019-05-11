package jgsu.clong.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import jgsu.clong.bean.T_MALL_SHOPPINGCAR;
import jgsu.clong.bean.T_MALL_USER_ACCOUNT;
import jgsu.clong.mapper.CartMapper;
import jgsu.clong.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {


    @Reference
    CartMapper cartMapper;

    @Override
    public void add_cart(T_MALL_SHOPPINGCAR cart) {
        cartMapper.insert_cart(cart);

    }

    @Override
    public void update_cart(T_MALL_SHOPPINGCAR cart) {
        cartMapper.update_cart(cart);
    }

    @Override
    public boolean if_cart_exists(T_MALL_SHOPPINGCAR cart) {
        boolean b = false;
        int i = cartMapper.select_cart_exists(cart);
        if (i > 0) {
            b = true;
        }
        return b;
    }

    @Override
    public List<T_MALL_SHOPPINGCAR> get_list_cart_by_user(T_MALL_USER_ACCOUNT user) {
        return cartMapper.select_list_cart_by_user(user.getId());
    }

}
