package com.li.mapper;

import com.li.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper{
//我们所有的操作都使用sqlSession来执行，在原来，现在都使用SqlSessionTemplate
private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public List<User> selectUser() {
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}
