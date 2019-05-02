package jgsu.clong.controller;

import jgsu.clong.bean.*;
import jgsu.clong.exception.OverSaleException;
import jgsu.clong.server.AddressServer;
import jgsu.clong.service.CartService;
import jgsu.clong.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import javax.swing.undo.AbstractUndoableEdit;
import java.math.BigDecimal;
import java.util.*;

@Controller
@SessionAttributes("order")
public class OrderController {

    @Autowired
    AddressServer addressServer;

    @Autowired
    CartService cartService;

    @Autowired
    OrderService orderService;

    @RequestMapping("goto_checkOrder")
    public String goto_checkOrder(HttpSession session, ModelMap map) {

        List<T_MALL_SHOPPINGCAR> list_cart = new ArrayList<T_MALL_SHOPPINGCAR>();

        T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");
        if (user == null) {
            return "redirect:goto_loginOrder.do";
        } else {
            // session购物车列表
            list_cart = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");// 数据库

            OBJECT_T_MALL_ORDER order = new OBJECT_T_MALL_ORDER();// 订单对象
            order.setYh_id(user.getId());
            order.setJdh(1);
            order.setZje(get_sum(list_cart));

            // 结算业务
            // 根据购物车的选中状态，获得库存地址信息
            Set<String> set_kcdz = new HashSet<String>();
            for (int i = 0; i < list_cart.size(); i++) {
                if (list_cart.get(i).getShfxz().equals("1")) {
                    // 去重
                    set_kcdz.add(list_cart.get(i).getKcdz());
                }
            }

            // 根据库存地址封装送货清单
            List<OBJECT_T_MALL_FLOW> list_flow = new ArrayList<OBJECT_T_MALL_FLOW>();

            Iterator<String> iterator = set_kcdz.iterator();
            while (iterator.hasNext()) {
                String kcdz = iterator.next();
                // 根据库存地址生成送货清单
                OBJECT_T_MALL_FLOW flow = new OBJECT_T_MALL_FLOW();// 送货清单对象
                flow.setMqdd("商品未出库");
                flow.setPsfsh("飞鼠快递");
                flow.setYh_id(user.getId());
                List<T_MALL_ORDER_INFO> list_info = new ArrayList<T_MALL_ORDER_INFO>();

                // 循环购物车，将购物车对象转化成订单信息
                for (int i = 0; i < list_cart.size(); i++) {
                    if (list_cart.get(i).getShfxz().equals("1") && list_cart.get(i).getKcdz().equals(kcdz)) {

                        T_MALL_SHOPPINGCAR cart = list_cart.get(i);
                        T_MALL_ORDER_INFO info = new T_MALL_ORDER_INFO();

                        // 将购物车转为订单信息
                        info.setGwch_id(cart.getId());
                        info.setShp_tp(cart.getShp_tp());
                        info.setSku_id(cart.getSku_id());
                        info.setSku_jg(cart.getSku_jg());
                        info.setSku_kcdz(kcdz);
                        info.setSku_mch(cart.getSku_mch());
                        info.setSku_shl(cart.getTjshl());
                        list_info.add(info);
                    }
                }
                flow.setList_info(list_info);
                // 将送货清单放入送货清单 集合
                list_flow.add(flow);
            }
            // 送货清单放入主订单
            order.setList_flow(list_flow);// 内存中的对象，游离状态对象
            try {
                List<T_MALL_ADDRESS> list_address = addressServer.get_addresses(user);
                map.put("list_address", list_address);
            } catch (Exception e) {
                e.printStackTrace();
                // 处理用户系统调用异常
                return "redirect:/orderErr.do";
            }
            map.put("order", order);
        }

        return "check_order_page";
    }

    @RequestMapping("save_order")
    public String save_order(HttpSession session, @ModelAttribute("order") OBJECT_T_MALL_ORDER order,
                             T_MALL_ADDRESS address) {
        T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");

        // 获取地址信息
        T_MALL_ADDRESS get_address = addressServer.get_address(address.getId());

        // 调用保存订单的业务
        orderService.save_order(get_address, order);

        // 重新同步session
        session.setAttribute("list_cart_session", cartService.get_list_cart_by_user(user));

        // 重定向到支付服务，传入订单号和交易金额
        //return "pay";
        return "redirect:goto_pay.do";
    }

    @RequestMapping("goto_pay")
    public String goto_pay() {
        // 伪支付服务
        return "pay_0";
    }

    @RequestMapping("realPay_success")
    public String realPay_success(@ModelAttribute("order") OBJECT_T_MALL_ORDER order) {
        // 支付成功,真实调用支付宝
        try {
            orderService.pay_success(order);
        } catch (OverSaleException e) {

            e.printStackTrace();
            return "success";
        }
        return "success";
    }

    @RequestMapping("pay_success")
    public String pay_success(@ModelAttribute("order") OBJECT_T_MALL_ORDER order) {
        // 支付成功
        try {
            orderService.pay_success(order);
        } catch (OverSaleException e) {
            e.printStackTrace();
            return "redirect:/orderFaile.do";
        }
        return "redirect:/order_success.do";
    }

    @RequestMapping("order_success")
    public String order_success() {
        return "orderSuccess";
    }

    @RequestMapping("orderFaile")
    public String orderFaile() {
        return "orderFaile";
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
}
