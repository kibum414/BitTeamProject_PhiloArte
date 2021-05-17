package shop.parkkibeom.api.review.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import shop.parkkibeom.api.art.domain.Art;
import shop.parkkibeom.api.artist.domain.Artist;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    @Column(name = "content")
    private String content;

    @Column(name = "comment")
    private String comment;

    // @ManyToOne
    // @JoinColumn(name = "funding_id")
    // private Funding funding;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "art_id")
    private Art art;

}
