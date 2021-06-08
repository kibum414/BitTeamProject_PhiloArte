package shop.philoarte.api.funding.domain;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import shop.philoarte.api.common.util.ModelMapperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FundingDTO {
    private Long fundingId;
    private String title;
    private String content;
    private long goalPrice;
    private long viewCnt;
    private String hashtag;
    private long artistId;
    private String name;

    private List<FundingFileDTO> fundingFiles;

    // Entity -> Dto
    public static FundingDTO toDto(Funding funding) {
        return ModelMapperUtils.getModelMapper().map(funding, FundingDTO.class);
    }

    // Entity -> Dto(Page)
    public static Page<FundingDTO> toDtoPage(Page<Funding> sourcePage) {
        return sourcePage.map(FundingDTO::toDto);
    }

    public static FundingDTO toDtoList(List<Funding> sendIt) {
        return ModelMapperUtils.getModelMapper().map(sendIt, FundingDTO.class);
    }

    public static List<FundingDTO> tlist(List<Funding> sendIt) {
        return sendIt.stream().map(f -> ModelMapperUtils.getModelMapper().map(f, FundingDTO.class))
                .collect(Collectors.toList());
    }

}
