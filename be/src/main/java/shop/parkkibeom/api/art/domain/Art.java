package shop.parkkibeom.api.art.domain;

import lombok.*;
import shop.parkkibeom.api.artist.domain.Artist;
import shop.parkkibeom.api.category.domain.Category;
import shop.parkkibeom.api.common.domain.BaseEntity;
import shop.parkkibeom.api.resume.domain.Resume;

import javax.persistence.*;

@Getter
@ToString(exclude = {"artist", "category", "resume"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "arts")
public class Art extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long artId;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String mainImg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

}

/*
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArtDto {

    // Art
    private Long artId;

    private String title;

    private String description;

    private String mainImg;

    // Artist
    private Artist artist;

    // Category
    private Category category;

    // Resume
    private Resume resume;

    // ArtFile
    private List<ArtFileDto> files;

}
 */