package com.mybatis.dao;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mybatis.entity.User;



public interface UserDao {

    @Insert("insert into tb_user(username,password,email,sex,age) values(#{username},#{password},#{email},#{sex},#{age})")
    public int insert(User user);
    
    @Update("update tb_user set username=#{username},password=#{password},email=#{email},sex=#{sex},age=#{age} where username=#{username}")
    public int update(User user);
   
    @Delete("delete from tb_user where username=#{username}")
    public int delete(String userName);
   
    @Select("select * from tb_user ")
    public List<User> selectAll();
   
    @Select("select count(*) from tb_user")
    public int countAll();
   
    @Select("select * from tb_user where username=#{username}")
    public User findByUserName(String userName);
     
     
}