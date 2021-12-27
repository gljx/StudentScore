package moe.nijigen.studentscore.Controller;

import moe.nijigen.studentscore.DAO.StudentDAO;
import moe.nijigen.studentscore.Pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping("/hello1")//127.0.0.1:8080/hello/hello1
    @ResponseBody//这个函数直接就是返回体。
    public String hello(){
        return "hello";
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Student> queryAllStudent(){
        return studentDAO.queryAllStudent();
    }
}
