package shop.parkkibeom.api.upload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.parkkibeom.api.upload.entity.Pictures;

public interface PicturesRepository extends JpaRepository<Pictures, Long> {
}
