package shop.parkkibeom.api.art.service;

import org.springframework.web.multipart.MultipartFile;
import shop.parkkibeom.api.art.domain.ArtFile;

import java.util.List;

public interface ArtFileService {
    List<ArtFileDto> uploadFiles(List<MultipartFile> files);
    List<ArtFileDto> updateFiles(List<MultipartFile> files);
    Long deleteFiles(Long fileId);

    default ArtFile dtoToEntity(ArtFileDto artFileDto) {
        return ArtFile.builder()
                .uuid(artFileDto.getUuid())
                .originalFileName(artFileDto.getOriginalFileName())
                .saveFileName(artFileDto.getSaveFileName())
                .fileSize(artFileDto.getFileSize())
                .build();
    }
}
