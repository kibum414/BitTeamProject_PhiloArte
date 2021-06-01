package shop.parkkibeom.api.art.domain;

import lombok.*;
import shop.parkkibeom.api.artist.domain.ArtistDTO;
import shop.parkkibeom.api.category.domain.CategoryDTO;
import shop.parkkibeom.api.resume.domain.ResumeDTO;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArtDTO {

    // Art
    private Long artId;

    private String title;

    private String description;

    private String mainImg;

    private LocalDateTime regDate;

    // Artist
    private ArtistDTO artist;

    // Category
    private CategoryDTO category;

    // Resume
    private ResumeDTO resume;

    // ArtFile
    private List<ArtFileDTO> files;

}
