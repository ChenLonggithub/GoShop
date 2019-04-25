package jgsu.clong.server;

import jgsu.clong.bean.T_MALL_USER_ACCOUNT;

import javax.jws.WebService;

@WebService
public interface LoginServer {
     public String login(T_MALL_USER_ACCOUNT user);
}
