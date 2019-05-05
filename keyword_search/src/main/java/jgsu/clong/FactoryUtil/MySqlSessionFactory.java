package jgsu.clong.FactoryUtil;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {

    private static final InputStream in;

    private static final SqlSessionFactoryBuilder sqlSessionFactory;

    static {
        in = MySqlSessionFactory.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder();

    }

    public static SqlSessionFactory getSqlSessionFactory() {

        SqlSessionFactory build = sqlSessionFactory.build(in);
        return build;

    }

}
