package moe.nijigen.studentscore.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HomeAddress {
    private String homeAddressDistrict;//家乡区县
    private String homeAddressTown;//家乡镇
    private String homeAddressVillage;//家乡村组
}
