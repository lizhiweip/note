package li.dao;

import li.pojo.Student;
import li.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
   //获取老师
    List<Teacher> getTeacher();

    //获取指定老师下的所有学生及其老师信息
    Teacher getTeacherAndStudent(@Param("tid") int id);

    Teacher getTeacherAndStudent2(@Param("tid") int id);
}
