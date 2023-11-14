package MuWebshop.Webshop.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Admin")
@Getter
@Setter
@Builder

public class AdminEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="admin_ID", length = 45)
    private int id;
    @Column(name="admin_name", length = 255)
    private String name;
    @Column(name="admin_email", length = 255)
    private String email;
    @Column(name="admin_password", length = 255)
    private String password;
    @Column(name="admin_webshopName", length = 255)
    private String webshopName;

    public AdminEntity() {
    }

    public AdminEntity(int id, String name, String email, String password, String webshopName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.webshopName = webshopName;
    }

    @Override
    public String toString() {
        return "AdminEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", webshopName='" + webshopName + '\'' +
                '}';
    }
}
