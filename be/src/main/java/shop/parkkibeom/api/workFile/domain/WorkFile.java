package shop.parkkibeom.api.workFile.domain;

import lombok.*;
import shop.parkkibeom.api.art.domain.Art;
import shop.parkkibeom.api.common.domain.BaseEntity;

import javax.persistence.*;
import java.util.UUID;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "work_files")
public class WorkFile extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long fileId;

    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "ofile_name")
    private String ofileName;

    @Column(name = "rep_img")
    private String repImg;

    @ManyToOne
    @JoinColumn(name = "art_id")
    private Art art;

}
