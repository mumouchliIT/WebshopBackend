//package mu.webshop.controller;
//
//import mu.webshop.entity.AdminEntity;
//import mu.webshop.service.AdminService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//
//public class AdminControllerTest {
//    @InjectMocks
//    private AdminController adminController;
//    @Mock
//    private AdminService adminService;
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//
//    }
//
////    @Test
////    void testDeleteAdminSuccess() {
////        // Mocking the behavior of adminService
////        when(adminService.getAdminByEmail(anyString())).thenReturn(new AdminEntity(1,"test","mu3@hotmail.com","123","test"));
////
////        // Assuming the delete operation is successful
////        doNothing().when(adminService).deleteAdmin(anyLong());
////
////        // Call the method to test
////        ResponseEntity<String> responseEntity = adminController.deleteAdmin("mu3@hotmail.com");
////
////        // Assertions
////        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
////        assertEquals("Admin deleted successfully", responseEntity.getBody());
////    }
////
////    @Test
////    void testDeleteAdminNotFound() {
////        // Mocking the behavior of adminService when the admin is not found
////        when(adminService.getAdminByEmail(anyString())).thenReturn(null);
////
////        // Call the method to test
////        ResponseEntity<String> responseEntity = adminController.deleteAdmin("nonexistent@example.com");
////
////        // Assertions
////        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
////        assertEquals("Admin not found", responseEntity.getBody());
////    }
////
////    @Test
////    void testDeleteAdminError() {
////        // Mocking the behavior of adminService when an exception occurs
////        when(adminService.getAdminByEmail(anyString())).thenThrow(new RuntimeException("Simulated error"));
////
////        // Call the method to test
////        ResponseEntity<String> responseEntity = adminController.deleteAdmin("admin@example.com");
////
////        // Assertions
////        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
////        assertEquals("Error occurred while deleting Admin", responseEntity.getBody());
////    }
//
//}
