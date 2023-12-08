package mu.webshop.controller;

import mu.webshop.entity.CategoryEntity;
import mu.webshop.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCategory(@RequestBody CategoryEntity category) {
        try {
            // Add the new category
            categoryService.addCategory(category);
            return ResponseEntity.ok("Category added successfully");
        } catch (Exception e) {
            // Log the exception for further investigation
            // Return a server error status
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while adding category");
        }
    }
    @PostMapping("/{categoryId}/products/{productId}")
    public ResponseEntity<CategoryEntity> addProductToCategory(@PathVariable Integer categoryId, @PathVariable Integer productId){
        CategoryEntity updatedCategory = categoryService.addProductToCategory(categoryId, productId);
        return ResponseEntity.ok(updatedCategory);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryEntity>> getCategories() {
        try {
            List<CategoryEntity> categories = categoryService.getCategories();
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception or handle it as needed
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getBy/{categoryId}")
    public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable int categoryId) {
        try {
            return categoryService.getCategoryById(categoryId)
                    .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            // Log the exception or handle it as needed
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int categoryId) {
        try {
            categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // Log the exception or handle it as needed
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
