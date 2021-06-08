package shop.philoarte.api.resume.domain;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.philoarte.api.common.util.ModelMapperUtils;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResumeFileDTO {

    private Long resumeFileId;
    private String uuid;
    private String fname;
    private Boolean repImg;
    private String fileTitle;
    private String fileDetail;
    private String fileWorkedDate;

    public static ResumeFileDTO of(ResumeFile resumeFile) {
        ResumeFileDTO resumeFileDto = ModelMapperUtils.getModelMapper().map(resumeFile, ResumeFileDTO.class);
        return resumeFileDto;
    }

}
