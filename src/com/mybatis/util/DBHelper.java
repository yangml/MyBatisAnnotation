package com.mybatis.util;


import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.dao.UserDao;


/**
 * 
 *
 *  @version ： 1.0
 *  
 *  @author  ： 杨明亮             <a href="mailto:yangmingliang_22@163.com">发送邮件</a>
 *    
 *  @since   ： 1.0        创建时间:    2014-2-22    上午
 *     
 *  @function： 单例设计模式       
 *
 */
public class DBHelper {

    private static DBHelper dbHelper = new DBHelper();
    
    private  SqlSessionFactory sqlSessionFactory = null;
    
    private DBHelper(){
        try {
            String resource = "MyBatis-Configuration.xml";    //mybatis配置文件的路径
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactoryBuilder builfer = new SqlSessionFactoryBuilder();
            sqlSessionFactory = builfer.build(reader);
            sqlSessionFactory.getConfiguration().addMapper(UserDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static DBHelper getInstance(){
        return dbHelper;
    }
    
    public SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
    
}