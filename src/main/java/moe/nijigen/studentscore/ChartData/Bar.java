package moe.nijigen.studentscore.ChartData;


import lombok.*;
import moe.nijigen.studentscore.Pojo.Score;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bar {

    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class data{

        String label;
        List<Double> data;
        List<String> backgroundColor;
        List<String> borderColor;
        Integer borderWidth=1;

        public data setLabel(String label) {
            this.label = label;
            return this;
        }

        public data setData(List<Double> data) {
            this.data = data;
            return this;
        }

        public data setBackgroundColor(List<String> backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public data AutosetBackgroundColor(int colorNum) {
            this.backgroundColor = getRandomColor(colorNum);
            return this;
        }

        public data setBorderColor(List<String> borderColor) {
            this.borderColor = borderColor;
            return this;
        }

        public data AutosetBorderColor(int colorNum) {
            this.borderColor = getRandomColor(colorNum);
            return this;
        }

        public data setBorderWidth(int borderWidth) {
            this.borderWidth = borderWidth;
            return this;
        }


    }

    List<String> labels=new ArrayList<>();

    List<data> datasets=new ArrayList<>();

    public Bar setDatasets(List<Score> scores,int limit) {
        if (3 > scores.get(0).getGrade()) {//一二年级没有英语
            for (int i = 0; i < limit; i++) {
                double chinese = scores.get(i).getChinese();
                double math_ = scores.get(i).getMathScore();
                List<Double> scoredNum = new ArrayList<>();
                scoredNum.add(scores.get(i).getChinese());
                scoredNum.add(scores.get(i).getMathScore());
                datasets.add(new data().setLabel(scores.get(i).getName()).setData(scoredNum).AutosetBackgroundColor(2));
            }
        }
        if (7 > scores.get(0).getGrade() && 2 < scores.get(0).getGrade()) {//3-6年级有英语
            for (int i = 0; i < limit; i++) {
                double chinese = scores.get(i).getChinese();
                double math_ = scores.get(i).getMathScore();
                List<Double> scoredNum = new ArrayList<>();
                scoredNum.add(scores.get(i).getChinese());
                scoredNum.add(scores.get(i).getMathScore());
                scoredNum.add(scores.get(i).getEnglish());
                datasets.add(new data().setLabel(scores.get(i).getName()).setData(scoredNum).AutosetBackgroundColor(3));
            }
        }
        return this;
    }

    public Bar setDatasets(List<Score> scores) {
        if (3 > scores.get(0).getGrade()) {//一二年级没有英语
            this.labels.add("语文");
            this.labels.add("数学");
            for (Score score:scores) {
                List<Double> scoredNum = new ArrayList<>();
                scoredNum.add(score.getChinese());
                scoredNum.add(score.getMathScore());
                datasets.add(new data().setLabel(score.getName()).setData(scoredNum).AutosetBackgroundColor(2).AutosetBorderColor(2));
            }
        }
        if (7 > scores.get(0).getGrade() && 2 < scores.get(0).getGrade()) {//3-6年级有英语
            this.labels.add("语文");
            this.labels.add("数学");
            this.labels.add("英语");
            for (Score score:scores) {
                List<Double> scoredNum = new ArrayList<>();
                scoredNum.add(score.getChinese());
                scoredNum.add(score.getMathScore());
                scoredNum.add(score.getEnglish());

                datasets.add(new data().setLabel(score.getName()).setData(scoredNum).AutosetBackgroundColor(3).AutosetBorderColor(3));
            }
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
            for (Score score:scores) {
                List<Double> scoredNum = new ArrayList<>();
                //按label顺序设置分数
                scoredNum.add(score.getChinese());
                scoredNum.add(score.getMathScore());
                scoredNum.add(score.getEnglish());
                scoredNum.add(score.getPhysics());
                scoredNum.add(score.getPolitics());
                scoredNum.add(score.getHistory_score());
                scoredNum.add(score.getBiology());
                scoredNum.add(score.getGeography());
                datasets.add(new data().setLabel(score.getName()).setData(scoredNum).AutosetBackgroundColor(3).AutosetBorderColor(3));
            }
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
        String s = "rgba(" + String.valueOf(Math.abs(sr.nextInt() % 256)) + "," + String.valueOf(Math.abs(sr.nextInt() % 256)) + "," + String.valueOf(Math.abs(sr.nextInt() % 256)) + "," + String.format("%.1f", Math.abs(sr.nextDouble()))+")";
        for(int i=0;i<colorNum;i++){
            strings.add(s);
        }
        return strings;
    }
}

