package mu.webshop.controller;

import mu.webshop.config.UserPrincipall;
import mu.webshop.entity.AdminEntity;
import mu.webshop.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@CrossOrigin
public class AdminController {

    private final AdminService adminService;
    private final Logger log = LoggerFactory.getLogger(AuthController.class);
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody AdminEntity admin) {
        try {
            AdminEntity addedAdmin = adminService.addAdmin(admin);

            // Log relevant information about the added admin
            log.info("New Admin added: {}", addedAdmin);

            // Include the Location header in the response
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(addedAdmin.getId())
                    .toUri();

            return ResponseEntity.created(location).body("New Admin is added");
        } catch (Exception e) {
            // Log the exception for further investigation
            log.error("Error occurred while adding Admin", e);

            // Return a server error status
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while adding Admin");
        }
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<String> deleteAdmin(@PathVariable String email) {
        try {
            // Check if the admin exists before attempting deletion
            AdminEntity admin = adminService.getAdminByEmail(email);

            if (admin != null) {
                int adminId = admin.getId();
                adminService.deleteAdmin((long) adminId);
                return ResponseEntity.ok("Admin deleted successfully");
            } else {
                // Return HTTP 404 (Not Found) if the admin is not found
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found");
            }
        } catch (Exception e) {
            // Log the exception for further investigation
            log.error("Error occurred while deleting Admin", e);

            // Return a server error status
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting Admin");
        }
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<AdminEntity> getAdmin(@PathVariable String email, @AuthenticationPrincipal UserPrincipall principal) {
        try {
            // Retrieve the admin based on the provided adminId
            AdminEntity admin = adminService.getAdminByEmail(email);

            // Check if the admin is found
            if (admin != null) {
                return ResponseEntity.ok(admin);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            // Log the exception for further investigation
            log.error("Error occurred while retrieving Admin", e);

            // Return a server error status
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<AdminEntity>> getAllAdmins() {
        try {
            // Retrieve all admins
            List<AdminEntity> admins = adminService.getAdmins();

            // Check if admins are found
            if (!admins.isEmpty()) {
                return ResponseEntity.ok(admins);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            // Log the exception for further investigation
            log.error("Error occurred while retrieving all Admins", e);

            // Return a server error status
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
