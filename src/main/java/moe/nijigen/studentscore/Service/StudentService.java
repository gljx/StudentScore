package moe.nijigen.studentscore.Service;

import moe.nijigen.studentscore.DAO.StudentDAO;
import moe.nijigen.studentscore.Pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    public List<Student> queryAllStudent(){
        return studentDAO.queryAllStudent();
    }
}
