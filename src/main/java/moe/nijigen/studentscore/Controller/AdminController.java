package moe.nijigen.studentscore.Controller;

import moe.nijigen.studentscore.Pojo.*;
import moe.nijigen.studentscore.Service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/panel")
public class AdminController {

    @Autowired
    AdministrationService administrationService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    ScoreService scoreService;

    @Autowired
    ExamService examService;

    @RequestMapping("/admin/query")
    public String queryAllAdmin(HttpSession session, RedirectAttributesModelMap modelMap, Model model){
        List<Administrator> all= administrationService.queryAll();
        modelMap.addFlashAttribute("admins",all);
        model.addAttribute("admins",all);
        model.addAttribute("pageType","管理员用户管理");
        return "admin.html";
    }


    @RequestMapping("/student/query")
    public String queryAllStudent(HttpSession session, RedirectAttributesModelMap model){
        List<Student> students=studentService.queryAllStudent();
        model.addFlashAttribute("students",students);
        return "redirect:/admin.html";
    }

    @RequestMapping("/teacher/query")
    public String queryAllTeacher(HttpSession session, RedirectAttributesModelMap model){
        List<Teacher> teachers=teacherService.queryAllTeacher();
        model.addFlashAttribute("teachers",teachers);
        return "redirect:/admin.html";
    }

    @PostMapping("/admin/del/{uuid}")
    @ResponseBody
    public String deleteAdministrator(@PathVariable("uuid")String uuid){
        administrationService.DeleteAdministrator(uuid);
        return "success";
    }

    @PostMapping("/admin/update/{old_UUID}")
    @ResponseBody
    public String updateAdministrator(@PathVariable("old_UUID")String old_uuid,
                                  @Param("UUID")String UUID,
                                  @Param("name")String name,
                                  @Param("phone_num")String phone_num,
                                  @Param("password")String password){
        administrationService.UpdateAdministrator(old_uuid,new Administrator(UUID,name,phone_num,password));
        return "success";
    }

    @PostMapping("/admin/add")
    @ResponseBody
    public String addAdministrator(
            @Param("name")String name,
            @Param("phone_num")String phone_num,
            @Param("password")String password){
        administrationService.AddAdministrator(new Administrator(String.valueOf(UUID.randomUUID()),name,phone_num,password));
        return "success";
    }

    @RequestMapping("/exam/query")
    public String queryAllExam(Model model,HttpSession session){
        List<Exam> exams=examService.QueryAllExam();
        model.addAttribute("exams",exams);
        System.out.println(exams);
        model.addAttribute("pageType","考试管理");
        return "admin.html";
    }


    @RequestMapping("/exam/add")
    @ResponseBody
    public String addExam(Model model,
                          HttpSession session,
                          @Param("exam_name")String exam_name,
                          @Param("code")Integer code){
        examService.AddExam(new Exam(String.valueOf(UUID.randomUUID()),exam_name,code));
        model.addAttribute("pageType","考试");
        return "success";
    }

    @PostMapping("/exam/del/{uuid}")
    @ResponseBody
    public String deleteExam(@PathVariable("uuid")String uuid){
        examService.DeleteExam(uuid);
        return "success";
    }

    @PostMapping("/exam/update/{old_UUID}")
    @ResponseBody
    public String updateExam(@PathVariable("old_UUID")String old_uuid,
                                      @Param("UUID")String UUID,
                                      @Param("exam_name")String exam_name,
                                      @Param("code") Integer code){
        examService.UpdateExam(old_uuid,new Exam(UUID,exam_name,code));
        return "success";
    }

    @RequestMapping("/score/query")
    public String queryAllScore(HttpSession session,Model model){
        List<Score> scores= scoreService.queryAllScore();
        model.addAttribute("scores",scores);
        model.addAttribute("pageType","分数管理");
        System.out.println(scores);
        return "admin.html";
    }

    @RequestMapping("/score/add")
    @ResponseBody
    public String addScore(HttpSession session,Model model,
                           @Param("UUID")String UUID,
                           @Param("name")String name,
                           @Param("idNum")String idNum,
                           @Param("studyNum")String studyNum,
                           @Param("examID")String examID,
                           @Param("examName")String examName,
                           @Param("grade")int grade,
                           @Param("stuClass")int stuClass,
                           @Param("chinese")double chinese,
                           @Param("mathScore")double mathScore,
                           @Param("english")double english,
                           @Param("physics")double physics,
                           @Param("politics")double politics,
                           @Param("chemistry")double chemistry,
                           @Param("history_score")double history_score,
                           @Param("biology")double biology,
                           @Param("geography")double geography
                           ){
        scoreService.AddScore(new Score(UUID,name,idNum,studyNum,examID,examName,grade,stuClass,chinese,mathScore,english,physics,politics,chemistry,history_score,biology,geography));
        return "success";
    }





}
