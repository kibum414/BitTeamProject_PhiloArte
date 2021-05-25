package shop.parkkibeom.api.art.service;

import org.springframework.data.domain.Page;
import shop.parkkibeom.api.art.domain.*;
import shop.parkkibeom.api.artist.domain.Artist;
import shop.parkkibeom.api.category.domain.Category;
import shop.parkkibeom.api.resume.domain.Resume;

import java.util.List;
import java.util.stream.Collectors;

public interface ArtService {
    Long register(ArtDto artDto);
    PageResultDTO<ArtDto, Object[]> getArtList(PageRequestDTO pageRequestDTO);

    ArtDto get(Long artId);

    ArtDto getArtsByArtId(Long artId);
    List<ArtFile> getFilesByArtId(Long artId);

    default Art dtoToEntity(ArtDto artDto) {
        return Art.builder()
                .title(artDto.getTitle())
                .description(artDto.getDescription())
                .mainImg(artDto.getMainImg())
                .artist(Artist.builder().artistId(artDto.getArtist().getArtistId()).build())
                .category(Category.builder().categoryId(artDto.getCategory().getCategoryId()).build())
                .resume(Resume.builder().resumeId(artDto.getResume().getResumeId()).build())
                .build();
    }

    default ArtDto entityToDto(Art art, Artist artist, Category category, Resume resume, ArtFile artFile) {
        return ArtDto.builder()
                .artId(art.getArtId())
                .title(art.getTitle())
                .description(art.getDescription())
                .mainImg(art.getMainImg())
                .artist(artist)
                .category(category)
                .resume(resume)
                .files(getFilesByArtId(art.getArtId()).stream().map(this::entityToDtoFiles).collect(Collectors.toList()))
                .build();
    }

    default ArtFile dtoToEntityFiles(ArtFileDto artFileDto) {
        return ArtFile.builder()
                .uuid(artFileDto.getUuid())
                .originalFileName(artFileDto.getOriginalFileName())
                .saveFileName(artFileDto.getSaveFileName())
                .art(artFileDto.getArt())
                .build();
    }

    default ArtFileDto entityToDtoFiles(ArtFile artFile) {
        return ArtFileDto.builder()
                .fileId(artFile.getFileId())
                .uuid(artFile.getUuid())
                .originalFileName(artFile.getOriginalFileName())
                .saveFileName(artFile.getSaveFileName())
                .art(artFile.getArt())
                .build();
    }
}
