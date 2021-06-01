package shop.parkkibeom.api.art.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.parkkibeom.api.art.domain.Art;

import java.util.List;

@Repository
public interface ArtRepository extends JpaRepository<Art, Long> {
/*
    @Query("SELECT a, t FROM Art a LEFT JOIN a.artist t WHERE a.artId = :artId")
    Object getArtWithArtist(@Param("artId") Long artId);

    @Query("SELECT a, f FROM Art a LEFT JOIN ArtFile f ON f.art = a WHERE a.artId = :artId")
    List<Object[]> getArtWithFile(@Param("artId") Long artId);

    @Query(value = "SELECT a, a.artist, count(f) FROM Art a LEFT JOIN ArtFile f ON f.art = a GROUP BY a", countQuery = "SELECT count(a) FROM Art a")
    Page<Object[]> getArtWithFileCount(Pageable pageable);
 */



    @Query("SELECT a, a.artist, a.category, a.resume, f FROM Art a LEFT JOIN ArtFile f ON f.art = a WHERE a.artId = :artId")
    List<Object[]> getArtByArtId(@Param("artId") Long artId);

    @Query("SELECT a, a.artist, a.category, a.resume, f FROM Art a LEFT JOIN ArtFile f ON f.art = a")
    Page<Object[]> getArts(Pageable pageable);






    @EntityGraph(attributePaths = {"artist", "category", "resume"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT a, a.artist, a.category, a.resume FROM Art a ORDER BY a.artId DESC")
    List<Object[]> getArtsTest(Pageable pageable);

}
