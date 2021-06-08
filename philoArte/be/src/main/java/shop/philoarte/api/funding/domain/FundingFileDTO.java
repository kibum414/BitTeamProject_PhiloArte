package shop.philoarte.api.funding.domain;

import org.springframework.stereotype.Component;

import shop.philoarte.api.common.util.ModelMapperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class FundingFileDTO {
    
    private Long fundingFileId;

    private String uuid;

    private String fname;
    
    // public static List<FundingFileDto> filetoDto(List<FundingFile> fundingFile){
        
    //     return  fundingFile.stream()
    //     .map(p->ModelMapperUtils.getModelMapper()
    //     .map(p, FundingFileDto.class))
    //     .collect(Collectors.toList());
    // }
    public static FundingFileDTO of(FundingFile fundingFile) {
        FundingFileDTO fundingFileDto = ModelMapperUtils.getModelMapper().map(fundingFile, FundingFileDTO.class);
        return fundingFileDto;
    }
}
