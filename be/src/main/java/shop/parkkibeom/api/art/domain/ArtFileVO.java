package shop.parkkibeom.api.art.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ArtFileVO {
    ArtDTO artDTO;
    List<MultipartFile> files;
}
