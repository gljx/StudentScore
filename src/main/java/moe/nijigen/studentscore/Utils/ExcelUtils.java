package moe.nijigen.studentscore.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.stereotype.Component;



public class ExcelUtils {
    public static Object getValue(Cell cell){
        switch (cell.getCellType()){
            case STRING:
                return cell.getStringCellValue();

            case NUMERIC:
                return cell.getNumericCellValue();

            case BOOLEAN:
                return cell.getBooleanCellValue();

            case BLANK:
                return null;

            case FORMULA:
                return cell.getCellFormula();

            case _NONE:
                return null;

            case ERROR:
                return cell.getErrorCellValue();

            default:
                return null;

        }
    }
}
