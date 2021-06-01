package shop.parkkibeom.api.art.service;

import org.springframework.web.multipart.MultipartFile;
import shop.parkkibeom.api.art.domain.Art;
import shop.parkkibeom.api.art.domain.ArtFile;
import shop.parkkibeom.api.art.domain.ArtFileDTO;

import java.util.List;

public interface ArtFileService {
    List<ArtFileDTO> uploadFiles(List<MultipartFile> files, Long artId);
    List<ArtFileDTO> updateFiles(List<MultipartFile> files);
    Long deleteFiles(Long fileId);

    default ArtFile dtoToEntity(ArtFileDTO artFileDTO) {
        return ArtFile.builder()
                .uuid(artFileDTO.getUuid())
                .originalFileName(artFileDTO.getOriginalFileName())
                .saveFileName(artFileDTO.getSaveFileName())
                .art(Art.builder().artId(artFileDTO.getArt().getArtId()).build())
                .build();
    }
}
