package mu.webshop.service;

import mu.webshop.entity.ProductEntity;
import mu.webshop.repo.ProductRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceImplUnitTest {

    @Mock
    private ProductRepo productRepo;

    @InjectMocks
    private ProductServiceImpl productService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProduct() {
        ProductEntity product = new ProductEntity();
        when(productRepo.save(product)).thenReturn(product);

        ProductEntity result = productService.addProduct(product);

        assertEquals(product, result);
        verify(productRepo, times(1)).save(product);
    }

    @Test
    public void testGetProducts() {
        List<ProductEntity> productList = Arrays.asList(new ProductEntity(), new ProductEntity());
        when(productRepo.findAll()).thenReturn(productList);

        List<ProductEntity> result = productService.getProducts();

        assertEquals(productList, result);
        verify(productRepo, times(1)).findAll();
    }

    @Test
    public void testGetProductById() {
        int productId = 1;
        ProductEntity product = new ProductEntity();
        when(productRepo.findById(productId)).thenReturn(Optional.of(product));

        Optional<ProductEntity> result = productService.getProductById(productId);

        assertEquals(Optional.of(product), result);
        verify(productRepo, times(1)).findById(productId);
    }

    @Test
    public void testDeleteProduct() {
        int productId = 1;

        productService.deleteProduct(productId);

        verify(productRepo, times(1)).deleteById(productId);
    }

    @Test
    public void testGetProductsWithCategories() {
        List<ProductEntity> productList = Arrays.asList(new ProductEntity(), new ProductEntity());
        when(productRepo.findAll()).thenReturn(productList);

        List<ProductEntity> result = productService.getProductsWithCategories();

        assertEquals(productList, result);
        // Ensure that the categories are initialized for each product
        for (ProductEntity product : result) {
            verify(product, times(1)).getCategories();
        }
        verify(productRepo, times(1)).findAll();
    }
}
