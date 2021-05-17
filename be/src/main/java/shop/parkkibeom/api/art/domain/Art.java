package shop.parkkibeom.api.art.domain;

import lombok.Data;
import shop.parkkibeom.api.artist.domain.Artist;
import shop.parkkibeom.api.category.domain.Category;
import shop.parkkibeom.api.common.domain.BaseTimeEntity;
import shop.parkkibeom.api.resume.domain.Resume;

import javax.persistence.*;

@Data
@Entity
@Table(name = "arts")
public class Art extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column
    private long artId;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String mainImg;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    Artist artist;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

}
