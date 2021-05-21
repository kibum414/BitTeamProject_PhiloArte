package shop.parkkibeom.api.crawling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.parkkibeom.api.category.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
