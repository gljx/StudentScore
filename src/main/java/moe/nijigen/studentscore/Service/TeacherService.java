package moe.nijigen.studentscore.Service;

import moe.nijigen.studentscore.DAO.TeacherDAO;
import moe.nijigen.studentscore.Pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherDAO  teacherDAO;

    public List<Teacher> queryAllTeacher(){
        return teacherDAO.queryAllTeacher();
    }

    public List<Teacher> queryTeacherByName(String name){
        return teacherDAO.queryTeacherByName(name);
    }

}
