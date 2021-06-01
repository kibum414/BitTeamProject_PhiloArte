package shop.parkkibeom.api.resume.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import shop.parkkibeom.api.artist.domain.Artist;
import shop.parkkibeom.api.category.domain.Category;
import shop.parkkibeom.api.common.domain.BaseEntity;

import javax.persistence.*;

@Getter
@ToString(exclude = {"artist", "category"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resumes")
public class Resume extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id")
    private Long resumeId;

    @Column(name = "title")
    private String title;

    @Column(name = "self_introduce")
    private String selfIntroduce;

    @Column(name = "detail")
    private String detail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
