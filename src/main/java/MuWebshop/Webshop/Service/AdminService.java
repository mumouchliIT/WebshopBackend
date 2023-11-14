package MuWebshop.Webshop.Service;

import MuWebshop.Webshop.Entity.AdminEntity;

import java.util.List;

public interface AdminService {

    public AdminEntity AdminEntity(String email, String password);
    public AdminEntity addAdmin(AdminEntity admin);
    public List<AdminEntity> getAllAdmins();

}
