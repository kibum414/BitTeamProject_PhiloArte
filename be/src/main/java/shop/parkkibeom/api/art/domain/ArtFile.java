package shop.parkkibeom.api.art.domain;

import lombok.*;
import shop.parkkibeom.api.common.domain.BaseEntity;

import javax.persistence.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "art_files")
public class ArtFile extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long fileId;

    @Column
    private String uuid;

    @Column
    private String originalFileName;

    @Column
    private String saveFileName;

    @Column
    private long fileSize;

    @ManyToOne
    @JoinColumn(name = "art_id")
    private Art art;

    public void setArt(Art art) {
        this.art = art;
    }

}
