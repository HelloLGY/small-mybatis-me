package cn.bugstack.mybatis;

import cn.bugstack.mybatis.binding.MapperProxyFactory;
import cn.bugstack.mybatis.binding.MapperRegistry;
import cn.bugstack.mybatis.session.SqlSession;
import cn.bugstack.mybatis.session.defaults.DefaultSqlSessionFactory;
import cn.bugstack.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory(){
        // 1. 注册 Mapper
        MapperRegistry mapperRegistry = new MapperRegistry();
        mapperRegistry.addMappers("cn.bugstack.mybatis.test.dao");
        // 2. 从 SqlSession 工厂获取 Session
        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(mapperRegistry);
        SqlSession sqlSession = defaultSqlSessionFactory.openSession();

        //3.获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        String name = userDao.queryUserName("1001");
        logger.info(name);
    }

    @Test
    public void test_proxy_class(){

    }

}
