package moe.nijigen.studentscore;

import moe.nijigen.studentscore.Utils.ExcelUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;

@SpringBootTest
class StudentScoreApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException, IOException, InvalidFormatException {
        File file=new File("C:/Users/gljx/Desktop/a.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        Sheet sheet = wb.getSheetAt(2);
        //4.定义一些可复用的对象
        int rowIndex = 0; //行的索引
        int cellIndex = 1; //单元格的索引
        Row nRow = null;
        Cell nCell = null;

        Iterator<Row> iterator = sheet.iterator();
        int rowNum = 0;
        while (iterator.hasNext()){
            Row row = iterator.next();
            if(rowNum<2){
                rowNum++;
                continue;
            }
            System.out.println("getFirstCellNum:"+row.getFirstCellNum());//第一个真实数据在的单元格
            System.out.println("getRowNum:"+row.getRowNum());
            System.out.println("LastCellNum:"+row.getLastCellNum());//列数
            //System.out.println(row.getCell(10).getNumericCellValue());

        }
    }

}
