import li.dao.StudentMapper;
import li.dao.TeacherMapper;
import li.pojo.Student;
import li.pojo.Teacher;
import li.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test() {
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        TeacherMapper mapper=sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher=mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }
    @Test
    public void getStudent(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        StudentMapper mapper=sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList=mapper.getStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
