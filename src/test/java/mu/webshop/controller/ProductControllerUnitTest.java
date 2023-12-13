package mu.webshop.controller;
import mu.webshop.entity.ProductEntity;
import mu.webshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ProductControllerUnitTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setUp() {
        // Initialize mock objects and inject them into the controller
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProduct() {
        // Create a sample product
        ProductEntity sampleProduct = new ProductEntity("Test Product", 29.99, "Description", "photo.jpg", Collections.emptySet());

        // Mock the productService to return the sample product when adding a product
        when(productService.addProduct(sampleProduct)).thenReturn(sampleProduct);

        // Call the controller method
        ResponseEntity<ProductEntity> responseEntity = productController.addProduct(sampleProduct);

        // Verify that the response status is HttpStatus.CREATED (201)
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        // Verify that the returned product matches the sample product
        assertThat(responseEntity.getBody()).isEqualTo(sampleProduct);

        // Verify that the productService.addProduct method was called once with the sample product
        verify(productService, times(1)).addProduct(sampleProduct);
    }

    @Test
    public void testGetProductById() {
        // Mock data
        ProductEntity sampleProduct = new ProductEntity("Test Product", 29.99, "Description", "photo.jpg", Collections.emptySet());

        // Mock the productService to return the sample product when fetching by ID
        when(productService.getProductById(1)).thenReturn(java.util.Optional.of(sampleProduct));

        // Call the controller method
        ResponseEntity<ProductEntity> responseEntity = productController.getProductById(1);

        // Verify that the response status is HttpStatus.OK (200)
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        // Verify that the returned product matches the sample product
        assertThat(responseEntity.getBody()).isEqualTo(sampleProduct);

        // Verify that the productService.getProductById method was called once with the ID 1
        verify(productService, times(1)).getProductById(1);
    }
}
