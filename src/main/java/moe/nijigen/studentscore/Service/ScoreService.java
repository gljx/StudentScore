package moe.nijigen.studentscore.Service;

import moe.nijigen.studentscore.ChartData.*;
import moe.nijigen.studentscore.DAO.ScoreDAO;
import moe.nijigen.studentscore.Pojo.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ScoreService {
    @Autowired
    ScoreDAO scoreDAO;



    public Line queryLineData(){
        Line line=new Line().setDatasetsOneStuSumScore(scoreDAO.queryByID(3109));
        return line;
    }

    public Object queryDiagramDataByID(int id,String type) throws Exception {
        switch (type){
            case "Bar":
                return new Bar().setDatasets(scoreDAO.queryByID(id));

            case "Line":
                return new Line().setDatasetsOneStuSumScore(scoreDAO.queryByID(id));
            case "Radar":
                return new Radar().setDatasets(scoreDAO.queryByID(id));
            default:
                throw new Exception("Error Type");

        }

    }


    public Bar queryDiagramDataByGradeAndClass(int grade,int cla55,String exam_name){
        return new Bar().setDatasets(scoreDAO.queryClassAllStudentScore(grade,cla55,exam_name));
    }

    public Radar queryRadarChartByExamName(int garde,int cla55,String exam_name){
        return new Radar().setDatasets(scoreDAO.queryClassAllStudentScore(garde,cla55,exam_name));
    }

    public List<Score> queryByGradeAndClassNameAndExamName(int grade,int cla55,String exam_name){
        return scoreDAO.queryClassAllStudentScore(grade,cla55,exam_name);
    }

    public List<Score> queryAllScore(){
        return scoreDAO.queryAllScore();
    }

    public boolean AddScore(Score score){
        scoreDAO.insertScore(score);
        return true;
    }

    public boolean updateScore(String UUID,Score score){
        scoreDAO.updateScore(UUID,score);
        return true;
    }

    public boolean ImportExcelScore(List<Score> scores){
        try{
            Iterator<Score> scoreIterator= scores.iterator();
            while(scoreIterator.hasNext()){
                scoreDAO.insertScore(scoreIterator.next());
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Polar queryPolarData(int garde, int cla55, String exam_name, Subject subject){
        return new Polar().setDatasets(scoreDAO.queryClassAllStudentScore(garde,cla55,exam_name),subject);
    }


}
