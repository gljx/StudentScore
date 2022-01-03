package moe.nijigen.studentscore.Utils;

import moe.nijigen.studentscore.ChartData.Subject;

public class SubjectUtils {
    public static String parsetoString(Subject subject){
        switch (subject){
            case 语文:
                return "语文";
            case 数学:
                return "数学";
            case 英语:
                return "英语";
            case 物理:
                return "物理";
            case 政治:
                return "政治";
            case 化学:
                return "化学";
            case 历史:
                return "历史";
            case 生物:
                return "生物";
            case 地理:
                return "地理";
        };
        return null;
    }

    public static Subject parsetoSubject(String subject){
        switch (subject){
            case "语文":
                return Subject.语文;
            case "数学":
                return Subject.数学;
            case "英语":
                return Subject.英语;
            case "物理":
                return Subject.物理;
            case "政治":
                return Subject.政治;
            case "历史":
                return Subject.历史;
            case "化学":
                return Subject.化学;
            case "生物":
                return Subject.生物;
            case "地理":
                return Subject.地理;
        }
        return null;
    }
}
