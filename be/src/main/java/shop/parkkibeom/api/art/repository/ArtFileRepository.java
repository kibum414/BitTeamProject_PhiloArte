package shop.parkkibeom.api.art.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.parkkibeom.api.art.domain.ArtFile;

@Repository
public interface ArtFileRepository extends JpaRepository<ArtFile, Long> {

    @Transactional
    @Modifying
    @Query("delete from ArtFile a where a.fileId = :fileId")
    int deleteByFileId(@Param("fileId") Long fileId);

}
