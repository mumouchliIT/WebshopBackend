package mu.webshop.service;

import mu.webshop.entity.CategoryEntity;
import mu.webshop.entity.ProductEntity;
import mu.webshop.repo.CategoryRepo;
import mu.webshop.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepository;
    public ProductServiceImpl(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public ProductEntity addProduct(ProductEntity product) {
        return productRepository.save(product);
    }
    @Override
    public List<ProductEntity> getProducts() {
        return productRepository.findAll();
    }
    @Override
    public Optional<ProductEntity> getProductById(int productId) {
        try {
            return productRepository.findById(productId);
        } catch (Exception e) {
            // Log the exception or handle it as needed
            throw new RuntimeException("An error occurred while fetching product by ID", e);
        }
    }
    @Override
    public void deleteProduct(int productId) {
        try {
            productRepository.deleteById(productId);
        } catch (Exception e) {
            // Log the exception or handle it as needed
            throw new RuntimeException("An error occurred while deleting product by ID", e);
        }
    }
    @Override
    public List<ProductEntity> getProductsWithCategories() {
        List<ProductEntity> products = productRepository.findAll();
        // Initialize categories for each product
        products.forEach(product -> product.getCategories().size());
        return products;
    }
}
