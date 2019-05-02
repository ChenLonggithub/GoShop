package jgsu.clong;

import jgsu.clong.until.JedisPoolUtils;
import redis.clients.jedis.Jedis;

public class test {

    public static void main(String[] args) {
        Jedis jedis = JedisPoolUtils.getJedis();
        String ping = jedis.ping();
        System.out.println(ping);
        jedis.set("chenlong","是帅哥！");
        System.out.println(jedis.get("chenlong"));

    }
}
