package jgsu.clong.server;

import jgsu.clong.bean.T_MALL_ADDRESS;
import jgsu.clong.bean.T_MALL_USER_ACCOUNT;
import jgsu.clong.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressServerImpl implements AddressServer {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public List<T_MALL_ADDRESS> get_addresses(T_MALL_USER_ACCOUNT user) {
        List<T_MALL_ADDRESS> list_address = addressMapper.select_addresses(user);
        return list_address;
    }

    @Override
    public T_MALL_ADDRESS get_address(int address_id) {
        T_MALL_ADDRESS address = addressMapper.select_address(address_id);
        return address;
    }
}
