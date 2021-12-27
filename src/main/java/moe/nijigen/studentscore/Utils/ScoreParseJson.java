package moe.nijigen.studentscore.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import moe.nijigen.studentscore.Pojo.Score;
import moe.nijigen.studentscore.Pojo.Teacher;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreParseJson {

    ArrayList<Score> scores;

    public String getScoreJson(String type, Teacher teacher) throws Exception {

        switch (type){
            case "bar":

                break;
            case "c":
                break;
            default:
                throw new Exception("Error");

        }
        return null;
    }

    private String parseJson(Teacher teacher){
        String json=new String();
        json=json+"{";
        json=json+"labels: ['语文', '数学', '英语','物理','政治','化学','历史', '生物','地理'],";
        json=json+"datasets: [";
        //中间数据部分
        int flag=0;
        int len=scores.size();
        for(Score i : scores){
            json=json+"{label: '"+i.getName()+"',";
            json=json+"data: ["+
                    i.getChinese()+","+
                    i.getMathScore()+","+
                    i.getEnglish()+","+
                    i.getPhysics()+","+
                    i.getPolitics()+","+
                    i.getChemistry()+","+
                    i.getHistory_score()+","+
                    i.getBiology()+","+
                    i.getGeography()
                    +"],";
            json=json+"backgroundColor: [";
            json=json+"'rgba("+getRandom(255)+", "+getRandom(255)+", "+getRandom(255)+", "+new Float(getRandom(10)/10).toString()+")',";
            json=json+"'rgba("+getRandom(255)+", "+getRandom(255)+", "+getRandom(255)+", "+new Float(getRandom(10)/10).toString()+")',";
            json=json+"'rgba("+getRandom(255)+", "+getRandom(255)+", "+getRandom(255)+", "+new Float(getRandom(10)/10).toString()+")',";
            json=json+"'rgba("+getRandom(255)+", "+getRandom(255)+", "+getRandom(255)+", "+new Float(getRandom(10)/10).toString()+")',";
            json=json+"'rgba("+getRandom(255)+", "+getRandom(255)+", "+getRandom(255)+", "+new Float(getRandom(10)/10).toString()+")',";
            json=json+"'rgba("+getRandom(255)+", "+getRandom(255)+", "+getRandom(255)+", "+new Float(getRandom(10)/10).toString()+")',";
            json=json+"'rgba("+getRandom(255)+", "+getRandom(255)+", "+getRandom(255)+", "+new Float(getRandom(10)/10).toString()+")',";
            json=json+"'rgba("+getRandom(255)+", "+getRandom(255)+", "+getRandom(255)+", "+new Float(getRandom(10)/10).toString()+")',";
            json=json+"'rgba("+getRandom(255)+", "+getRandom(255)+", "+getRandom(255)+", "+new Float(getRandom(10)/10).toString()+")'";
            json=json+"],";
            json=json+"'rgba(0, 0, 0, 1)',"+"'rgba(0, 0, 0, 1)',"+"'rgba(0, 0, 0, 1)',"+"'rgba(0, 0, 0, 1)',"+"'rgba(0, 0, 0, 1)',"+"'rgba(0, 0, 0, 1)',"+"'rgba(0, 0, 0, 1)',"+"'rgba(0, 0, 0, 1)',"+"'rgba(0, 0, 0, 1)'";
            flag++;
            if(flag==len){//最后一个结尾不加逗号
                json=json+"],borderWidth: 1}";
            }else{//不是最后一个结尾加逗号
                json=json+"],borderWidth: 1},";
            }
        }

        //中间数据部分结束
        json=json+"]\n" +
                "    }";
        return json;
    }
    /*
    label: '张三',//图例
                data: [99, 100, 86.5, 57, 22, 39],
    * */
    private int getRandom(int num){
        SecureRandom random=new SecureRandom();
        num++;
        return random.nextInt()%num;
    }
}

