package shop.parkkibeom.api.art.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.parkkibeom.api.art.domain.Art;
import shop.parkkibeom.api.art.domain.ArtFile;

import java.util.List;

@Repository
public interface ArtRepository extends JpaRepository<Art, Long> {

    @Query("SELECT a, f FROM Art a LEFT JOIN ArtFile f ON f.art = a WHERE a.artId = :artId")
    List<Object[]> getArtWithFile(@Param("artId") Long artId);

    @Query(value = "SELECT a, t, count(f) FROM Art a LEFT JOIN ArtFile f ON f.art = a GROUP BY a", countQuery = "SELECT count(a) FROM Art a")
    Page<Object[]> getArtWithFileCount(Pageable pageable);

    @EntityGraph(attributePaths = {"artist", "category", "resume", "artist.roles"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT a FROM Art a JOIN ArtFile f ON f.art = a")
    Page<Object[]> getArts(Pageable pageable);

    //@Query("SELECT a, t, c, r, f FROM Art a LEFT JOIN a.artist t LEFT JOIN a.category c LEFT JOIN a.resume r LEFT JOIN ArtFile f ON f.art = a WHERE a.artId = :artId")
    //Object getArtsByArtId(@Param("artId") Long artId);

}
