package jgsu.clong.mapper;

import jgsu.clong.bean.T_MALL_ADDRESS;
import jgsu.clong.bean.T_MALL_USER_ACCOUNT;

import java.util.List;

public interface AddressMapper {
    List<T_MALL_ADDRESS> select_addresses(T_MALL_USER_ACCOUNT user);

    T_MALL_ADDRESS select_address(int address_id);
}
