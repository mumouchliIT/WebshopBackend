package mu.webshop.service;

import mu.webshop.entity.AdminEntity;

import java.util.List;

public interface AdminService {
    List<AdminEntity> getAdmins();
    public AdminEntity login(String email, String password);
    public AdminEntity addAdmin(AdminEntity admin);
    public AdminEntity getAdminByEmail(String email);
    public AdminEntity deleteAdmin(Long adminId);
    public boolean adminExists(Long adminId);
    public AdminEntity adminEmail(String email);

}
