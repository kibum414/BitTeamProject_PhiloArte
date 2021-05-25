package shop.parkkibeom.api.art.domain;

import lombok.*;
import shop.parkkibeom.api.common.domain.BaseEntity;

import javax.persistence.*;

@Getter
@ToString(exclude = "art")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "art_id")
    private Art art;

    public void setArt(Art art) {
        this.art = art;
    }

}

/*
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ArtFileDto {

    // ArtFile
    private Long fileId;

    private String uuid;

    private String originalFileName;

    private String saveFileName;

    // Art
    private Art art;

}
 */