package MuWebshop.Webshop.Repo;

import MuWebshop.Webshop.Entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<AdminEntity,Long> {
    AdminEntity findByEmailAndPassword(String email, String password);
    AdminEntity findByEmail(String email);
}