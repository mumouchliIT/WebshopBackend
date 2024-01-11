package mu.webshop.controller;

import mu.webshop.entity.AdminEntity;
import mu.webshop.service.AdminService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class AdminControllerUnitTest {

    @Mock
    private AdminService adminService;

    @InjectMocks
    private AdminController adminController;

    @Mock
    private Logger logger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void testAddAdmin() {
//        AdminEntity admin = new AdminEntity();
//        when(adminService.addAdmin(admin)).thenReturn(admin);
//
//        ResponseEntity<String> responseEntity = adminController.add(admin);
//
//        //assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
//        assertEquals("New Admin is added", responseEntity.getBody());
//        assertNotNull(responseEntity.getHeaders().getLocation());
//
//        verify(adminService, times(1)).addAdmin(admin);
//    }

    @Test
    public void testDeleteAdmin() {
        String email = "admin@example.com";
        AdminEntity admin = new AdminEntity();
        admin.setId(1);
        when(adminService.getAdminByEmail(email)).thenReturn(admin);

        ResponseEntity<String> responseEntity = adminController.deleteAdmin(email);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Admin deleted successfully", responseEntity.getBody());

        verify(adminService, times(1)).deleteAdmin((long) admin.getId());
    }

    @Test
    public void testDeleteAdminNotFound() {
        String email = "nonexistent@example.com";
        when(adminService.getAdminByEmail(email)).thenReturn(null);

        ResponseEntity<String> responseEntity = adminController.deleteAdmin(email);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Admin not found", responseEntity.getBody());

        verify(adminService, never()).deleteAdmin(anyLong());
    }

    @Test
    public void testGetAdmin() {
        String email = "admin@example.com";
        AdminEntity admin = new AdminEntity();
        when(adminService.getAdminByEmail(email)).thenReturn(admin);

        ResponseEntity<AdminEntity> responseEntity = adminController.getAdmin(email, null);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(admin, responseEntity.getBody());

        verify(adminService, times(1)).getAdminByEmail(email);
    }

    @Test
    public void testGetAdminNotFound() {
        String email = "nonexistent@example.com";
        when(adminService.getAdminByEmail(email)).thenReturn(null);

        ResponseEntity<AdminEntity> responseEntity = adminController.getAdmin(email, null);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals(null, responseEntity.getBody());

        verify(adminService, times(1)).getAdminByEmail(email);
    }

    @Test
    public void testGetAllAdmins() {
        List<AdminEntity> admins = Arrays.asList(new AdminEntity(), new AdminEntity());
        when(adminService.getAdmins()).thenReturn(admins);

        ResponseEntity<List<AdminEntity>> responseEntity = adminController.getAllAdmins();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(admins, responseEntity.getBody());

        verify(adminService, times(1)).getAdmins();
    }

    @Test
    public void testGetAllAdminsNotFound() {
        when(adminService.getAdmins()).thenReturn(Arrays.asList());

        ResponseEntity<List<AdminEntity>> responseEntity = adminController.getAllAdmins();

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals(null, responseEntity.getBody());

        verify(adminService, times(1)).getAdmins();
    }
}
