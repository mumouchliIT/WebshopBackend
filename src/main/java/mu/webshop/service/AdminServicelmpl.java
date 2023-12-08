package mu.webshop.service;


import mu.webshop.entity.AdminEntity;
import mu.webshop.repo.AdminRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServicelmpl implements AdminService{

    private final AdminRepo adminRepo;

    public AdminServicelmpl(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public AdminEntity login(String email, String password) {
        try {
            // Attempt to find the admin by email and password
            return adminRepo.findByEmailAndPassword(email, password);
        } catch (DataAccessException e) {
            // Log or handle the specific exception related to data access
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
    public AdminEntity getAdminByEmail(String email) {
        // Assuming you have a method in your AdminRepo to find an admin by ID
        Optional<AdminEntity> optionalAdmin = Optional.ofNullable(adminRepo.findByEmail(email));

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
    @Override
    public List<AdminEntity> getAdmins() {
        return adminRepo.findAll();
    }
}

