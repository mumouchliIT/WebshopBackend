package MuWebshop.Webshop.Controller;

import MuWebshop.Webshop.Entity.AdminEntity;
import MuWebshop.Webshop.Service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AdminControllerTest {

    @InjectMocks
    private AdminController adminController;

    @Mock
    private AdminService adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void add() {
        // Mock the behavior of adminService
        when(adminService.addAdmin(any(AdminEntity.class))).thenReturn(new AdminEntity(1, "John", "Doe", "john.doe@example.com", "Role1"));

        AdminEntity admin = new AdminEntity(2, "Johdsn", "Doe@homail.com", "johrtgdcom", "NAMEJSOIE");

        ResponseEntity<String> responseEntity = adminController.add(admin);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(responseEntity.getBody()).isEqualTo("New Admin is added");
    }

    @Test
    void deleteAdmin() {
        // Mock the behavior of adminService.adminExists()
        when(adminService.adminExists(1L)).thenReturn(true);

        ResponseEntity<String> responseEntity = adminController.deleteAdmin(1L);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo("Admin deleted successfully");

        // Verify that deleteAdmin method is called
        verify(adminService, times(1)).deleteAdmin(1L);
    }

    @Test
    void getAdmin() {
        // Mock the behavior of adminService.getAdminById()
        when(adminService.getAdminById(1L)).thenReturn(new AdminEntity(1, "John", "Doe", "john.doe@example.com", "Role1"));

        ResponseEntity<AdminEntity> responseEntity = adminController.getAdmin(1L);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isNotNull();
        assertThat(responseEntity.getBody().getName()).isEqualTo("John");
    }
}
