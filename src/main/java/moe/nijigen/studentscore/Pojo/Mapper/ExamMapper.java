package moe.nijigen.studentscore.Pojo.Mapper;

import moe.nijigen.studentscore.Pojo.Exam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExamMapper {

    List<Exam> queryAllExam();

    int insertExam(Exam exam);

    int deleteExam(@Param("UUID") String UUID);

    int updateExam(String UUID,Exam exam);

    List<Exam> queryExamByCode(@Param("code")int code);
}
