package com.li.dao;

import com.li.pojo.User;
import com.li.utils.MybatisUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    static Logger logger= Logger.getLogger(UserDaoTest.class);
 @Test
    public void getUserLike(){
     SqlSession sqlSession=MybatisUtils.getSqlSession();

     UserMapper mapper=sqlSession.getMapper(UserMapper.class);
     List<User> userList=mapper.getUserLike("%李%");
     for (User user : userList) {
         System.out.println(user);
     }
     sqlSession.close();

    }
    @Test
    public void test(){

        //第一步：获得sqlSession对象
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        //执行sql
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        List<User> userList=mapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }
        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void getUserById(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();

        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user=mapper.getUserById(4);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    //增删改需要提交事务
    public void addUser(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();

        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        int result=mapper.addUser(new User(4,"哈哈哈","123456"));
        if(result>0){
            System.out.println("插入成功");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    public  void addUser2(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();

        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        HashMap<String,Object> map=new HashMap<String,Object>();
        map.put("userid",5);
        map.put("username","Hello");
        map.put("password","123123");
        mapper.addUser2(map);
        sqlSession.close();
    }
    @Test
   public  void updateUser(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();

        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(4,"李五","123123"));

        sqlSession.commit();
        sqlSession.close();
    }
    public void deleteUser(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();

        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testLog4j(){
        logger.info("info:进入了log4j");
        logger.debug("debug:进入了log4j");
        logger.error("error:进入了log4j");
    }

    @Test
    public void getUserByLimit(){
     SqlSession sqlSession=MybatisUtils.getSqlSession();
     UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        HashMap<String,Integer> map=new HashMap<String,Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);

        List<User> userList=mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }
     sqlSession.close();
    }

    @Test
    public void getUserByRowBounds(){
     SqlSession sqlSession=MybatisUtils.getSqlSession();
     //通过RowBounds实现
       RowBounds rowBounds= new RowBounds(1,2);

     //通过Java代码分页
     List<User> userList=sqlSession.selectList("com.li.dao.UserMapper.getUserByRowBounds",null,rowBounds);

        for (User user : userList) {
            System.out.println(user);
        }

     sqlSession.close();
    }
}
