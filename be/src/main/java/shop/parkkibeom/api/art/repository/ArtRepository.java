package shop.parkkibeom.api.art.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.parkkibeom.api.art.domain.Art;

@Repository
public interface ArtRepository extends JpaRepository<Art, Long> {
}
