package jgsu.clong.service;

public class TestServiceImpl implements TestService {

    @Override
    public String say(String name) {
        System.out.println("接口掉用：" + name);
        return name + "，欢迎！";
    }
}
