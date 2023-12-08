package mu.webshop.repo;

import mu.webshop.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<AdminEntity,Long> {
    AdminEntity findByEmailAndPassword(String email, String password);
    AdminEntity findByEmail(String email);
}