package moe.nijigen.studentscore.DAO;

import moe.nijigen.studentscore.Pojo.Mapper.AdministratorMapper;
import moe.nijigen.studentscore.Pojo.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public class AdministratorDAO {

    @Autowired
    AdministratorMapper mapper;

    public Administrator QueryAdministratorPhoneNumAndPassword(Administrator administrator){
        Administrator admin=mapper.queryAdminByPhoneNumAndPassword(administrator.getName(),administrator.getPassword());
        if(admin!=null){
            return admin;
        }else{
            return null;
        }
    }

    public List<Administrator> queryAllAdmin(){
        return mapper.queryAllAdmin();
    }

    public void deleteAdminByUUID(String UUID){
        mapper.deleteAdmin(UUID);
    }

    public void updateAdministrator(String UUID,Administrator admin){
        mapper.updateAdmin(UUID,admin);
        return;
    }

    public void addAdministrator(Administrator admin){
        mapper.insertAdmin(admin);
    }
}
