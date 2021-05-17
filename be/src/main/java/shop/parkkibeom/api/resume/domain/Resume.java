package shop.parkkibeom.api.resume.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import shop.parkkibeom.api.artist.domain.Artist;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id")
    private Long resumeId;

    @Column(name = "title")
    private String title;

    @Column(name = "detail")
    private String detail;

    @Column(name = "main_pic")
    private String mainPic;

    @Column(name = "main_pic_title")
    private String mainPicTitle;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

}
