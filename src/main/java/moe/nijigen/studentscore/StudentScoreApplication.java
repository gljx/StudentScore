package moe.nijigen.studentscore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//标准这个类是一个springboot的应用，启动类 下所有资源导入
public class StudentScoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentScoreApplication.class, args);
    }//通过反射加载这个类的对象

}
