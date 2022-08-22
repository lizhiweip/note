
import li.pojo.User;
import li. dao.UserMapper;
import li.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
   @Test
   public void test(){
       SqlSession sqlSession=MybatisUtils.getSqlSession();
       UserMapper mapper=sqlSession.getMapper(UserMapper.class);
       List<User> userList= mapper.getUser();
       for (User user : userList) {
           System.out.println(user);
       }
       sqlSession.close();
   }

   @Test
    public void getUserById(){
       SqlSession sqlSession=MybatisUtils.getSqlSession();
       UserMapper mapper=sqlSession.getMapper(UserMapper.class);
       User user=mapper.getUserById(1);
       System.out.println(user);
       sqlSession.close();
   }

   @Test
    public  void addUser(){
       SqlSession sqlSession=MybatisUtils.getSqlSession();
       UserMapper mapper=sqlSession.getMapper(UserMapper.class);
       mapper.addUser(new User(5,"赵六","111222"));
       sqlSession.commit();
       sqlSession.close();
   }

   @Test
   public void updateUser(){
       SqlSession sqlSession=MybatisUtils.getSqlSession();
       UserMapper mapper=sqlSession.getMapper(UserMapper.class);
       mapper.updateUser(new User(5,"王五","222222"));
       sqlSession.commit();
       sqlSession.close();
   }

   public void deleteUser(){
       SqlSession sqlSession=MybatisUtils.getSqlSession();
       UserMapper mapper=sqlSession.getMapper(UserMapper.class);
       mapper.deleteUser(5);
       sqlSession.commit();
       sqlSession.close();
   }
}
