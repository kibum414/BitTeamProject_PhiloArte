package shop.parkkibeom.api.art.service;

import org.springframework.data.domain.Page;
import shop.parkkibeom.api.art.domain.Art;
import shop.parkkibeom.api.art.domain.ArtDto;
import shop.parkkibeom.api.art.domain.ArtFile;
import shop.parkkibeom.api.art.domain.ArtFileDto;

import java.util.List;
import java.util.stream.Collectors;

public interface ArtService {
    Page<ArtDto> getAllArtsPaging();
    ArtDto getArtsByArtId(Long artId);
    List<ArtFile> getFilesByArtId(Long artId);

    default Art dtoToEntity(ArtDto artDto) {
        return Art.builder()
                .title(artDto.getTitle())
                .description(artDto.getDescription())
                .mainImg(artDto.getMainImg())
                .build();
    }

    default ArtDto entityToDto(Art art) {
        return ArtDto.builder()
                .artId(art.getArtId())
                .title(art.getTitle())
                .description(art.getDescription())
                .mainImg(art.getMainImg())
                .files(getFilesByArtId(art.getArtId()).stream().map(this::entityToDtoFiles).collect(Collectors.toList()))
                .artist(art.getArtist())
                .category(art.getCategory())
                .build();

    }

    default ArtFile dtoToEntityFiles(ArtFileDto artFileDto) {
        return ArtFile.builder()
                .fileId(artFileDto.getFileId())
                .uuid(artFileDto.getUuid())
                .originalFileName(artFileDto.getOriginalFileName())
                .saveFileName(artFileDto.getSaveFileName())
                .fileSize(artFileDto.getFileSize())
                .art(artFileDto.getArt())
                .build();
    }

    default ArtFileDto entityToDtoFiles(ArtFile artFile) {
        return ArtFileDto.builder()
                .fileId(artFile.getFileId())
                .uuid(artFile.getUuid())
                .originalFileName(artFile.getOriginalFileName())
                .saveFileName(artFile.getSaveFileName())
                .fileSize(artFile.getFileSize())
                .art(artFile.getArt())
                .build();
    }
}
