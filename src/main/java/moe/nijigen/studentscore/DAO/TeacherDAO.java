package moe.nijigen.studentscore.DAO;

import moe.nijigen.studentscore.Pojo.Mapper.TeacherMapper;
import moe.nijigen.studentscore.Pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDAO {
    @Autowired
    TeacherMapper teacherMapper;

    public Teacher login(Teacher teacher){
        return teacherMapper.loginTeacher(teacher);
    }

    public List<Teacher> queryAllTeacher(){
        return teacherMapper.queryAllTeacher();
    }

    public List<Teacher> queryTeacherByName(String name){
        return teacherMapper.queryByName(name);
    }
}
