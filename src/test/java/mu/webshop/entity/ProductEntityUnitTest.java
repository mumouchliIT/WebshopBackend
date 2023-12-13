package mu.webshop.entity;

import mu.webshop.entity.CategoryEntity;
import mu.webshop.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductEntityUnitTest {

    @Test
    public void testGetterAndSetterMethods() {
        // Create a sample product
        ProductEntity product = new ProductEntity();

        // Set values using setter methods
        product.setId(1);
        product.setName("Test Product");
        product.setPrice(29.99);
        product.setDescription("Description");
        product.setPhotoURL("photo.jpg");

        // Create a category
        CategoryEntity category = new CategoryEntity();
        category.setId(1);
        category.setName("TestCategory");

        // Set categories using the addCategory method
        product.getCategories().add(category);

        // Verify values using getter methods
        assertThat(product.getId()).isEqualTo(1);
        assertThat(product.getName()).isEqualTo("Test Product");
        assertThat(product.getPrice()).isEqualTo(29.99);
        assertThat(product.getDescription()).isEqualTo("Description");
        assertThat(product.getPhotoURL()).isEqualTo("photo.jpg");

        // Verify categories
        assertThat(product.getCategories()).containsExactly(category);
    }

    @Test
    public void testCustomLogic() {
        // Create a sample product
        ProductEntity product = new ProductEntity();
        product.setId(1);
        product.setName("Test Product");
        product.setPrice(29.99);
        product.setDescription("Description");
        product.setPhotoURL("photo.jpg");

        // Create a category
        CategoryEntity category = new CategoryEntity();
        category.setId(1);
        category.setName("TestCategory");

        // Set categories using the addCategory method
        product.getCategories().add(category);

        double totalPrice = product.getPrice();
        double expectedTotalPrice = 29.99;

        // Verify the result of the custom logic
        assertThat(totalPrice).isEqualTo(expectedTotalPrice);
    }
}
