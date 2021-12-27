package moe.nijigen.studentscore.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SchoolClass {
    private int grade;
    private int Class_;
    private Teacher headClassTeacher;
}
