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
 *  @version �� 1.0
 *  
 *  @author  �� ������             <a href="mailto:yangmingliang_22@163.com">�����ʼ�</a>
 *    
 *  @since   �� 1.0        ����ʱ��:    2014-2-22    ����
 *     
 *  @function�� �������ģʽ       
 *
 */
public class DBHelper {

    private static DBHelper dbHelper = new DBHelper();
    
    private  SqlSessionFactory sqlSessionFactory = null;
    
    private DBHelper(){
        try {
            String resource = "MyBatis-Configuration.xml";    //mybatis�����ļ���·��
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