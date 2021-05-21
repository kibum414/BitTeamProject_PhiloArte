package shop.parkkibeom.api.crawling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.parkkibeom.api.resume.domain.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
