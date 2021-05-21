package shop.parkkibeom.api.crawling.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shop.parkkibeom.api.artist.domain.Artist;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    @EntityGraph(attributePaths = {"roles"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("select a from Artist a order by a.artistId desc")
    List<Artist> getAllData();
}
