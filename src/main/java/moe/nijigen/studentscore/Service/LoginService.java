package moe.nijigen.studentscore.Service;

import moe.nijigen.studentscore.DAO.AdministratorDAO;
import moe.nijigen.studentscore.DAO.TeacherDAO;
import moe.nijigen.studentscore.Pojo.Administrator;
import moe.nijigen.studentscore.Pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    AdministratorDAO adminDAO;

    @Autowired
    TeacherDAO teacherDAO;


    public boolean Adminlogin(Administrator administrator){
        if(adminDAO.QueryAdministratorPhoneNumAndPassword(administrator)!=null)
            return true;
        else
            return false;
    }

    public boolean TeacherLogin(Teacher teacher){
        if(teacherDAO.login(teacher)!=null)
            return true;
        else
            return false;
    }



}
