package jgsu.clong.service;

import jgsu.clong.bean.T_MALL_USER_ACCOUNT;
import jgsu.clong.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;
    @Override
    public T_MALL_USER_ACCOUNT login(T_MALL_USER_ACCOUNT user) {
        return loginMapper.login(user);
    }
}
