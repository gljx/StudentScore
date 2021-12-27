package moe.nijigen.studentscore.Service;

import moe.nijigen.studentscore.DAO.AdministratorDAO;
import moe.nijigen.studentscore.Pojo.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrationService {

    @Autowired
    AdministratorDAO dao;

    public List<Administrator> queryAll(){
        return dao.queryAllAdmin();
    }

    public boolean DeleteAdministrator(String UUID){
        dao.deleteAdminByUUID(UUID);
        return true;
    }

    public boolean UpdateAdministrator(String UUID,Administrator admin){
        dao.updateAdministrator(UUID,admin);
        return true;
    }

    public boolean AddAdministrator(Administrator admin){
        dao.addAdministrator(admin);
        return true;
    }

}
