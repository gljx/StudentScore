package moe.nijigen.studentscore.DAO;

import moe.nijigen.studentscore.Pojo.Mapper.StudentMapper;
import moe.nijigen.studentscore.Pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAO {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> queryAllStudent(){
        List<Student> stuList=studentMapper.queryAllStudent();
        for(Student stu :stuList){
            System.out.println(stu.toString());
        }
        return stuList;
    }


}
