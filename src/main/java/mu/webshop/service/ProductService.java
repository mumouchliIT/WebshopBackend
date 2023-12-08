package mu.webshop.service;
import mu.webshop.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductEntity addProduct(ProductEntity product);
    List<ProductEntity> getProducts();
    Optional<ProductEntity> getProductById(int productId);
    void deleteProduct(int productId);
    public List<ProductEntity> getProductsWithCategories();
}
