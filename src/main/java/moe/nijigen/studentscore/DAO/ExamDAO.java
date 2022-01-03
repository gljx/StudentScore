package moe.nijigen.studentscore.DAO;

import moe.nijigen.studentscore.Pojo.Exam;
import moe.nijigen.studentscore.Pojo.Mapper.ExamMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExamDAO {
    @Autowired
    ExamMapper mapper;

    public List<Exam> queryAllExam(){
        return mapper.queryAllExam();
    }

    public boolean AddExam(Exam exam){
        mapper.insertExam(exam);
        return true;
    }

    public boolean DeleteExam(String UUID){
        mapper.deleteExam(UUID);
        return true;
    }

    public boolean UpdateExam(String UUID,Exam exam){
        mapper.updateExam(UUID,exam);
        return true;
    }

    public List<Exam> queryByCode(int code){
        return mapper.queryExamByCode(code);
    }

    public Exam queryExamByUUID(@Param("UUID") String UUID){
        return mapper.queryExamByUUID(UUID);
    }





}
