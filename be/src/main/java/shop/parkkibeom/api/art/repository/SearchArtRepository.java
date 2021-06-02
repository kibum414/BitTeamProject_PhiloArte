package shop.parkkibeom.api.art.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import shop.parkkibeom.api.art.domain.Art;

public interface SearchArtRepository {

    Art search();

    Page<Object[]> searchPage(String type, String keyword, Pageable pageable);

}
