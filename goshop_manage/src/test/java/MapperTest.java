import com.google.gson.Gson;
import jgsu.clong.bean.T_MALL_CLASS_1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

public class MapperTest {

   /* @Test
    public void test1() throws Exception{
        *//*1.获取sqlSessionFactory*//*
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        *//*2.获取sqlsession*//*
        SqlSession sqlSession = sqlSessionFactory.openSession();
        *//*3.获取mapper*//*
        T_MALL_CLASS_1_Mapper class_1_mapper = sqlSession.getMapper(T_MALL_CLASS_1_Mapper.class);
        *//*4.操作获取数据*//*
        List<T_MALL_CLASS_1> list =  class_1_mapper.getlist();
        *//*5.创建json对象*//*
        Gson gson = new Gson();
        *//*6.数据转为JSON*//*
        String s = gson.toJson(list);
        *//*7.生成静态文件*//*
        FileOutputStream fileOutputStream = new FileOutputStream("d:/js/json");
        fileOutputStream.write(s.getBytes());
        fileOutputStream.close();

    }*/
}
