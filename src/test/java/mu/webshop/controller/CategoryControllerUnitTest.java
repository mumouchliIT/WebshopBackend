package mu.webshop.controller;

import mu.webshop.entity.CategoryEntity;
import mu.webshop.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CategoryControllerUnitTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCategory() {
        // Create a sample category
        CategoryEntity sampleCategory = new CategoryEntity("Test Category");

        // Mock the categoryService to return success
        doNothing().when(categoryService).addCategory(sampleCategory);

        // Call the controller method
        ResponseEntity<String> responseEntity = categoryController.addCategory(sampleCategory);

        // Verify that the response status is HttpStatus.OK (200)
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        // Verify that the response body contains the success message
        assertThat(responseEntity.getBody()).isEqualTo("Category added successfully");

        // Verify that the categoryService.addCategory method was called once with the sample category
        verify(categoryService, times(1)).addCategory(sampleCategory);
    }

    @Test
    public void testAddProductToCategory() {
        // Mock data
        int categoryId = 1;
        int productId = 2;
        CategoryEntity updatedCategory = new CategoryEntity("Updated Category");

        // Mock the categoryService to return the updated category
        when(categoryService.addProductToCategory(categoryId, productId)).thenReturn(updatedCategory);

        // Call the controller method
        ResponseEntity<CategoryEntity> responseEntity = categoryController.addProductToCategory(categoryId, productId);

        // Verify that the response status is HttpStatus.OK (200)
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        // Verify that the returned category matches the updated category
        assertThat(responseEntity.getBody()).isEqualTo(updatedCategory);

        // Verify that the categoryService.addProductToCategory method was called once with the specified IDs
        verify(categoryService, times(1)).addProductToCategory(categoryId, productId);
    }

    @Test
    public void testGetCategories() {
        // Mock data
        List<CategoryEntity> categories = Collections.singletonList(new CategoryEntity("Test Category"));

        // Mock the categoryService to return the sample categories
        when(categoryService.getCategories()).thenReturn(categories);

        // Call the controller method
        ResponseEntity<List<CategoryEntity>> responseEntity = categoryController.getCategories();

        // Verify that the response status is HttpStatus.OK (200)
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        // Verify that the returned categories match the sample categories
        assertThat(responseEntity.getBody()).isEqualTo(categories);

        // Verify that the categoryService.getCategories method was called once
        verify(categoryService, times(1)).getCategories();
    }

    @Test
    public void testGetCategoryById() {
        // Mock data
        int categoryId = 1;
        CategoryEntity sampleCategory = new CategoryEntity("Test Category");

        // Mock the categoryService to return the sample category when fetching by ID
        when(categoryService.getCategoryById(categoryId)).thenReturn(Optional.of(sampleCategory));

        // Call the controller method
        ResponseEntity<CategoryEntity> responseEntity = categoryController.getCategoryById(categoryId);

        // Verify that the response status is HttpStatus.OK (200)
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        // Verify that the returned category matches the sample category
        assertThat(responseEntity.getBody()).isEqualTo(sampleCategory);

        // Verify that the categoryService.getCategoryById method was called once with the specified ID
        verify(categoryService, times(1)).getCategoryById(categoryId);
    }

    @Test
    public void testGetCategoryByIdNotFound() {
        // Mock data
        int categoryId = 1;

        // Mock the categoryService to return an empty optional, simulating not found
        when(categoryService.getCategoryById(categoryId)).thenReturn(Optional.empty());

        // Call the controller method
        ResponseEntity<CategoryEntity> responseEntity = categoryController.getCategoryById(categoryId);

        // Verify that the response status is HttpStatus.NOT_FOUND (404)
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

        // Verify that the categoryService.getCategoryById method was called once with the specified ID
        verify(categoryService, times(1)).getCategoryById(categoryId);
    }

    @Test
    public void testDeleteCategory() {
        // Mock data
        int categoryId = 1;

        // Mock the categoryService to delete the category
        doNothing().when(categoryService).deleteCategory(categoryId);

        // Call the controller method
        ResponseEntity<Void> responseEntity = categoryController.deleteCategory(categoryId);

        // Verify that the response status is HttpStatus.NO_CONTENT (204)
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

        // Verify that the categoryService.deleteCategory method was called once with the specified ID
        verify(categoryService, times(1)).deleteCategory(categoryId);
    }
}
