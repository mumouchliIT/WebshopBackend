package mu.webshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Category")
@Getter
@Setter
@Builder
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_ID", length = 45)
    private int id;

    @Column(name="category_name", length = 255)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<ProductEntity> products = new HashSet<>();
    public CategoryEntity() {
    }
    public CategoryEntity(int categoryId) {
        this.id = categoryId;
    }
    public CategoryEntity(int id, String name, Set<ProductEntity> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }
}
