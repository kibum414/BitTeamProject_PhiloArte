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

    // 전체 리스트
    @EntityGraph(attributePaths = {"artist", "category"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT a FROM Art a ORDER BY a.artId DESC")
    List<Art> getAllArts();

    // 전체 리스트 페이징
    @EntityGraph(attributePaths = {"artist", "category", "artist.roles"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT a FROM Art a left outer join a.artist.artistId=artist.artistId ORDER BY a.artId DESC")
    Page<Art> getAllArtsPaging(Pageable pageable);

    // ArtId에 맞는 Art
    @EntityGraph(attributePaths = {"artist", "category", "artist.roles"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT a FROM Art a INNER JOIN ArtFile f ON f.art = a WHERE a.artId = :artId")
    Art getArtByArtId(@Param("artId") Long artId);

    @Query("SELECT a FROM Art a WHERE a.artist.username = :username")
    List<Art> searchArtsByUsername(@Param("username") String username);






    @Modifying
    @Query("UPDATE FROM Art a SET a.category.categoryId = :categoryId WHERE a.artId = :artId")
    void updateCategory(@Param("artId") Long artId, @Param("categoryId") Long categoryId);


    @Modifying
    @Query("UPDATE FROM Art a SET a.description = :description WHERE a.artId = :artId")
    int updateDescription(@Param("artId") Long artId, @Param("description") String description);

    @EntityGraph(attributePaths = {"artist", "category", "resume"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("select a from Art a where a.artist.username = :username")
    Page<Art> searchByArtistNamePaging(@Param("username") String username, Pageable pageable);



}
