package moe.nijigen.studentscore.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;



//@ConfigurationProperties(prefix="yaml类")yaml里的类
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Teacher {
    private String UUID;
    private String name;//姓名
    private String password;//登录密码
    private int phoneNum;//手机号
}
