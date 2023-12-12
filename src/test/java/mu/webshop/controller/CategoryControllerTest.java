//package mu.webshop.controller;
//import mu.webshop.entity.CategoryEntity;
//import mu.webshop.service.CategoryService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//class CategoryControllerTest {
//
//    @Mock
//    private CategoryService categoryService;
//
//    @InjectMocks
//    private CategoryController categoryController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
////    @Test
////    void addCategory() {
////        // Arrange
////        CategoryEntity category = new CategoryEntity(/* provide necessary data */);
////        when(categoryService.addCategory(category)).thenReturn(category);
////
////        // Act
////        ResponseEntity<CategoryEntity> response = categoryController.addCategory(category);
////
////        // Assert
////        assertEquals(HttpStatus.CREATED, response.getStatusCode());
////        assertEquals(category, response.getBody());
////        verify(categoryService, times(1)).addCategory(category);
////    }
////
////    @Test
////    void getAllCategories() {
////        // Arrange
////        CategoryEntity category1 = new CategoryEntity(/* provide necessary data for category1 */);
////        CategoryEntity category2 = new CategoryEntity(/* provide necessary data for category2 */);
////        List<CategoryEntity> categories = Arrays.asList(category1, category2);
////        when(categoryService.getAllCategories()).thenReturn(categories);
////
////        // Act
////        ResponseEntity<List<CategoryEntity>> response = categoryController.getAllCategories();
////
////        // Assert
////        assertEquals(HttpStatus.OK, response.getStatusCode());
////        assertEquals(categories, response.getBody());
////        verify(categoryService, times(1)).getAllCategories();
////    }
//
////    @Test
////    void getCategoryById() {
////        // Arrange
////        int categoryId = 1;
////        CategoryEntity category = new CategoryEntity(/* provide necessary data */);
////        when(categoryService.getCategoryById(categoryId)).thenReturn(Optional.of(category));
////
////        // Act
////        ResponseEntity<CategoryEntity> response = categoryController.getCategoryById(categoryId);
////
////        // Assert
////        assertEquals(HttpStatus.OK, response.getStatusCode());
////        assertEquals(category, response.getBody());
////        verify(categoryService, times(1)).getCategoryById(categoryId);
////    }
////
////    @Test
////    void getCategoryByIdNotFound() {
////        // Arrange
////        int categoryId = 1;
////        when(categoryService.getCategoryById(categoryId)).thenReturn(Optional.empty());
////
////        // Act
////        ResponseEntity<CategoryEntity> response = categoryController.getCategoryById(categoryId);
////
////        // Assert
////        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
////        verify(categoryService, times(1)).getCategoryById(categoryId);
////    }
////
////    @Test
////    void deleteCategory() {
////        // Arrange
////        int categoryId = 1;
////
////        // Act
////        ResponseEntity<Void> response = categoryController.deleteCategory(categoryId);
////
////        // Assert
////        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
////        verify(categoryService, times(1)).deleteCategory(categoryId);
////    }
//}
