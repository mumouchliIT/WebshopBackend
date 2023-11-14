package MuWebshop.Webshop.Service;


import MuWebshop.Webshop.Entity.AdminEntity;
import MuWebshop.Webshop.Repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServicelmpl implements AdminService{

    @Autowired
    private AdminRepo adminRepo;
    @Override
    public AdminEntity AdminEntity(String email, String password) {
        return adminRepo.findByEmailAndPassword(email, password);
    }
    @Override
    public AdminEntity addAdmin(AdminEntity admin) {
        return adminRepo.save(admin);
    }

    @Override
    public List<AdminEntity> getAllAdmins() {
        return adminRepo.findAll();
    }


}
