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
public class Polar {

    List<String> labels=new ArrayList<>();

    List<Polar.data> datasets=new ArrayList<>();

    public Polar addDasets(List<Polar.data> dataset){
        for(Polar.data data:dataset){
            this.datasets.add(data);
        }
        return this;
    }

    public Polar addLabels(List<String> labels){
        for(String label:labels){
            this.labels.add(label);
        }
        return this;
    }

    void AutoSetLabels(){
        this.labels.add("优秀");
        this.labels.add("良好");
        this.labels.add("及格");
        this.labels.add("不及格");
    }

    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class data{

        List<Integer> data;
        boolean fill=true;
        List<String> backgroundColor;
        public Polar.data setData(List<Integer> data) {
            this.data = data;
            return this;
        }

        public Polar.data setFill(boolean fill) {
            this.fill = fill;
            return this;
        }

        public Polar.data setBackgroundColor(List<String> backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }


        public Polar.data AutosetBackgroundColor(int colorNum) {
            this.backgroundColor = getRandomColor(colorNum);
            System.out.println(backgroundColor);
            return this;
        }

    }
    public Polar setDatasets(List<Score> scores,Subject subject) {
        AutoSetLabels();
        int stuNum=scores.size();
        int excellent=0;
        int pass=0;
        int onlyPass=0;
        int flunk=0;
        List<Double> scoredNum = new ArrayList<>();
        if(scores.get(0).getGrade()==8) {//初中
            switch (subject) {
                case 语文:
                    for (Score score : scores) {
                        if (score.getChinese() >= 72) {
                            pass++;
                        }
                        if (score.getChinese() >= 92) {
                            excellent++;
                            continue;
                        }
                        if (score.getChinese() >= 72) {
                            onlyPass++;
                        }
                        if (score.getChinese() < 72) {
                            flunk++;
                        }
                    }
                    break;
                case 数学:
                    for (Score score : scores) {
                        if (score.getMathScore() >= 72) {
                            pass++;
                        }
                        if (score.getMathScore() >= 92) {
                            excellent++;
                            continue;
                        }
                        if (score.getMathScore() >= 72) {
                            onlyPass++;
                        }
                        if (score.getMathScore() < 72) {
                            flunk++;
                        }
                    }
                    break;
                case 英语:
                    for (Score score : scores) {
                        if (score.getEnglish() >= 72) {
                            pass++;
                        }
                        if (score.getEnglish() >= 92) {
                            excellent++;
                            continue;
                        }
                        if (score.getEnglish() >= 72) {
                            onlyPass++;
                        }
                        if (score.getEnglish() < 72) {
                            flunk++;
                        }
                    }
                    break;
                case 物理:
                    for (Score score : scores) {
                        if (score.getPhysics() >= 48) {
                            pass++;
                        }
                        if (score.getPhysics() >= 68) {
                            excellent++;
                            continue;
                        }
                        if (score.getPhysics() >= 48) {
                            onlyPass++;
                        }
                        if (score.getPhysics() < 48) {
                            flunk++;
                        }
                    }
                    break;
                case 政治:
                    for (Score score : scores) {
                        if (score.getPolitics() >= 48) {
                            pass++;
                        }
                        if (score.getPolitics() >= 68) {
                            excellent++;
                            continue;
                        }
                        if (score.getPolitics() >= 48) {
                            onlyPass++;
                        }
                        if (score.getPolitics() < 48) {
                            flunk++;
                        }
                    }
                    break;

                case 历史:
                    for (Score score : scores) {
                        if (score.getPolitics() >= 36) {
                            pass++;
                        }
                        if (score.getPolitics() >= 51) {
                            excellent++;
                            continue;
                        }
                        if (score.getPolitics() >= 36) {
                            onlyPass++;
                        }
                        if (score.getPolitics() < 36) {
                            flunk++;
                        }
                    }
                    break;
                case 生物:
                    for (Score score : scores) {
                        if (score.getPolitics() >= 36) {
                            pass++;
                        }
                        if (score.getPolitics() >= 51) {
                            excellent++;
                            continue;
                        }
                        if (score.getPolitics() >= 36) {
                            onlyPass++;
                        }
                        if (score.getPolitics() < 36) {
                            flunk++;
                        }
                    }
                    break;
                case 地理:
                    for (Score score : scores) {
                        if (score.getPolitics() >= 36) {
                            pass++;
                        }
                        if (score.getPolitics() >= 51) {
                            excellent++;
                            continue;
                        }
                        if (score.getPolitics() >= 36) {
                            onlyPass++;
                        }
                        if (score.getPolitics() < 36) {
                            flunk++;
                        }
                    }
                    break;
            }
        }
        if(scores.get(0).getGrade()==9) {
            switch (subject) {
                case 语文:
                    for (Score score : scores) {
                        if (score.getChinese() >= 72) {
                            pass++;
                        }
                        if (score.getChinese() >= 92) {
                            excellent++;
                            continue;
                        }
                        if (score.getChinese() >= 72) {
                            onlyPass++;
                        }
                        if (score.getChinese() < 72) {
                            flunk++;
                        }
                    }
                    break;
                case 数学:
                    for (Score score : scores) {
                        if (score.getMathScore() >= 72) {
                            pass++;
                        }
                        if (score.getMathScore() >= 92) {
                            excellent++;
                            continue;
                        }
                        if (score.getMathScore() >= 72) {
                            onlyPass++;
                        }
                        if (score.getMathScore() < 72) {
                            flunk++;
                        }
                    }
                    break;
                case 英语:
                    for (Score score : scores) {
                        if (score.getEnglish() >= 72) {
                            pass++;
                        }
                        if (score.getEnglish() >= 92) {
                            excellent++;
                            continue;
                        }
                        if (score.getEnglish() >= 72) {
                            onlyPass++;
                        }
                        if (score.getEnglish() < 72) {
                            flunk++;
                        }
                    }
                    break;
                case 物理:
                    for (Score score : scores) {
                        if (score.getPhysics() >= 48) {
                            pass++;
                        }
                        if (score.getPhysics() >= 68) {
                            excellent++;
                            continue;
                        }
                        if (score.getPhysics() >= 48) {
                            onlyPass++;
                        }
                        if (score.getPhysics() < 48) {
                            flunk++;
                        }
                    }
                    break;
                case 政治:
                    for (Score score : scores) {
                        if (score.getPolitics() >= 48) {
                            pass++;
                        }
                        if (score.getPolitics() >= 68) {
                            excellent++;
                            continue;
                        }
                        if (score.getPolitics() >= 48) {
                            onlyPass++;
                        }
                        if (score.getPolitics() < 48) {
                            flunk++;
                        }
                    }
                    break;
                case 化学:
                    for (Score score : scores) {
                        if (score.getPolitics() >= 36) {
                            pass++;
                        }
                        if (score.getPolitics() >= 51) {
                            excellent++;
                            continue;
                        }
                        if (score.getPolitics() >= 36) {
                            onlyPass++;
                        }
                        if (score.getPolitics() < 36) {
                            flunk++;
                        }
                    }
                    break;
                case 历史:
                    for (Score score : scores) {
                        if (score.getPolitics() >= 36) {
                            pass++;
                        }
                        if (score.getPolitics() >= 51) {
                            excellent++;
                            continue;
                        }
                        if (score.getPolitics() >= 36) {
                            onlyPass++;
                        }
                        if (score.getPolitics() < 36) {
                            flunk++;
                        }
                    }
                    break;
                case 生物:
                    for (Score score : scores) {
                        if (score.getPolitics() >= 36) {
                            pass++;
                        }
                        if (score.getPolitics() >= 51) {
                            excellent++;
                            continue;
                        }
                        if (score.getPolitics() >= 36) {
                            onlyPass++;
                        }
                        if (score.getPolitics() < 36) {
                            flunk++;
                        }
                    }
                    break;
                case 地理:
                    for (Score score : scores) {
                        if (score.getPolitics() >= 36) {
                            pass++;
                        }
                        if (score.getPolitics() >= 51) {
                            excellent++;
                            continue;
                        }
                        if (score.getPolitics() >= 36) {
                            onlyPass++;
                        }
                        if (score.getPolitics() < 36) {
                            flunk++;
                        }
                    }
                    break;
            }
        }
        if(scores.get(0).getGrade()==7) {
            switch (subject) {
                case 语文:
                    for (Score score : scores) {
                        if (score.getChinese() >= 72) {
                            pass++;
                        }
                        if (score.getChinese() >= 92) {
                            excellent++;
                            continue;
                        }
                        if (score.getChinese() >= 72) {
                            onlyPass++;
                        }
                        if (score.getChinese() < 72) {
                            flunk++;
                        }
                    }
                    break;
                case 数学:
                    for (Score score : scores) {
                        if (score.getMathScore() >= 72) {
                            pass++;
                        }
                        if (score.getMathScore() >= 92) {
                            excellent++;
                            continue;
                        }
                        if (score.getMathScore() >= 72) {
                            onlyPass++;
                        }
                        if (score.getMathScore() < 72) {
                            flunk++;
                        }
                    }
                    break;
                case 英语:
                    for (Score score : scores) {
                        if (score.getEnglish() >= 72) {
                            pass++;
                        }
                        if (score.getEnglish() >= 92) {
                            excellent++;
                            continue;
                        }
                        if (score.getEnglish() >= 72) {
                            onlyPass++;
                        }
                        if (score.getEnglish() < 72) {
                            flunk++;
                        }
                    }
                    break;
                case 政治:
                    for (Score score : scores) {
                        if (score.getPolitics() >= 48) {
                            pass++;
                        }
                        if (score.getPolitics() >= 68) {
                            excellent++;
                            continue;
                        }
                        if (score.getPolitics() >= 48) {
                            onlyPass++;
                        }
                        if (score.getPolitics() < 48) {
                            flunk++;
                        }
                    }
                    break;
                case 历史:
                    for (Score score : scores) {
                        if (score.getPolitics() >= 36) {
                            pass++;
                        }
                        if (score.getPolitics() >= 51) {
                            excellent++;
                            continue;
                        }
                        if (score.getPolitics() >= 36) {
                            onlyPass++;
                        }
                        if (score.getPolitics() < 36) {
                            flunk++;
                        }
                    }
                    break;
                case 生物:
                    for (Score score : scores) {
                        if (score.getPolitics() >= 36) {
                            pass++;
                        }
                        if (score.getPolitics() >= 51) {
                            excellent++;
                            continue;
                        }
                        if (score.getPolitics() >= 36) {
                            onlyPass++;
                        }
                        if (score.getPolitics() < 36) {
                            flunk++;
                        }
                    }
                    break;
                case 地理:
                    for (Score score : scores) {
                        if (score.getPolitics() >= 36) {
                            pass++;
                        }
                        if (score.getPolitics() >= 51) {
                            excellent++;
                            continue;
                        }
                        if (score.getPolitics() >= 36) {
                            onlyPass++;
                        }
                        if (score.getPolitics() < 36) {
                            flunk++;
                        }
                    }
                    break;
            }
        }
        if(scores.get(0).getGrade()>=3) {
            switch (subject) {
                case 语文:
                    for (Score score : scores) {
                        if (score.getChinese() >= 60) {
                            pass++;
                        }
                        if (score.getChinese() >= 85) {
                            excellent++;
                            continue;
                        }
                        if (score.getChinese() >= 60) {
                            onlyPass++;
                        }
                        if (score.getChinese() < 60) {
                            flunk++;
                        }
                    }
                    break;
                case 数学:
                    for (Score score : scores) {
                        if (score.getMathScore() >= 60) {
                            pass++;
                        }
                        if (score.getMathScore() >= 85) {
                            excellent++;
                            continue;
                        }
                        if (score.getMathScore() >= 60) {
                            onlyPass++;
                        }
                        if (score.getMathScore() < 60) {
                            flunk++;
                        }
                    }
                    break;
                case 英语:
                    for (Score score : scores) {
                        if (score.getEnglish() >= 60) {
                            pass++;
                        }
                        if (score.getEnglish() >= 85) {
                            excellent++;
                            continue;
                        }
                        if (score.getEnglish() >= 60) {
                            onlyPass++;
                        }
                        if (score.getEnglish() < 85) {
                            flunk++;
                        }
                    }
                    break;
            }
        }
        if(scores.get(0).getGrade()<=2) {
            switch (subject) {
                case 语文:
                    for (Score score : scores) {
                        if (score.getChinese() >= 60) {
                            pass++;
                        }
                        if (score.getChinese() >= 85) {
                            excellent++;
                            continue;
                        }
                        if (score.getChinese() >= 60) {
                            onlyPass++;
                        }
                        if (score.getChinese() < 60) {
                            flunk++;
                        }
                    }
                    break;
                case 数学:
                    for (Score score : scores) {
                        if (score.getMathScore() >= 60) {
                            pass++;
                        }
                        if (score.getMathScore() >= 85) {
                            excellent++;
                            continue;
                        }
                        if (score.getMathScore() >= 60) {
                            onlyPass++;
                        }
                        if (score.getMathScore() < 60) {
                            flunk++;
                        }
                    }
                    break;
            }
        }
        List<Integer> PolarData=new ArrayList<Integer>();
        PolarData.add(excellent);
        PolarData.add(onlyPass);
        PolarData.add(flunk);
        datasets.add(new Polar.data().setData(PolarData).AutosetBackgroundColor(3));
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
