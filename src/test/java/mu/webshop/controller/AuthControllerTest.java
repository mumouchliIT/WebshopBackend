package mu.webshop.controller;

import mu.webshop.entity.AdminEntity;
import mu.webshop.service.AuthService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AuthControllerTest {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    public AuthControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void login_SuccessfulLogin() {
        // Arrange
        AdminEntity admin = new AdminEntity(2, "s", "test@example.com", "password", "sd");
        when(authService.authenticate(admin)).thenReturn("mockedToken");

        // Act
        ResponseEntity<String> response = authController.login(admin);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("mockedToken", response.getBody());
        verify(authService, times(1)).authenticate(admin);
    }

    @Test
    void login_FailedLogin() {
        // Arrange
        AdminEntity admin = new AdminEntity(1,"test@example.com", "invalidPassword", "s", "s");
        when(authService.authenticate(admin)).thenReturn(null);

        // Act
        ResponseEntity<String> response = authController.login(admin);

        // Assert
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals("Invalid credentials", response.getBody());
        verify(authService, times(1)).authenticate(admin);
    }

    @Test
    void login_ExceptionDuringLogin() {
        // Arrange
        AdminEntity admin = new AdminEntity(3, "s", "test@example.com", "password", "sd");
        when(authService.authenticate(admin)).thenThrow(new RuntimeException("Test exception"));

        // Act
        ResponseEntity<String> response = authController.login(admin);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Error during login", response.getBody());
        verify(authService, times(1)).authenticate(admin);
    }
}
