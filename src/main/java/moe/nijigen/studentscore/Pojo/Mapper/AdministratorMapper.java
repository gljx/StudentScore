package moe.nijigen.studentscore.Pojo.Mapper;

import moe.nijigen.studentscore.Pojo.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdministratorMapper {

    Administrator queryAdminByName(String name);

    Administrator queryAdminByPhoneNumAndPassword(@Param("name")String name,@Param("password")String password);

    int insertAdmin(Administrator admin);

    int deleteAdmin(String uuid);

    int updateAdmin(String UUID,Administrator admin);

    List<Administrator> queryAllAdmin();
}
