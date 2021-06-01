package shop.parkkibeom.api.art.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArtFileDTO {

    // ArtFile
    private Long fileId;

    private String uuid;

    private String originalFileName;

    private String saveFileName;

    // Art
    private ArtDTO art;

}
