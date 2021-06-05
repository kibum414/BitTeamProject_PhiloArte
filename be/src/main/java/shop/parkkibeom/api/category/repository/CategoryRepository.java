package shop.parkkibeom.api.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.parkkibeom.api.category.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
