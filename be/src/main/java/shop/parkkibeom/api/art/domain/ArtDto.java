package shop.parkkibeom.api.art.domain;

import lombok.*;
import org.springframework.stereotype.Component;
import shop.parkkibeom.api.artist.domain.Artist;
import shop.parkkibeom.api.category.domain.Category;
import shop.parkkibeom.api.resume.domain.Resume;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ArtDto {

    private Long artId;

    private String title;

    private String description;

    private String mainImg;

    private List<ArtFileDto> files;

    private Artist artist;

    private Category category;

    private Resume resume;

}
