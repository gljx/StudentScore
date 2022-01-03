package moe.nijigen.studentscore.Service;

import moe.nijigen.studentscore.DAO.AdministratorDAO;
import moe.nijigen.studentscore.DAO.TeacherDAO;
import moe.nijigen.studentscore.Pojo.Administrator;
import moe.nijigen.studentscore.Pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    AdministratorDAO adminDAO;

    @Autowired
    TeacherDAO teacherDAO;


    public Administrator Adminlogin(Administrator administrator){
        Administrator admin= adminDAO.QueryAdministratorPhoneNumAndPassword(administrator);
        if(admin!=null)
            return admin;
        else
            return null;
    }

    public Teacher TeacherLogin(Teacher teacher){//只返回第一个老师，后期可能是bug
        System.out.println("package moe.nijigen.studentscore.Service.LoginService.TeacherLogin 这里只返回第一个教师后期可能是bug，但是先跑起来");
        Teacher ResultTeacher=teacherDAO.login(teacher);
        if(teacher!=null)
            return ResultTeacher;
        else
            return null;
    }



}
