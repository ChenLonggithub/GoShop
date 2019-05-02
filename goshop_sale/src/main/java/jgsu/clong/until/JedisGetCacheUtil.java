package jgsu.clong.until;

import jgsu.clong.bean.OBJECT_T_MALL_ATTR;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class JedisGetCacheUtil {

    /*获取Redis缓存的数据集合*/
    public static <T> List<T> getList(String key, Class<T> t) {

        List<T> list_attr = new ArrayList<>();

        // 第三方数据调用
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedis();
            System.out.println("==>>>>>>>>>>>>>>>>>>>>>>"+jedis.ping());
        } catch (Exception e) {
            return null;
        }

        Set<String> list = jedis.zrange(key, 0, -1);

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String skuStr = iterator.next();
            T sku = MyJsonUtil.json_to_object(skuStr, t);
            list_attr.add(sku);
        }

        return list_attr;
    }

    public static void addCache(String key, int flbh2, String value) {

        // 第三方数据调用
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedis();
        } catch (Exception e) {
            e.printStackTrace();
        }

        jedis.zadd(key, flbh2,value);

    }
}
