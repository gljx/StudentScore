package moe.nijigen.studentscore.ChartData;

import lombok.*;
import moe.nijigen.studentscore.Pojo.Score;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Radar {

    List<String> labels=new ArrayList<>();

    List<Radar.data> datasets=new ArrayList<>();



    public Radar addDasets(List<Radar.data> dataset){
        for(Radar.data data:dataset){
            this.datasets.add(data);
        }
        return this;
    }

    public Radar addLabels(List<String> labels){
        for(String label:labels){
            this.labels.add(label);
        }
        return this;
    }

    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class data{

        String label;
        List<Double> data;
        boolean fill=true;
        List<String> backgroundColor;
        List<String> borderColor;
        List<String> pointHighlightFill;


        public data setLabel(String label) {
            this.label = label;
            return this;
        }

        public data setData(List<Double> data) {
            this.data = data;
            return this;
        }

        public data setFill(boolean fill) {
            this.fill = fill;
            return this;
        }

        public data setBackgroundColor(List<String> backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public data setBorderColor(List<String> borderColor) {
            this.borderColor = borderColor;
            return this;
        }

        public data setPointHighlightFill(List<String> pointHighlightFill) {
            this.pointHighlightFill = pointHighlightFill;
            return this;
        }

        public Radar.data AutosetBackgroundColor(int colorNum) {
            this.backgroundColor = getRandomColor(colorNum);
            return this;
        }

        public Radar.data AutosetBorderColor(int colorNum) {
            this.borderColor = getRandomColor(colorNum);
            return this;
        }
    }

    public Radar setDatasets(List<Score> scores) {
        int stuNum=scores.size();
        double chineseAll=0.0;
        double mathScoreAll=0.0;
        double englishAll=0.0;
        double physicsAll=0.0;
        double politicsAll=0.0;
        double chemistryAll=0.0;
        double history_scoreAll=0.0;
        double biologyAll=0.0;
        double geographyAll=0.0;
        List<Double> avgScore=new ArrayList<>();
        if (3 > scores.get(0).getGrade()) {//一二年级没有英语
            this.labels.add("语文");
            this.labels.add("数学");
            List<Double> scoredNum = new ArrayList<>();
            for (Score score:scores) {
                chineseAll+=score.getChinese();
                mathScoreAll+=score.getMathScore();
            }//遍历完了算出总成绩了，要算平均成绩
            double chineseAvg=chineseAll/stuNum;
            double mathAvg=mathScoreAll/stuNum;
            avgScore.add(chineseAvg);
            avgScore.add(mathAvg);
            datasets.add(new Radar.data().setLabel(scores.get(0).getExamName()+"偏科分析").setData(avgScore).AutosetBackgroundColor(1).AutosetBorderColor(1));
        }
        if (7 > scores.get(0).getGrade() && 2 < scores.get(0).getGrade()) {//3-6年级有英语
            this.labels.add("语文");
            this.labels.add("数学");
            this.labels.add("英语");
            List<Double> scoredNum = new ArrayList<>();
            for (Score score:scores) {
                chineseAll+=score.getChinese();
                mathScoreAll+=score.getMathScore();
                englishAll+=score.getEnglish();
            }
            double chineseAvg=chineseAll/stuNum;
            double mathAvg=mathScoreAll/stuNum;
            double englishAvg=englishAll/stuNum;
            avgScore.add(chineseAvg);
            avgScore.add(mathAvg);
            avgScore.add(englishAvg);
            datasets.add(new Radar.data().setLabel(scores.get(0).getExamName()+"偏科分析").setData(avgScore).AutosetBackgroundColor(1).AutosetBorderColor(1));
        }

        if (scores.get(0).getGrade()==8) {//八年级
            this.labels.add("语文");
            this.labels.add("数学");
            this.labels.add("英语");
            this.labels.add("物理");
            this.labels.add("政治");
            this.labels.add("历史");
            this.labels.add("生物");
            this.labels.add("地理");
            List<Double> scoredNum = new ArrayList<>();
            for (Score score:scores) {
                //按label顺序设置分数
                chineseAll+=score.getChinese();
                mathScoreAll+=score.getMathScore();
                englishAll+=score.getEnglish();
                physicsAll+=score.getPhysics();
                politicsAll+=score.getPolitics();
                history_scoreAll+=score.getHistory_score();
                biologyAll+=score.getBiology();
                geographyAll+=score.getGeography();
            }
            double chineseAvg=chineseAll/stuNum;
            double mathAvg=mathScoreAll/stuNum;
            double englishAvg=englishAll/stuNum;
            double physicsAvg=physicsAll/stuNum;
            double politicsAvg=politicsAll/stuNum;
            double historyAvg=history_scoreAll/stuNum;
            double biologyAvg=biologyAll/stuNum;
            double geographyAvg=geographyAll/stuNum;
            avgScore.add(chineseAvg);
            avgScore.add(mathAvg);
            avgScore.add(englishAvg);
            avgScore.add(physicsAvg);
            avgScore.add(politicsAvg);
            avgScore.add(historyAvg);
            avgScore.add(biologyAvg);
            avgScore.add(geographyAvg);
            datasets.add(new Radar.data().setLabel(scores.get(0).getExamName()+"偏科分析").setData(avgScore).AutosetBackgroundColor(1).AutosetBorderColor(1));
        }

        return this;
    }


    private List<String> getRandomColor(int colorNum){
        List<String> strings=new ArrayList<>();
        SecureRandom sr= null;
        try {
            sr = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        for(int i=0;i<colorNum;i++){
            String s = "rgba(" + String.valueOf(Math.abs(sr.nextInt() % 256)) + "," + String.valueOf(Math.abs(sr.nextInt() % 256)) + "," + String.valueOf(Math.abs(sr.nextInt() % 256)) + "," + String.format("%.1f", Math.abs(sr.nextDouble()))+")";
            strings.add(s);
        }
        return strings;
    }

}
