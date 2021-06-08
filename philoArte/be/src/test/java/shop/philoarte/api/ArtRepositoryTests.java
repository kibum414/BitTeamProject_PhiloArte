package shop.philoarte.api;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import shop.philoarte.api.art.repository.ArtRepository;

import java.util.Arrays;

@SpringBootTest
@Log4j2
public class ArtRepositoryTests {

    @Autowired
    private ArtRepository artRepository;

    @Test
    public void getArtsByResumeId() {

        Page<Object[]> result = artRepository.getArtsByArtistId(PageRequest.of(0, 10, Sort.by("artId").descending()), 10L);

        result.get().forEach(arr -> {
            System.out.println(Arrays.toString(arr));
        });

    }
}
