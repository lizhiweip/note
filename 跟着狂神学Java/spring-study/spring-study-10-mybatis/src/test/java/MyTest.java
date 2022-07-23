import com.li.mapper.UserMapper;
import com.li.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.apache.ibatis.io.Resources;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

public class MyTest {
   // @Test
   /* public void test() throws Throwable{
        String resources="mybatis-config.xml";
        InputStream in=Resources.getResourceAsStream(resources);

        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);


        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        List<User> userList=mapper.selectUser();
        for (User user : userList) {
            System.out.println(user);
        }

    }
    */
    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-dao.xml");
        UserMapper userMapper=context.getBean("userMapper",UserMapper.class);
        for (User user : userMapper.selectUser()) {
            System.out.println(user);
        }
    }
}
