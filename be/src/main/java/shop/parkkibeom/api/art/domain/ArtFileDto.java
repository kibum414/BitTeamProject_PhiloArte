package shop.parkkibeom.api.art.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ArtFileDto {

    private Long fileId;

    private String uuid;

    private String originalFileName;

    private String saveFileName;

    private long fileSize;

    private Art art;

}
