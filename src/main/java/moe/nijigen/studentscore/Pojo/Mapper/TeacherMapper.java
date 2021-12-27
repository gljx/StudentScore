package moe.nijigen.studentscore.Pojo.Mapper;

import moe.nijigen.studentscore.DAO.TeacherDAO;
import moe.nijigen.studentscore.Pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository//DAO层
public interface TeacherMapper {
    Teacher loginTeacher(Teacher teacher);

    List<Teacher> queryAllTeacher();

    List<Teacher> queryByName(@Param("name") String name);
}
