package moe.nijigen.studentscore.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score implements Comparable<Score>{
    private String UUID;
    private String name;//姓名
    private String idNum;//身份证号
    private String studyNum;//学籍号
    private String examID;//考号
    private String examName;
    private int grade;
    private int stuClass;
    double chinese=0.0;
    double mathScore=0.0;
    double english=0.0;
    double physics=0.0;
    double politics=0.0;
    double chemistry=0.0;
    double history_score=0.0;
    double biology=0.0;
    double geography=0.0;

    @Override
    public int compareTo(Score score) {
        double v =((score.getChinese() + score.getMathScore() + score.getEnglish() + score.getPhysics() + score.getPolitics() + score.getChemistry() + score.getHistory_score() + score.getBiology() + score.getGeography()) * 1000) - ((this.chinese + this.mathScore + this.english + this.physics + this.politics + this.chemistry + this.history_score + this.biology + this.geography) * 1000);
        int num = new Double(v).intValue();
        return num;
    }


}
