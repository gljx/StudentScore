package moe.nijigen.studentscore.Service;

import lombok.AllArgsConstructor;
import moe.nijigen.studentscore.Pojo.Score;
import moe.nijigen.studentscore.Utils.ExcelUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class ExcelService {

    @Autowired
    ScoreService service;

    public boolean importData(Integer code, String exam_name,InputStream inputStream){
        try{
            if(code==91){
                code=9;
            }
            if(code==92){
                code=10;
            }
            code--;
            XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(code);
            Iterator<Row> iterator = sheet.iterator();
            List<Score> scores=new ArrayList<>();
            int rowNum = 0;
            while (iterator.hasNext()) {
                Row row = iterator.next();
                if (rowNum < 2) {//跳过前两行表信息的行
                    rowNum++;
                    continue;
                }

                Score score=new Score();
                score.setGrade((code+1));
                score.setStuClass(1);
                score.setExamName(exam_name);
                if(code==8){
                    score.setStuClass(1);
                    score.setGrade(9);
                }
                if(code==9){
                    score.setStuClass(2);
                    score.setGrade(9);
                }
                score.setUUID(String.valueOf(UUID.randomUUID()));
                score.setName(row.getCell(1).getStringCellValue());//获取姓名
                score.setExamID(String.valueOf(Double.valueOf(row.getCell(2).getNumericCellValue()).intValue()));//获取考号
                score.setChinese(row.getCell(3).getNumericCellValue());//获取语文成绩
                score.setMathScore(row.getCell(4).getNumericCellValue());//获取数学成绩
                score.setEnglish(row.getCell(5).getNumericCellValue());//获取英语成绩
                if(row.getLastCellNum()==11){//七年级十一列
                    //七年级增加
                    score.setPolitics(row.getCell(6).getNumericCellValue());//获取政治
                    score.setHistory_score(row.getCell(7).getNumericCellValue());//获取历史成绩
                    score.setGeography(row.getCell(8).getNumericCellValue());//获取地理
                    score.setBiology(row.getCell(9).getNumericCellValue());//获取生物成绩
                }
                if(row.getLastCellNum()==12){//八年级
                    score.setPolitics(row.getCell(6).getNumericCellValue());//获取政治
                    score.setHistory_score(row.getCell(7).getNumericCellValue());//获取历史成绩
                    score.setGeography(row.getCell(8).getNumericCellValue());//获取地理
                    score.setPhysics(row.getCell(9).getNumericCellValue());//获取物理成绩
                    score.setBiology(row.getCell(10).getNumericCellValue());//获取生物成绩
                }
                if(row.getCell(0).getStringCellValue().contains("九年级")){
                    score.setPhysics(row.getCell(6).getNumericCellValue());//获取物理成绩
                    score.setPolitics(row.getCell(7).getNumericCellValue());//获取政治
                    score.setHistory_score(row.getCell(8).getNumericCellValue());//获取历史成绩
                    score.setChemistry(row.getCell(9).getNumericCellValue());//获取化学成绩
                }
                System.out.println(score);
                scores.add(score);
            }//此处遍历完表格

            if(service.ImportExcelScore(scores)){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
