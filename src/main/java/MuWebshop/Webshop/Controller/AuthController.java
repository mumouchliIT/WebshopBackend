package MuWebshop.Webshop.Controller;

import MuWebshop.Webshop.Entity.AdminEntity;
import MuWebshop.Webshop.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final Logger log = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AdminEntity admin) {
        try {
            // Log the login attempt
            log.info("Login attempt for email: {}", admin.getEmail());

            String token = authService.authenticate(admin);

            if (token != null) {
                // Log the successful login
                log.info("Successful login for user with email: {}", admin.getEmail());

                // Return the token or other relevant information
                return ResponseEntity.ok(token);
            } else {
                // Log the failed login attempt
                log.warn("Failed login attempt for email: {}", admin.getEmail());

                // Return an unauthorized status
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } catch (Exception e) {
            // Log the exception for further investigation
            log.error("Exception during login", e);

            // Return a server error status
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during login");
        }
    }

//    @PostMapping("/logout")
//    public ResponseEntity<String> logout(HttpServletRequest request) {
//        try {
//            // Get the user's identifier (e.g., email) from the session
//            String userEmail = request.getUserPrincipal().getName();
//
//            // Log the logout attempt
//            log.info("Logout attempt for user with email: {}", userEmail);
//
//            // Log the successful logout
//            log.info("Successful logout for user with email: {}", userEmail);
//
//            // Return a success status
//            return ResponseEntity.ok("Logout successful");
//        } catch (Exception e) {
//            // Log the exception for further investigation
//            log.error("Exception during logout", e);
//
//            // Return a server error status
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during logout");
//        }
//    }
}
