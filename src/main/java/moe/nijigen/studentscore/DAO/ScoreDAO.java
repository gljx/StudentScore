package moe.nijigen.studentscore.DAO;

import moe.nijigen.studentscore.Pojo.Mapper.ScoreMapper;
import moe.nijigen.studentscore.Pojo.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScoreDAO {

    @Autowired
    ScoreMapper scoreMapper;


    public int insertScore(Score score){
        scoreMapper.insertScore(score);
        return 0;
    }

    public int deleteScore(String uuid){
        scoreMapper.deleteScore(uuid);
        return 0;
    }

    public int updateScore(String UUID,Score score){
        scoreMapper.updateScore(UUID,score);
        return 0;
    }

    public List<Score> queryByName(String name){

       return scoreMapper.queryScoreByName(name);

    }

    public List<Score> queryByID(int id){
        return scoreMapper.queryScoreByID(id);
    }

    public List<Score> querySchoolAllStudentScore(){
        return scoreMapper.querySchoolAllStudentScore();
    }

    public List<Score> queryGradeAllStudentScore(int grade){
        return scoreMapper.queryGradeAllStudentScore(grade);
    }

    public List<Score> queryClassAllStudentScore(int grade,int Class_,String exam_name){
        System.out.println(scoreMapper.queryClassAllStudentScore(grade,Class_,exam_name));
        return scoreMapper.queryClassAllStudentScore(grade,Class_,exam_name);
    }

    public List<Score> queryClassAllStudentScoreByExamName(String exam_name,int grade){
        return scoreMapper.queryClassAllStudentScoreByExamName(exam_name,grade);
    }

    public List<Score> queryAllScore(){
        return scoreMapper.queryAllScore();
    }

}
