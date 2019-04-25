package jgsu.clong.controller;

import jgsu.clong.bean.T_MALL_SHOPPINGCAR;
import jgsu.clong.bean.T_MALL_USER_ACCOUNT;
import jgsu.clong.server.LoginServer;
import jgsu.clong.service.CartService;
import jgsu.clong.service.UserService;
import jgsu.clong.until.MyJsonUtil;
import jgsu.clong.until.MyPropertiesUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    CartService cartService;

    @Autowired
    LoginServer loginServer;

    @RequestMapping("goto_logout")
    public String goto_logout(HttpSession session){
        session.invalidate();
        return "redirect:/goto_login.do";
    }

    @RequestMapping("goto_login")
    public String login(){
        return "login";
    }

    @RequestMapping("goto_loginOrder")
    public String goto_loginOrder(){
        return "loginOrder";
    }

    @RequestMapping("goto_register")
    public String goto_register(){
        return "register";
    }

    @RequestMapping("login")
    public String login(@RequestParam(value = "redirect", required = false) String redirect, @CookieValue(value = "list_cart_cookie", required = false) String list_cart_cookie,
                        HttpServletResponse response, HttpSession session, T_MALL_USER_ACCOUNT user, HttpServletRequest request,
                        ModelMap map) {

        // 登陆，远程用户认证接口
        //T_MALL_USER_ACCOUNT select_user = userService.select_user(user);

        /*创建工厂Bean*/
/*        JaxWsProxyFactoryBean jaxWs = new JaxWsProxyFactoryBean();
        jaxWs.setAddress(MyPropertiesUtil.getMyProperty("ws.properties","login_url"));
        jaxWs.setServiceClass(LoginServer.class);

        LoginServer create = (LoginServer) jaxWs.create();

        String login = create.login(user);*/
        final String login = loginServer.login(user);

        final T_MALL_USER_ACCOUNT db_user = MyJsonUtil.json_to_object(login, T_MALL_USER_ACCOUNT.class);
        if (db_user == null) {
            return "redirect:/goto_login.do";
        } else {
            session.setAttribute("user", db_user);

            // 在客户端存储用户个性化信息，方便用户下次再访问网站时使用
            try {
                Cookie cookie = new Cookie("yh_mch", URLEncoder.encode(db_user.getYh_mch(), "utf-8"));
                // cookie.setPath("/");
                cookie.setMaxAge(60 * 60 * 24);
                response.addCookie(cookie);

                Cookie cookie2 = new Cookie("yh_nch", URLEncoder.encode("大哥", "utf-8"));
                // cookie.setPath("/");
                cookie2.setMaxAge(60 * 60 * 24);
                response.addCookie(cookie2);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            // 同步购物车数据
            combine_cart(db_user, response, session, list_cart_cookie);

        }

        if(StringUtils.isBlank(redirect)){
            return "redirect:/main.do";
        }else{
            return "redirect:/"+redirect;
        }
    }

    private void combine_cart(T_MALL_USER_ACCOUNT user, HttpServletResponse response, HttpSession session,
                              String list_cart_cookie) {
        List<T_MALL_SHOPPINGCAR> list_cart = new ArrayList<T_MALL_SHOPPINGCAR>();

        if (StringUtils.isBlank(list_cart_cookie)) {
            //
        } else {
            // 判断db是否为空
            List<T_MALL_SHOPPINGCAR> list_cart_db = cartService.get_list_cart_by_user(user);
            list_cart = MyJsonUtil.json_to_list(list_cart_cookie, T_MALL_SHOPPINGCAR.class);

            for (int i = 0; i < list_cart.size(); i++) {
                T_MALL_SHOPPINGCAR cart = list_cart.get(i);
                cart.setYh_id(user.getId());
                boolean b = cartService.if_cart_exists(list_cart.get(i));

                if (b) {
                    // 更新
                    for (int j = 0; j < list_cart_db.size(); j++) {
                        if (cart.getSku_id() == list_cart_db.get(j).getSku_id()) {
                            cart.setTjshl(cart.getTjshl() + list_cart_db.get(j).getTjshl());
                            cart.setHj(cart.getTjshl() * cart.getSku_jg());
                            // 老车，更新
                            cartService.update_cart(cart);
                        }
                    }
                } else {
                    // 添加
                    cartService.add_cart(cart);
                }
            }
        }
        // 同步session，清空cookie
        session.setAttribute("list_cart_session", cartService.get_list_cart_by_user(user));
        response.addCookie(new Cookie("list_cart_cookie", ""));

        //
        // if (list_cart_db == null || list_cart_db.size() == 0) {
        // for (int i = 0; i < list_cart.size(); i++) {
        // list_cart.get(i).setYh_id(user.getId());
        // cartServiceInf.add_cart(list_cart.get(i));
        // }
        // } else {
        // for (int i = 0; i < list_cart.size(); i++) {
        //
        // boolean b = if_new_cart(list_cart_db, list_cart.get(i));
        //
        // if (b) {
        // list_cart.get(i).setYh_id(user.getId());
        // cartServiceInf.add_cart(list_cart.get(i));
        // } else {
        // for (int j = 0; j < list_cart_db.size(); j++) {
        // if (list_cart.get(j).getSku_id() ==
        // list_cart_db.get(j).getSku_id()) {
        // list_cart.get(j).setTjshl(list_cart.get(j).getTjshl() +
        // list_cart_db.get(j).getTjshl());
        // list_cart.get(j).setHj(list_cart.get(j).getTjshl() *
        // list_cart.get(j).getSku_jg());
        // // 老车，更新
        // cartServiceInf.update_cart(list_cart.get(j));
        // }
        // }
        // }
        // }
        // }
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

}
