package shop.parkkibeom.api.art.domain;

import lombok.*;
import shop.parkkibeom.api.artist.domain.Artist;
import shop.parkkibeom.api.category.domain.Category;
import shop.parkkibeom.api.common.domain.BaseEntity;
import shop.parkkibeom.api.resume.domain.Resume;

import javax.persistence.*;

@Getter
@ToString
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

}
