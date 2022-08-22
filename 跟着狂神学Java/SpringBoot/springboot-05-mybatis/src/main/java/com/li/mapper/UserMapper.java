package com.li.mapper;

import com.li.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//这个注解表示了这是一个mybatis 的mapper类      dao:@Repository

@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User QueryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
