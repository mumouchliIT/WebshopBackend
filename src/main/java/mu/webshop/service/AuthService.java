package mu.webshop.service;

import mu.webshop.config.TokenGenerator;
import mu.webshop.entity.AdminEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AuthService {
    private final AdminService adminService;
    private final TokenGenerator tokenGenerator;
    public AuthService(AdminService adminService, TokenGenerator tokenGenerator) {
        this.adminService = adminService;
        this.tokenGenerator = tokenGenerator;
    }
    public String authenticate(AdminEntity admin) {
        AdminEntity oauthUser = adminService.login(admin.getEmail(), admin.getPassword());

        if (Objects.nonNull(oauthUser)) {
            // Authentication successful, generate a token
            return tokenGenerator.generateToken(admin);
        } else {
            // Authentication failed
            return null;
        }
    }
}
