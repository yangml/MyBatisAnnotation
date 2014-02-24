package com.mybatis.test;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dao.UserDao;
import com.mybatis.entity.User;
import com.mybatis.util.DBHelper;


public class MybatisHandler {

    public static void main(String[] args) throws Exception {
    
        SqlSession session = DBHelper.getInstance().getSqlSession();
        UserDao userDao = session.getMapper(UserDao.class);
        
        //创建对象
        User user = new User();
        user.setUsername("杨明亮1");
        user.setPassword("dennisit");
        user.setEmail("dennisit@163.com");
        user.setSex("男");
        user.setAge(80);
        //增加用户
        userDao.insert(user);
        
        //查询数据库中记录总数
        System.out.println("数据库中的记录数:" + userDao.countAll());
        
        
        //根据用户名查找
        User usn = userDao.findByUserName("杨明亮");
        if(null!=usn){
            System.out.println("根据用户名查找的信息[" +usn.getId() + "," + usn.getUsername() + "," + usn.getEmail()+"]");
        }
        
        //更新用户
        User updUser = new User();
        updUser.setUsername("杨明亮"); //更新用户是按照用户名查找,然后更新的.所以要修改的数据前后必须是同一个用户名
        updUser.setEmail("update@163.com");
        updUser.setPassword("update");
        updUser.setAge(20);
        updUser.setSex("男");
        userDao.update(updUser);    //执行更新操作
        
        //查询所有用户记录
        List<User> list = userDao.selectAll();
        for(int i=0;i<list.size();i++){
            User us = list.get(i);
            System.out.println("[" + us.getId() + "," + us.getUsername() + "," + us.getEmail()+"]");
        }
        
        userDao.delete("杨明亮");
        
        System.out.println("执行删除后数据库中的记录数:" + userDao.countAll());

        session.commit();
    }
}