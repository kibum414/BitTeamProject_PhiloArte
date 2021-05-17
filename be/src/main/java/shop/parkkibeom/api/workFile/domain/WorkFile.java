package shop.parkkibeom.api.workFile.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import shop.parkkibeom.api.art.domain.Art;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "work_files")
public class WorkFile {

    @Id
    @GeneratedValue
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
