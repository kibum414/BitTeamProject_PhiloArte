package shop.parkkibeom.api.art.domain;

import lombok.Data;

@Data
public class ArtDto {

    private long artId;
    private String title;
    private String description;
    private String mainImg;

}
