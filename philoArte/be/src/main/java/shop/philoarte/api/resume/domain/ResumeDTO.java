package shop.philoarte.api.resume.domain;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.philoarte.api.common.util.ModelMapperUtils;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder

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

    public static ResumeDTO of(Resume resume) {
        ResumeDTO resumeDto = ModelMapperUtils.getModelMapper().map(resume, ResumeDTO.class);
        return resumeDto;
    }

}
