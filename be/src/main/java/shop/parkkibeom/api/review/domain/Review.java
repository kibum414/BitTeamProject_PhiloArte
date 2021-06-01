package shop.parkkibeom.api.review.domain;

import lombok.*;
import shop.parkkibeom.api.art.domain.Art;
import shop.parkkibeom.api.artist.domain.Artist;
import shop.parkkibeom.api.common.domain.BaseEntity;

import javax.persistence.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    @Column(name = "content")
    private String content;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "art_id")
    private Art art;

}
