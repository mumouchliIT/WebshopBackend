package MuWebshop.Webshop.Controller;

import MuWebshop.Webshop.Entity.AdminEntity;
import MuWebshop.Webshop.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
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

    @DeleteMapping("/delete/{adminId}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long adminId) {
        try {
            // Check if the admin exists before attempting deletion
            if (adminService.adminExists(adminId)) {
                adminService.deleteAdmin(adminId);
                return ResponseEntity.ok("Admin deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found");
            }
        } catch (Exception e) {
            // Log the exception for further investigation
            log.error("Error occurred while deleting Admin", e);

            // Return a server error status
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting Admin");
        }
    }

    @GetMapping("/get/{adminId}")
    public ResponseEntity<AdminEntity> getAdmin(@PathVariable Long adminId) {
        try {
            // Retrieve the admin based on the provided adminId
            AdminEntity admin = adminService.getAdminById(adminId);

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

}
