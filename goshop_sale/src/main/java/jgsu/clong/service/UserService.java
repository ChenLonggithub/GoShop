package jgsu.clong.service;

import jgsu.clong.bean.T_MALL_USER_ACCOUNT;

public interface UserService {
    T_MALL_USER_ACCOUNT queryUser(T_MALL_USER_ACCOUNT user);

    T_MALL_USER_ACCOUNT select_user(T_MALL_USER_ACCOUNT user);
}
