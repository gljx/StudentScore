package moe.nijigen.studentscore.Service;

import moe.nijigen.studentscore.DAO.ExamDAO;
import moe.nijigen.studentscore.Pojo.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    ExamDAO examDAO;

    public List<Exam> QueryAllExam(){
        return  examDAO.queryAllExam();
    }

    public boolean AddExam(Exam exam){
        examDAO.AddExam(exam);
        return true;
    }

    public boolean DeleteExam(String UUID){
        examDAO.DeleteExam(UUID);
        return true;
    }

    public boolean UpdateExam(String UUID,Exam exam){
        examDAO.UpdateExam(UUID,exam);
        return true;
    }

    public List<Exam> queryExamByCode(int code){
        return examDAO.queryByCode(code);
    }



}
