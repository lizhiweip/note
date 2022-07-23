import li.dao.TeacherMapper;
import li.pojo.Teacher;
import li.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void getTeacher(){
        SqlSession session= MybatisUtils.getSqlSession();
        TeacherMapper mapper=session.getMapper(TeacherMapper.class);
        List<Teacher> teacherList =mapper.getTeacher();
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
        session.close();
    }
    @Test
    public  void getTeacherAndStudent(){
        SqlSession session=MybatisUtils.getSqlSession();
        TeacherMapper mapper=session.getMapper(TeacherMapper.class);
        Teacher teacher=mapper.getTeacherAndStudent(1);
        System.out.println(teacher);
        session.close();
    }
    @Test
    public  void getTeacherAndStudent2(){
        SqlSession session=MybatisUtils.getSqlSession();
        TeacherMapper mapper=session.getMapper(TeacherMapper.class);
        Teacher teacher=mapper.getTeacherAndStudent(1);
        System.out.println(teacher);
        session.close();
    }
}
