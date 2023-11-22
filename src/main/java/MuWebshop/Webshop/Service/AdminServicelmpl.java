package MuWebshop.Webshop.Service;


import MuWebshop.Webshop.Entity.AdminEntity;
import MuWebshop.Webshop.Repo.AdminRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServicelmpl implements AdminService{

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public AdminEntity login(String email, String password) {
        try {
            // Attempt to find the admin by email and password
            return adminRepo.findByEmailAndPassword(email, password);
        } catch (Exception e) {
            // Log or handle the exception as needed
            throw new RuntimeException("An error occurred during login", e);
        }
    }

    @Override
    public AdminEntity addAdmin(AdminEntity admin) {
        try {
            // Attempt to save the new admin
            return adminRepo.save(admin);
        } catch (Exception e) {
            // Log or handle the exception as needed
            throw new RuntimeException("An error occurred while adding admin", e);
        }
    }

    @Override
    public AdminEntity getAdminById(Long adminId) {
        // Assuming you have a method in your AdminRepo to find an admin by ID
        Optional<AdminEntity> optionalAdmin = adminRepo.findById(adminId);

        // If the admin is found, return it; otherwise, return null or handle as needed
        return optionalAdmin.orElse(null);
    }
    @Override
    public boolean adminExists(Long adminId) {
        return adminRepo.existsById(adminId);
    }

    @Override
    public AdminEntity deleteAdmin(Long adminId) {
        if (adminExists(adminId)) {
            adminRepo.deleteById(adminId);
        } else {
            throw new EntityNotFoundException("Admin with ID " + adminId + " not found");
        }
        return null;
    }

    @Override
    public AdminEntity adminEmail(String email) {
        try {
            // Attempt to retrieve all admins
            return adminRepo.findByEmail(email);
        } catch (Exception e) {
            // Log or handle the exception as needed
            throw new RuntimeException("An error occurred while retrieving admin", e);
        }
    }
}

