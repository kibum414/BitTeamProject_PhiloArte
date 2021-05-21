package shop.parkkibeom.api.upload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.parkkibeom.api.upload.entity.Performance;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {
}
