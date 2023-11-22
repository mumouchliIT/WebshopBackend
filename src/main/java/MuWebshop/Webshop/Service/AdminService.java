package MuWebshop.Webshop.Service;

import MuWebshop.Webshop.Entity.AdminEntity;

public interface AdminService {

    public AdminEntity login(String email, String password);
    public AdminEntity addAdmin(AdminEntity admin);
    public AdminEntity getAdminById(Long adminId);
    public AdminEntity deleteAdmin(Long adminId);
    public boolean adminExists(Long adminId);
    public AdminEntity adminEmail(String email);

}
