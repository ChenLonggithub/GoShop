package jgsu.clong.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyProperUtil {

    //获取配置文件指定的内容
    public static String getProperties(String pro, String path) {
        Properties properties = new Properties();
        InputStream resourceAsStream = MyProperUtil.class.getClassLoader().getResourceAsStream(pro);
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String property = properties.getProperty(path);
        return property;
    }
}
