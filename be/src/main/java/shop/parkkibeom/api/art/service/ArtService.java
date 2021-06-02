package shop.parkkibeom.api.art.service;

import org.springframework.web.multipart.MultipartFile;
import shop.parkkibeom.api.art.domain.*;
import shop.parkkibeom.api.artist.domain.Artist;
import shop.parkkibeom.api.artist.domain.ArtistDTO;
import shop.parkkibeom.api.category.domain.Category;
import shop.parkkibeom.api.category.domain.CategoryDTO;
import shop.parkkibeom.api.resume.domain.Resume;
import shop.parkkibeom.api.resume.domain.ResumeDTO;

import java.util.List;
import java.util.stream.Collectors;

public interface ArtService {
    Long register(ArtDTO artDTO, List<MultipartFile> files);

    PageResultDTO<ArtDTO, Object[]> getList(PageRequestDTO pageRequestDTO); // 목록 처리

    ArtDTO get(Long artId);

    List<ArtFile> getFilesByArtId(Long artId);

    Long delete(Long artId);

    Long modify(ArtDTO artDTO);

    default Art dtoToEntity(ArtDTO artDTO) {
        return Art.builder()
                .title(artDTO.getTitle())
                .description(artDTO.getDescription())
                .mainImg(artDTO.getMainImg())
                .artist(Artist.builder().artistId(artDTO.getArtist().getArtistId()).build())
                .category(Category.builder().categoryId(artDTO.getCategory().getCategoryId()).build())
                .resume(Resume.builder().resumeId(artDTO.getResume().getResumeId()).build())
                .build();
    }

    default ArtDTO entityToDto(Art art, Artist artist, Category category, Resume resume, List<ArtFile> artFileList) {
        return ArtDTO.builder()
                .artId(art.getArtId())
                .title(art.getTitle())
                .description(art.getDescription())
                .mainImg(art.getMainImg())
                .regDate(art.getRegDate())
                .artist(ArtistDTO.builder()
                        .artistId(artist.getArtistId())
                        .username(artist.getUsername())
                        .name(artist.getName())
                        .build())
                .category(CategoryDTO.builder()
                        .categoryId(category.getCategoryId())
                        .categoryName(category.getCategoryName())
                        .build())
                .resume(ResumeDTO.builder().resumeId(resume.getResumeId()).build())
                .files(artFileList.stream().map(this::entityToDtoFiles).collect(Collectors.toList()))
                .build();
    }

    default ArtDTO entityToDtoForList(Art art, Artist artist, Category category, Resume resume) {
        return ArtDTO.builder()
                .artId(art.getArtId())
                .title(art.getTitle())
                .description(art.getDescription())
                .mainImg(art.getMainImg())
                .artist(ArtistDTO.builder()
                        .artistId(artist.getArtistId())
                        .username(artist.getUsername())
                        .name(artist.getName())
                        .build())
                .category(CategoryDTO.builder()
                        .categoryId(category.getCategoryId())
                        .categoryName(category.getCategoryName())
                        .build())
                .resume(ResumeDTO.builder().resumeId(resume.getResumeId()).build())
                .build();
    }

    default ArtFile dtoToEntityFiles(ArtFileDTO artFileDTO) {
        return ArtFile.builder()
                .uuid(artFileDTO.getUuid())
                .originalFileName(artFileDTO.getOriginalFileName())
                .saveFileName(artFileDTO.getSaveFileName())
                .build();
    }

    default ArtFileDTO entityToDtoFiles(ArtFile artFile) {
        return ArtFileDTO.builder()
                .fileId(artFile.getFileId())
                .uuid(artFile.getUuid())
                .originalFileName(artFile.getOriginalFileName())
                .saveFileName(artFile.getSaveFileName())
                .art(ArtDTO.builder()
                        .artId(artFile.getArt().getArtId())
                        .build())
                .build();
    }
}
