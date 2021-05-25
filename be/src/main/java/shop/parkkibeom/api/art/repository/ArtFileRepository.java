package shop.parkkibeom.api.art.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.parkkibeom.api.art.domain.ArtFile;

import java.util.List;

@Repository
public interface ArtFileRepository extends JpaRepository<ArtFile, Long> {

    @EntityGraph(attributePaths = {"art"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT f FROM ArtFile f INNER JOIN f.art a WHERE a.artId = :artId")
    List<ArtFile> getFilesByArtId(@Param("artId") Long artId);

    @Transactional
    @Modifying
    @Query("delete from ArtFile a where a.fileId = :fileId")
    int deleteByFileId(@Param("fileId") Long fileId);

}
