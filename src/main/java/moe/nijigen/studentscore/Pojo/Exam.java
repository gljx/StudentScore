package moe.nijigen.studentscore.Pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Exam {
    String UUID;
    String exam_name;
    Integer code;
}
