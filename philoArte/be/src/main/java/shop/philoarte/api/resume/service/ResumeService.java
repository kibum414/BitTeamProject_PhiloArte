package shop.philoarte.api.resume.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import shop.philoarte.api.resume.domain.Resume;
import shop.philoarte.api.resume.domain.ResumeDTO;
import shop.philoarte.api.resume.domain.ResumeFile;
import shop.philoarte.api.resume.domain.ResumeFileDTO;
import shop.philoarte.api.resume.domain.page.PageResultDto;

public interface ResumeService {

    String resumeSaveWithFile(ResumeDTO resumeDto);

    String editResume(ResumeDTO resumeDto);

    PageResultDto<ResumeDTO, Resume> getAllDataPaging(int page);

    List<ResumeDTO> getAllResume();

    PageResultDto<ResumeDTO, Resume> getUserPKDataPage(Long artistId, int page);

    PageResultDto<ResumeDTO, Resume> getCategoryPKDataPage(Long categoryId, int page);

    PageResultDto<ResumeDTO, Resume> getCategoryAndUserDataPage(Long categoryId, Long artistId, int page);

    PageResultDto<ResumeDTO, Object[]> conditionSearch(String type, String keyword, int page);

    List<Object[]> countByArtistId(Long artistId);

    public ResumeDTO getById(Long resumeId);

    default ResumeFile dtoToEntityResumeFile(ResumeFileDTO dto) {

        return ResumeFile.builder().resumeFileId(dto.getResumeFileId()).fileTitle(dto.getFileTitle())
                .fileDetail(dto.getFileDetail()).fileWorkedDate(dto.getFileDetail()).uuid(dto.getUuid())
                .fname(dto.getFname()).repImg(dto.getRepImg()).build();
    }

    default ResumeDTO resumeEntityToDto(Resume en) {

        return ResumeDTO.builder().resumeId(en.getResumeId()).title(en.getTitle()).detail(en.getDetail())
                .selfIntroduce(en.getSelfIntroduce()).artistId(en.getArtist().getArtistId())
                .username(en.getArtist().getUsername()).name(en.getArtist().getName())
                .categoryId(en.getCategory().getCategoryId()).categoryName(en.getCategory().getCategoryName())
                .resumeFiles(en.getResumeFiles().stream().map(resumeFile -> ResumeFileDTO.of(resumeFile))
                        .collect(Collectors.toList()))
                .build();
    }

    default Pageable conditionPage(int page) {

        return PageRequest.of(page <= 0 ? 0 : page - 1, 8, Sort.Direction.DESC, "resumeId");

    }

    default Function<Resume, ResumeDTO> makeDtoPage() {

        return (en -> resumeEntityToDto(en));
    }

}
