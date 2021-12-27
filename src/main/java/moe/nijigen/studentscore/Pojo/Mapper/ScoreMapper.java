package moe.nijigen.studentscore.Pojo.Mapper;

import moe.nijigen.studentscore.Pojo.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ScoreMapper {

    int insertScore(Score score);

    int deleteScore(String uuid);

    int updateScore(String UUID,Score score);

    List<Score> queryAllScore();

    List<Score> querySchoolAllStudentScore();

    List<Score> queryGradeAllStudentScore(int gradee);

    List<Score> queryClassAllStudentScore(@Param("grade")int grade,@Param("stu_Class")int stu_Class,@Param("exam_name")String exam_name);

    List<Score> queryClassAllStudentScoreByExamName(@Param("exam_name")String ExamName,@Param("grade")int grade);

    List<Score> queryScoreByName(@Param("name")String name);

    List<Score> queryScoreByID(int id);

    List<Score> queryScoreByAndByExamName(@Param("id") int id,@Param("exam_name")String exam_name);

}
