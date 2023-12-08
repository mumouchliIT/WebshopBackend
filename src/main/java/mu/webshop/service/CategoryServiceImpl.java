package mu.webshop.service;

import mu.webshop.entity.CategoryEntity;
import mu.webshop.entity.ProductEntity;
import mu.webshop.repo.CategoryRepo;
import mu.webshop.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepository;
    private final ProductRepo productRepository;
    public CategoryServiceImpl(CategoryRepo categoryRepository, ProductRepo productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CategoryEntity addProductToCategory(Integer categoryId, Integer productId){
        Optional<CategoryEntity> catOpt = categoryRepository.findById(categoryId);
        Optional<ProductEntity> proOpt = productRepository.findById(productId);

        if (catOpt.isPresent() && proOpt.isPresent()){
            CategoryEntity cat = catOpt.get();
            ProductEntity product = proOpt.get();

            cat.getProducts().add(product);
            product.getCategories().add(cat);
            return categoryRepository.save(cat);
        }
        else return null;
    }
    @Override
    public void addCategory(CategoryEntity category) {
        try {
            categoryRepository.save(category);
        } catch (Exception e) {
            // Log the exception or handle it as needed
            throw new RuntimeException("An error occurred while adding category", e);
        }
    }
    @Override
    public List<CategoryEntity> getCategories() {
        return categoryRepository.findAll();
    }
    @Override
    public Optional<CategoryEntity> getCategoryById(int categoryId) {
        try {
            return categoryRepository.findById(categoryId);
        } catch (Exception e) {
            // Log the exception or handle it as needed
            throw new RuntimeException("An error occurred while fetching category by ID", e);
        }
    }
    @Override
    public void deleteCategory(int categoryId) {
        try {
            categoryRepository.deleteById(categoryId);
        } catch (Exception e) {
            // Log the exception or handle it as needed
            throw new RuntimeException("An error occurred while deleting category by ID", e);
        }
    }
}
