package mu.webshop.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mu.webshop.entity.CategoryEntity;
@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer> {

}
