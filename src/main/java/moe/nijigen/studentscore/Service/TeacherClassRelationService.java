package moe.nijigen.studentscore.Service;

import moe.nijigen.studentscore.DAO.GradeDAO;
import moe.nijigen.studentscore.Pojo.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class TeacherClassRelationService {

    @Autowired
    GradeDAO gradeDAO;

    public List<Grade> getRealation(String teacherUUID){
        return gradeDAO.queryByTeacherUUID(teacherUUID);
    }

}
