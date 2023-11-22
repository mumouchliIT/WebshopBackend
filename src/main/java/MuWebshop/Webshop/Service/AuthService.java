package MuWebshop.Webshop.Service;

import MuWebshop.Webshop.Config.TokenGenerator;
import MuWebshop.Webshop.Entity.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
public class AuthService {

    @Autowired
    private AdminService adminService;
    @Autowired
    private TokenGenerator tokenGenerator;
    public String authenticate(AdminEntity admin) {
        AdminEntity oauthUser = adminService.login(admin.getEmail(), admin.getPassword());

        if (Objects.nonNull(oauthUser)) {
            // Authentication successful, generate a token
            String token = tokenGenerator.generateToken(admin);
            return token;
        } else {
            // Authentication failed
            return null;
        }
    }
}
