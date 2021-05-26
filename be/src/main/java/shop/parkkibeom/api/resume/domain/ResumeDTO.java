package shop.parkkibeom.api.resume.domain;

import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDTO {

    private Long resumeId;
    private String title;
    private String selfIntroduce;
    private String detail;
    private Long artistId;
    private String username;
    private String name;
    private Long categoryId;
    private String categoryName;

    private List<ResumeFileDTO> resumeFiles;

}
