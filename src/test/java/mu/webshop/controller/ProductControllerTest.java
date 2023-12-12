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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void addProduct() {
//        // Arrange
//        ProductEntity product = new ProductEntity(/* provide necessary data */);
//        when(productService.addProduct(product)).thenReturn(product);
//
//        // Act
//        ResponseEntity<ProductEntity> response = productController.addProduct(product);
//
//        // Assert
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(product, response.getBody());
//        verify(productService, times(1)).addProduct(product);
//    }

//    @Test
//    void getAllProducts() {
//        // Arrange
//        ProductEntity product1 = new ProductEntity(/* provide necessary data for product1 */);
//        ProductEntity product2 = new ProductEntity(/* provide necessary data for product2 */);
//        List<ProductEntity> products = Arrays.asList(product1, product2);
//        when(productService.getAllProducts()).thenReturn(products);
//
//        // Act
//        ResponseEntity<List<ProductEntity>> response = productController.getAllProducts();
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(products, response.getBody());
//        verify(productService, times(1)).getAllProducts();
//    }

//    @Test
//    void getProductById() {
//        // Arrange
//        int productId = 1;
//        ProductEntity product = new ProductEntity(/* provide necessary data */);
//        when(productService.getProductById(productId)).thenReturn(Optional.of(product));
//
//        // Act
//        ResponseEntity<ProductEntity> response = productController.getProductById(productId);
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(product, response.getBody());
//        verify(productService, times(1)).getProductById(productId);
//    }
//
//    @Test
//    void getProductByIdNotFound() {
//        // Arrange
//        int productId = 1;
//        when(productService.getProductById(productId)).thenReturn(Optional.empty());
//
//        // Act
//        ResponseEntity<ProductEntity> response = productController.getProductById(productId);
//
//        // Assert
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        verify(productService, times(1)).getProductById(productId);
//    }
//
//    @Test
//    void deleteProduct() {
//        // Arrange
//        int productId = 1;
//
//        // Act
//        ResponseEntity<Void> response = productController.deleteProduct(productId);
//
//        // Assert
//        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
//        verify(productService, times(1)).deleteProduct(productId);
//    }
}
