package moe.nijigen.studentscore.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Grade {
    String UUID;
    private int grade;
    int Class_;
    private String TeacherUUID;
}
