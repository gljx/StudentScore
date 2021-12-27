package moe.nijigen.studentscore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//在templates目录先只能通过controller跳转实现访问
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        //model.addAttribute("msg","hello,world!");
        return "index";
    }
}
