package moe.nijigen.studentscore.Controller;

import moe.nijigen.studentscore.Service.ExcelService;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    ExcelService excelService;

    @PostMapping ("/excel")
    @ResponseBody
    public String uploadExcel(@Param("code")Integer code,@Param("exam_name")String exam_name ,MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        excelService.importData(code,exam_name,inputStream);
        return "success";
    }
}
