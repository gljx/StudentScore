package moe.nijigen.studentscore.Controller;


import moe.nijigen.studentscore.DAO.TeacherDAO;
import moe.nijigen.studentscore.Pojo.Administrator;
import moe.nijigen.studentscore.Pojo.Grade;
import moe.nijigen.studentscore.Pojo.Teacher;
import moe.nijigen.studentscore.Service.LoginService;
import moe.nijigen.studentscore.Service.TeacherClassRelationService;
import moe.nijigen.studentscore.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller//有返回值得Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    TeacherClassRelationService tcrService;

    @Autowired
    TeacherService teacherService;

    @RequestMapping("/login")//127.0.0.1:8080/login
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        RedirectAttributesModelMap modelMap, HttpSession session){
        Teacher teacher=new Teacher();
        teacher.setName(username);
        teacher.setPassword(password);
        teacher=loginService.TeacherLogin(teacher);
        if(teacher!=null){
            System.out.println(username);
            List<Grade> grades = tcrService.getRealation(teacher.getUUID());
            session.setAttribute("token", UUID.randomUUID());
            session.setAttribute("username",username);
            session.setAttribute("grades",grades);//多对一关系
            modelMap.addFlashAttribute("username",username);
            modelMap.addFlashAttribute("canvasType","default");
            //return "redirect:table.html";//重定向model会失效
            return "redirect:/score/list";//
            //return "redirect:score/query/all";
        }else{
            System.out.println("登录失败");
            modelMap.addAttribute("loginMsg","登录失败");
            return "index";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:index.html";
    }

    @RequestMapping("/adminlog")
    public String adminLog(@RequestParam("adminname")String adminName,@RequestParam("password")String password,
                           RedirectAttributesModelMap model, HttpSession session){
        System.out.println("管理员模式登陆"+adminName+":"+password);
        Administrator admin =new Administrator();
        admin.setName(adminName);
        admin.setPassword(password);
        if(loginService.Adminlogin(admin)!=null){
            System.out.println(adminName+"login Admin Mode On");
            session.setAttribute("token",UUID.randomUUID());
            return "redirect:/panel/admin/query";
        }else{
            System.out.println("登录失败");
            model.addAttribute("loginMsg","登录失败");

            return "index";
        }
    }

}
