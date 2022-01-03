package moe.nijigen.studentscore.Controller;

import lombok.ToString;
import moe.nijigen.studentscore.ChartData.*;
import moe.nijigen.studentscore.Pojo.Exam;
import moe.nijigen.studentscore.Pojo.Grade;
import moe.nijigen.studentscore.Pojo.Score;
import moe.nijigen.studentscore.Pojo.Teacher;
import moe.nijigen.studentscore.Service.ExamService;
import moe.nijigen.studentscore.Service.ScoreService;
import moe.nijigen.studentscore.Service.TeacherClassRelationService;
import moe.nijigen.studentscore.Service.TeacherService;
import moe.nijigen.studentscore.Utils.SubjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/score")
@ToString
public class QueryStudentScoreController {


    @Autowired
    ExamService examService;

    @Autowired
    ScoreService service;

    @Autowired
    TeacherClassRelationService relationService;

    @Autowired
    TeacherService teacherService;


    @RequestMapping("/list")
    public String QueryAllScore(Model model, HttpSession session){
        String username= (String) session.getAttribute("username");
        List<Teacher> teachers =teacherService.queryTeacherByName(username);
        List<Grade> grades=relationService.getRealation(teachers.get(0).getUUID());
        int code=0;
        if(grades.get(0).getGrade()==9){
            code=9*10+grades.get(0).getClass_();
        }else {
            code=grades.get(0).getGrade();
        }
        List<Exam> exams = examService.queryExamByCode(code);
        System.out.println(exams);
        int grade=grades.get(0).getGrade();
        int ClASS_=grades.get(0).getClass_();
        List<Score> scores= service.queryByGradeAndClassNameAndExamName(grade,ClASS_,exams.get(0).getExam_name());
        System.out.println(scores);
        Collections.sort(scores);
        session.setAttribute("grade",scores.get(0).getGrade());
        session.setAttribute("class",scores.get(0).getStuClass());
        session.setAttribute("exam_name",exams.get(0).getExam_name());
        model.addAttribute("scores",scores);
        model.addAttribute("exams",exams);
        model.addAttribute("pageType","表格");
        return "table.html";
    }



    @GetMapping("/bar")
//    @ResponseBody
    public String queryScoreAPI(Model model, HttpSession session){
        Integer grade= (Integer) session.getAttribute("grade");
        Integer cla55= (Integer) session.getAttribute("class");
        String exam_name= (String) session.getAttribute("exam_name");
        System.out.println("年级:"+grade+"   班级:"+cla55+"  考试名称:"+exam_name);
        Bar result=service.queryDiagramDataByGradeAndClass(grade,cla55,exam_name);
        System.out.println(result);
        model.addAttribute("barResult",result);
        model.addAttribute("pageType","柱状图");
        //session.setAttribute("result",result);
        return "table.html";
    }

    @RequestMapping(value = "/radar/{exam_uuid}")
    public String RadarChart(@PathVariable String exam_uuid,Model model, HttpSession session){
        System.out.println("/score/radar"+exam_uuid);
        List<Grade>  grades = (List<Grade>) session.getAttribute("grades");//一个教师可能有多个年级多个班级的课
        System.out.println(grades);
        Radar resultTmp=new Radar();
        Radar result=new Radar();
        String exam_name= examService.queryExamByUUID(exam_uuid).getExam_name();
        for(Grade grade : grades){
            resultTmp=service.queryRadarChartByExamName(grade.getGrade(),grade.getClass_(),exam_name);
            System.out.println("resultTmp\n"+resultTmp);
            result.addDasets(resultTmp.getDatasets());
            result.addLabels(resultTmp.getLabels());
        }
        model.addAttribute("pageType","雷达图");
        model.addAttribute("radarResult",result);
        return "table.html";

    }

    @RequestMapping("/polar/{exam_uuid}/{subject}")
    public String queryPolar(@PathVariable("exam_uuid") String exam_uuid,@PathVariable("subject")String subject, Model model, HttpSession session){
        System.out.println("/score/polar/"+exam_uuid);
        List<Grade>  grades = (List<Grade>) session.getAttribute("grades");
        System.out.println(grades);
        Polar resultTmp=new Polar();
        Polar result=new Polar();
        String exam_name= examService.queryExamByUUID(exam_uuid).getExam_name();
        result=service.queryPolarData(grades.get(0).getGrade(),grades.get(0).getClass_(),exam_name, SubjectUtils.parsetoSubject(subject));
        model.addAttribute("pageType","极地图");
        model.addAttribute("polarResult",result);
        return "table.html";
    }

    //下面是屎山


    @RequestMapping("/{id}")
    public String queryScoreAPI(@PathVariable int id,RedirectAttributesModelMap model, HttpSession session) throws Exception {
        Bar result= (Bar) service.queryDiagramDataByID(id,"Bar");
        model.addFlashAttribute("result",result);
        session.setAttribute("result",result);
        System.out.println("2:"+result);
        return "redirect:/table.html";
    }


    //查询单个人
    @RequestMapping(value = "/line/{id}")
    public String queryScore(@PathVariable int id,RedirectAttributesModelMap model, HttpSession session) throws Exception {
        Line line= (Line) service.queryDiagramDataByID(id,"Line");
  //             new Line().setDatasetsOneStuSumScore(scoreDAO.queryByID(3109));
        model.addFlashAttribute("lineResult",line);
        System.out.println(line);
//        session.setAttribute("barResult",result);
//        session.setAttribute("lineResult",line);
        return "redirect:/table.html";
        //return "redirect:table.html"不加/ 表示跳转至 /socre/query/table.html 这个页面请求int 值 id 所以报错。
    }




}
