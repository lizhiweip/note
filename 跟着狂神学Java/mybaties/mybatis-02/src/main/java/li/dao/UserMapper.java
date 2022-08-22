package li.dao;

import li.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from tb_user")
    List<User> getUser();

    //方法存在多个参数，所有参数前面必须加上@Param注解
    @Select("select * from tb_user where id=#{id}") //取的参数是注解中的参数
    User getUserById(@Param("id") int id);

    @Insert("insert into tb_user(id,name,pwd) values (#{id},#{name},#{pwd})")//值写实体类中的属性
    int addUser(User user);

    @Update("update tb_user set name=#{name},pwd=#{pwd} where id=#{id}")
     int updateUser(User user);

    @Delete("delete from tb_user where id=#{id}")
    int deleteUser(@Param("id") int id);
}
