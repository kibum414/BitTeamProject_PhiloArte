package shop.philoarte.api.funding.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import shop.philoarte.api.funding.domain.Funding;
import shop.philoarte.api.funding.domain.FundingDTO;
import shop.philoarte.api.funding.domain.FundingFile;
import shop.philoarte.api.funding.domain.FundingFileDTO;
import shop.philoarte.api.funding.domain.FundingPageDTO;
import shop.philoarte.api.funding.domain.PageRequestDTO;

public interface FundingService {
    String save(FundingDTO requestDto);

    List<Funding> getAllFundings();

    default Funding dtoToEntity(FundingDTO dto) {
        Funding funding = Funding.builder().fundingId(dto.getFundingId()).title(dto.getTitle())
                .content(dto.getContent()).goalPrice(dto.getGoalPrice()).hashtag(dto.getHashtag()).build();
        return funding;
    }

    FundingDTO getFundingById(long id);

    String delete(FundingDTO postDto);

    void deleteById(long id);

    List<FundingDTO> getListByHashtag(FundingDTO dto, String hashtag);

    // ============fileservice below==============
    default FundingFile dtoToEntityFundingFile(FundingFileDTO dto) {

        FundingFile fundingFile = FundingFile.builder().fundingFileId(dto.getFundingFileId()).uuid(dto.getUuid())
                .fname(dto.getFname()).build();
        return fundingFile;
    }

    // List<FundingDto> fileBoxByFunding(Long id);
    List<FundingFileDTO> registerFile(MultipartFile[] uploadFiles);

    String deleteFile(Long fundingFileId);

    // ============Pagingservice Below==============
    FundingPageDTO<FundingDTO, Funding> getList(int page);

    default Pageable conditionPage(int page) {
        return PageRequest.of(page <= 0 ? 1 : page - 1, 8, Sort.Direction.DESC, "fundingId");
    }

    default Function<Funding, FundingDTO> makeDtoPage() {
        return (en -> pageentityToDto(en));
    }

    FundingPageDTO<FundingDTO, Funding> getPageById(PageRequestDTO requestDto, Long id);

    FundingPageDTO<FundingDTO, Funding> getPageByArtistId(PageRequestDTO requestDto, Long id);

    FundingPageDTO<FundingDTO, Funding> searchTitleAndContent(PageRequestDTO requestDto, String keyword);

    FundingPageDTO<FundingDTO, Funding> getByartistName(PageRequestDTO requestDto, String name);

    default Funding pagedtoToEntity(FundingDTO dto) {
        Funding entity = Funding.builder().fundingId(dto.getFundingId()).title(dto.getTitle()).content(dto.getContent())
                .goalPrice(dto.getGoalPrice()).hashtag(dto.getHashtag())
                // .artist(Artist.builder().artistId(dto.getFundingId()).build())
                .build();
        return entity;
    }

    default FundingDTO pageentityToDto(Funding entity) {
        return FundingDTO.builder().fundingId(entity.getFundingId()).title(entity.getTitle())
                .content(entity.getContent()).goalPrice(entity.getGoalPrice()).hashtag(entity.getHashtag())
                .viewCnt(entity.getViewCnt()).artistId(entity.getArtist().getArtistId())
                .name(entity.getArtist().getName()).fundingFiles(entity.getFundingFiles().stream()
                        .map(fundingFile -> FundingFileDTO.of(fundingFile)).collect(Collectors.toList()))
                .build();
    }
}