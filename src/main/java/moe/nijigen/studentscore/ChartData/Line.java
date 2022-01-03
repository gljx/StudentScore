package moe.nijigen.studentscore.ChartData;


import lombok.*;
import moe.nijigen.studentscore.Pojo.Score;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Line {

    List<String> labels=new ArrayList<>();//横坐标

    List<Line.data> datasets=new ArrayList<>();

    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class data{

        String label;
        List<Double> data;
        String backgroundColor;
        String borderColor;
        String pointHighlightFill;

        Integer borderWidth=3;

        public Line.data setLabel(String label) {
            this.label = label;
            return this;
        }

        public Line.data setData(List<Double> data) {
            this.data = data;
            return this;
        }




        public Line.data setBorderWidth(int borderWidth) {
            this.borderWidth = borderWidth;
            return this;
        }

        public Line.data AutoSetAllColor(){
            Map<String,String> colorMap=getRandomColor();
            this.backgroundColor=colorMap.get("rgba");
            this.borderColor=colorMap.get("rgb");
            this.pointHighlightFill=colorMap.get("rgb");
            System.out.println("****"+colorMap.get("rgba"));
            return this;
        }

        private Map<String,String> getRandomColor(double alpha){
            Map<String,String> colorMap=new HashMap<>();
            SecureRandom sr= null;
            try {
                sr = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            String rgb = "rgba(" + String.valueOf(Math.abs(sr.nextInt() % 256)) + "," + String.valueOf(Math.abs(sr.nextInt() % 256)) + "," + String.valueOf(Math.abs(sr.nextInt() % 256));
            String rgba=rgb+ "," + String.valueOf(alpha)+")";
            colorMap.put("rgb",rgb);
            colorMap.put("rgba",rgba);
            return colorMap;
        }



        private Map<String,String> getRandomColor(){
            Map<String,String> colorMap=new HashMap<>();
            SecureRandom sr= null;
            try {
                sr = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            String rgb = "rgba(" + String.valueOf(Math.abs(sr.nextInt() % 256)) + "," + String.valueOf(Math.abs(sr.nextInt() % 256)) + "," + String.valueOf(Math.abs(sr.nextInt() % 256));
            String rgba=rgb+ "," + String.format("%.1f", Math.abs(sr.nextDouble()))+")";
            colorMap.put("rgb",rgb);
            colorMap.put("rgba",rgba);
            return colorMap;
        }


    }


    public Line setLabels(List<String> labels) {
        this.labels = labels;
        return this;
    }

    public Line setDatasetsOneStuSumScore(List<Score> scores){//只接受单个学生多次成绩分析

        if (3 > scores.get(0).getGrade()) {//一二年级没有英语
            List<Double> sumScore = new ArrayList<>();
            List<String> eaxmNames = new ArrayList<>();
            for (Score score : scores) {
                eaxmNames.add(score.getExamName());
            }
            TreeSet<String> scoreExamNameSet = new TreeSet<>(eaxmNames);
            eaxmNames = new ArrayList<>(scoreExamNameSet);
            for (Score score : scores) {
                double sum = score.getChinese() + score.getMathScore();
                sumScore.add(sum);
            }
            for (String examName : eaxmNames) {
                this.labels.add(examName);
            }
            this.datasets.add(new data().setLabel(scores.get(0).getName()).setData(sumScore).AutoSetAllColor());
            return this;
        }

        if (7 > scores.get(0).getGrade()&&2<scores.get(0).getGrade()) {//三至六年级有英语
            List<Double> sumScore = new ArrayList<>();
            List<String> eaxmNames = new ArrayList<>();
            for (Score score : scores) {
                eaxmNames.add(score.getExamName());
            }
            TreeSet<String> scoreExamNameSet = new TreeSet<>(eaxmNames);
            eaxmNames = new ArrayList<>(scoreExamNameSet);
            System.out.println(eaxmNames);
            for (Score score : scores) {
                double sum = score.getChinese() + score.getMathScore()+score.getEnglish();
                sumScore.add(sum);
            }
            for (String examName : eaxmNames) {
                this.labels.add(examName);
            }
            this.datasets.add(new data().setLabel(scores.get(0).getName()).setData(sumScore).AutoSetAllColor());
            return this;
        }

        if (8 == scores.get(0).getGrade()) {//八年级没化学
            List<Double> sumScore = new ArrayList<>();
            List<String> eaxmNames = new ArrayList<>();
            for (Score score : scores) {
                eaxmNames.add(score.getExamName());
            }
            TreeSet<String> scoreExamNameSet = new TreeSet<>(eaxmNames);
            eaxmNames = new ArrayList<>(scoreExamNameSet);
            for (Score score : scores) {
                double sum = score.getChinese() + score.getMathScore()+score.getEnglish()+score.getPhysics()+score.getPolitics()+score.getHistory_score()+score.getBiology()+score.getGeography();
                sumScore.add(sum);
            }
            for (String examName : eaxmNames) {
                this.labels.add(examName);
            }
            this.datasets.add(new data().setLabel(scores.get(0).getName()).setData(sumScore).AutoSetAllColor());
            return this;
        }

        if (9 == scores.get(0).getGrade()) {//九年级有化学
            List<Double> sumScore = new ArrayList<>();
            List<String> eaxmNames = new ArrayList<>();
            for (Score score : scores) {
                eaxmNames.add(score.getExamName());
            }
            TreeSet<String> scoreExamNameSet = new TreeSet<>(eaxmNames);
            eaxmNames = new ArrayList<>(scoreExamNameSet);
            for (Score score : scores) {
                double sum = score.getChinese() + score.getMathScore()+score.getEnglish()+score.getPhysics()+score.getPolitics()+score.getChemistry()+score.getHistory_score()+score.getBiology()+score.getGeography();
                sumScore.add(sum);
            }
            for (String examName : eaxmNames) {
                this.labels.add(examName);
            }
            this.datasets.add(new data().setLabel(scores.get(0).getName()).setData(sumScore).AutoSetAllColor());
            return this;
        }
        return null;
    }

}
