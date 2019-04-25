package jgsu.clong.server;

import com.google.gson.Gson;
import jgsu.clong.bean.T_MALL_USER_ACCOUNT;
import jgsu.clong.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;

public class LoginServerImpl implements LoginServer {

    @Autowired
    LoginService loginService;

    @Override
    @Path("login")
    @GET
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public String login(@BeanParam T_MALL_USER_ACCOUNT user) {
        T_MALL_USER_ACCOUNT dbUser = loginService.login(user);
        Gson gson = new Gson();
        return gson.toJson(dbUser);
    }
}
