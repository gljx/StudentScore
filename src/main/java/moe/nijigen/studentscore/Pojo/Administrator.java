package moe.nijigen.studentscore.Pojo;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Administrator {
    private String UUID;
    private String name;
    private String phone_num;
    private String password;
}
