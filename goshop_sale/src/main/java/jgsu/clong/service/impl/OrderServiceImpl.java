package jgsu.clong.service.impl;

import jgsu.clong.bean.OBJECT_T_MALL_FLOW;
import jgsu.clong.bean.OBJECT_T_MALL_ORDER;
import jgsu.clong.bean.T_MALL_ADDRESS;
import jgsu.clong.bean.T_MALL_ORDER_INFO;
import jgsu.clong.mapper.OrderMapper;
import jgsu.clong.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Override
    public void save_order(T_MALL_ADDRESS get_address, OBJECT_T_MALL_ORDER order) {
        List<Integer> list_id = new ArrayList<Integer>();
        // TODO Auto-generated method stub
        // 保存订单
        Map<Object, Object> map_order = new HashMap<Object, Object>();
        map_order.put("order", order);
        map_order.put("address", get_address);
        orderMapper.insert_order(map_order);

        List<OBJECT_T_MALL_FLOW> list_flow = order.getList_flow();
        for (int i = 0; i < list_flow.size(); i++) {
            // 保存物流
            OBJECT_T_MALL_FLOW flow = list_flow.get(i);
            flow.setMdd(get_address.getYh_dz());
            Map<Object, Object> map_flow = new HashMap<Object, Object>();
            map_flow.put("flow", flow);
            map_flow.put("dd_id", order.getId());
            orderMapper.insert_flow(map_flow);

            // 保存订单信息
            List<T_MALL_ORDER_INFO> list_info = flow.getList_info();
            Map<Object, Object> map_info = new HashMap<Object, Object>();
            map_info.put("list_info", list_info);
            map_info.put("dd_id", order.getId());
            map_info.put("flow_id", flow.getId());
            orderMapper.insert_infos(map_info);

            for (int j = 0; j < list_info.size(); j++) {
                list_id.add(list_info.get(j).getGwch_id());
            }
        }

        // 删除已经生成订单的购物车对象
        Map<Object, Object> map_cart = new HashMap<Object, Object>();
        map_cart.put("list_id", list_id);
        orderMapper.delete_carts(map_cart);
    }

    @Override
    public void pay_success(OBJECT_T_MALL_ORDER order) throws OverSaleException {

        // 修改订单状态，已支付

        // 修改订单信息

        // 修改物流信息
        List<OBJECT_T_MALL_FLOW> list_flow = order.getList_flow();
        for (int i = 0; i < list_flow.size(); i++) {
            OBJECT_T_MALL_FLOW flow = list_flow.get(i);
            // 修改物流的业务

            List<T_MALL_ORDER_INFO> list_info = flow.getList_info();
            // 修改sku数据量和销量等信息
            for (int j = 0; j < list_info.size(); j++) {
                T_MALL_ORDER_INFO info = list_info.get(j);

                // 查询库存的业务
                long kc = 0;
                // 判断库存警戒线
                long count = 0;
                if (count == 0) {
                    kc = 1;// 执行锁sql
                } else {
                    kc = 1;// 执行不锁sql
                }
                if (kc > info.getSku_shl()) {// 先确定kc大于购买数量
                    // 对kc进行修改
                } else {
                    throw new OverSaleException("over sale");
                }
            }

        }

        // 修改订单状态，出库

    }

}
