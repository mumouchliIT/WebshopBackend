package mu.webshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "Product")
@Getter
@Setter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_ID")
    private int id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "photoURL", length = 255)
    private String photoURL;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "Product_Category",
            joinColumns = @JoinColumn(name = "product_ID"),
            inverseJoinColumns = @JoinColumn(name = "category_ID")
    )
    private Set<CategoryEntity> categories = new HashSet<>();

    // Default constructor
    public ProductEntity() {
    }
    public ProductEntity(String name, double price, String description, String photoURL, Set<CategoryEntity> categories) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.photoURL = photoURL;
        this.categories = categories;
    }


}
