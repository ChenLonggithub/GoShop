package jgsu.clong.controller;

import jgsu.clong.bean.T_MALL_SHOPPINGCAR;
import jgsu.clong.bean.T_MALL_USER_ACCOUNT;
import jgsu.clong.service.CartService;
import jgsu.clong.until.MyJsonUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping("change_shfxz")
    public String change_shfxz(HttpServletResponse response, HttpSession session,
                               @CookieValue(value = "list_cart_cookie", required = false) String list_cart_cookie, T_MALL_SHOPPINGCAR cart,
                               ModelMap map) {
        List<T_MALL_SHOPPINGCAR> list_cart = new ArrayList<T_MALL_SHOPPINGCAR>();
        T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");
        // 购物车修改业务
        if (user == null) {
            // 修改cookie
            list_cart = MyJsonUtil.json_to_list(list_cart_cookie, T_MALL_SHOPPINGCAR.class);
        } else {
            // 修改db
            list_cart = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");// 数据库
        }

        for (int i = 0; i < list_cart.size(); i++) {
            if (list_cart.get(i).getSku_id() == cart.getSku_id()) {
                list_cart.get(i).setShfxz(cart.getShfxz());
                if (user == null) {
                    // 覆盖cookie
                    Cookie cookie = new Cookie("list_cart_cookie", MyJsonUtil.list_to_json(list_cart));
                    cookie.setMaxAge(60 * 60 * 24);
                    response.addCookie(cookie);
                } else {
                    cartService.update_cart(list_cart.get(i));
                }
            }
        }
        map.put("sum", get_sum(list_cart));
        map.put("list_cart", list_cart);
        return "common/cartListInner";
    }

    private BigDecimal get_sum(List<T_MALL_SHOPPINGCAR> list_cart) {
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < list_cart.size(); i++) {
            if (list_cart.get(i).getShfxz().equals("1")) {
                sum = sum.add(new BigDecimal(list_cart.get(i).getHj() + ""));
            }
        }
        return sum;
    }

    @RequestMapping("goto_cartList")
    public String goto_cartList(HttpSession session,
                                 @CookieValue(value = "list_cart_cookie", required = false) String list_cart_cookie, ModelMap map) {
        List<T_MALL_SHOPPINGCAR> list_cart = new ArrayList<T_MALL_SHOPPINGCAR>();
        T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");

        // 通过cookie或者session获取购物车数据
        if (user == null) {
            list_cart = MyJsonUtil.json_to_list(list_cart_cookie, T_MALL_SHOPPINGCAR.class);

        } else {
            list_cart = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");// 数据库

        }

        map.put("list_cart", list_cart);
        map.put("sum", get_sum(list_cart));
        return "cartList";
    }

    @RequestMapping("queryCart")
    public String queryCart(HttpSession session,
                           @CookieValue(value = "list_cart_cookie", required = false) String list_cart_cookie, ModelMap map) {
        List<T_MALL_SHOPPINGCAR> list_cart = new ArrayList<T_MALL_SHOPPINGCAR>();
        T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");

        // 通过cookie或者session获取购物车数据
        if (user == null) {
            list_cart = MyJsonUtil.json_to_list(list_cart_cookie, T_MALL_SHOPPINGCAR.class);

        } else {
            list_cart = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");// 数据库

        }

        map.put("list_cart", list_cart);
        return "common/miniCartList";
    }

    @RequestMapping("add_cart")
    public String add_cart(HttpSession session, HttpServletResponse response,
                           @CookieValue(value = "list_cart_cookie", required = false) String list_cart_cookie, T_MALL_SHOPPINGCAR cart,
                           ModelMap map) {
        List<T_MALL_SHOPPINGCAR> list_cart = new ArrayList<T_MALL_SHOPPINGCAR>();
        int yh_id = cart.getYh_id();

        // 添加购物车操作
        if (yh_id == 0) {
            // 用户未登陆，操作cookie
            if (StringUtils.isBlank(list_cart_cookie)) {
                list_cart.add(cart);
            } else {
                list_cart = MyJsonUtil.json_to_list(list_cart_cookie, T_MALL_SHOPPINGCAR.class);
                // 判断是否重复
                boolean b = if_new_cart(list_cart, cart);
                if (b) {
                    // 新车，添加
                    list_cart.add(cart);
                } else {
                    // 老车，更新
                    for (int i = 0; i < list_cart.size(); i++) {
                        if (list_cart.get(i).getSku_id() == cart.getSku_id()) {
                            list_cart.get(i).setTjshl(list_cart.get(i).getTjshl() + cart.getTjshl());
                            list_cart.get(i).setHj(list_cart.get(i).getTjshl() * list_cart.get(i).getSku_jg());
                        }
                    }
                }
            }
            // 覆盖cookie
            Cookie cookie = new Cookie("list_cart_cookie", MyJsonUtil.list_to_json(list_cart));
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);
        } else {
            list_cart = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");// 数据库
            // 用户已登陆，操作db

            boolean b = cartService.if_cart_exists(cart);

            if (!b) {
                cartService.add_cart(cart);
                if (list_cart == null || list_cart.isEmpty()) {
                    list_cart = new ArrayList<T_MALL_SHOPPINGCAR>();
                    list_cart.add(cart);
                    session.setAttribute("list_cart_session", list_cart);
                } else {
                    list_cart.add(cart);
                }
            } else {
                for (int i = 0; i < list_cart.size(); i++) {
                    if (list_cart.get(i).getSku_id() == cart.getSku_id()) {
                        list_cart.get(i).setTjshl(list_cart.get(i).getTjshl() + cart.getTjshl());
                        list_cart.get(i).setHj(list_cart.get(i).getTjshl() * list_cart.get(i).getSku_jg());
                        // 老车，更新
                        cartService.update_cart(list_cart.get(i));
                    }
                }
            }
        }

        return "redirect:/cart_success.do";

    }

    private boolean if_new_cart(List<T_MALL_SHOPPINGCAR> list_cart, T_MALL_SHOPPINGCAR cart) {
        boolean b = true;
        for (int i = 0; i < list_cart.size(); i++) {
            if (list_cart.get(i).getSku_id() == cart.getSku_id()) {
                b = false;
            }
        }
        return b;
    }

    @RequestMapping("cart_success")
    public String cart_success(ModelMap map) {

        return "cartSuccess";
    }

}
