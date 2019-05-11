package jgsu.clong.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import jgsu.clong.bean.T_MALL_USER_ACCOUNT;
import jgsu.clong.mapper.UserMapper;
import jgsu.clong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {
    @Reference
    UserMapper userMapper;
    @Override
    public T_MALL_USER_ACCOUNT queryUser(T_MALL_USER_ACCOUNT user) {
        return userMapper.queryUser(user);
    }

    @Override
    public T_MALL_USER_ACCOUNT select_user(T_MALL_USER_ACCOUNT user) {
        return userMapper.queryUser(user);
    }
}
