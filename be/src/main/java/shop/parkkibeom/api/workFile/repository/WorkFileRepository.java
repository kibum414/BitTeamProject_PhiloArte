package shop.parkkibeom.api.workFile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.parkkibeom.api.workFile.domain.WorkFile;

public interface WorkFileRepository extends JpaRepository<WorkFile, Long> {
}
