package moe.nijigen.studentscore.Pojo;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Student {
    private String UUID;
    private String name;//姓名
    private int ID;//考试ID
    private int age;//年龄
    private String idNum;//身份证号
    private String studyNum;//学籍号
    private int grade;
    private int Class_;
    private int sex;//0女，1男
    private int politic;//0群众，1团员 政治面貌
    private String parentName;//父母姓名
    private String parentPhoneNum;//父母手机
    private String poorType;//贫困类型
    private String homeAddressDistrict;
    private String homeAddressTown;
    private String homeAddressVillage;
    private boolean stayBehind;//留守
    private boolean boarding;//寄宿
    private int disability;//残疾
    private boolean fillingCard;//建档立卡



}
