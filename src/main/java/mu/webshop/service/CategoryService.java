package mu.webshop.service;

import mu.webshop.entity.CategoryEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    void addCategory(CategoryEntity category);
    CategoryEntity addProductToCategory(Integer categoryId, Integer productId);
    List<CategoryEntity> getCategories();
    Optional<CategoryEntity> getCategoryById(int categoryId);
    void deleteCategory(int categoryId);
}
