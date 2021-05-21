package shop.parkkibeom.api.upload.service;

import shop.parkkibeom.api.upload.dto.PerformanceDTO;
import shop.parkkibeom.api.upload.dto.PicturesDTO;
import shop.parkkibeom.api.upload.entity.Performance;
import shop.parkkibeom.api.upload.entity.Pictures;

public interface PerformanceService {

    Long register(PerformanceDTO performanceDTO);

    default Performance dtoToEntity(PerformanceDTO dto) {

        Performance entity = Performance.builder()
                .pno(dto.getPno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();

        return entity;
    }

    default Pictures dtoToEntityPictures(PicturesDTO dto) {

        Pictures picture = Pictures.builder()
                .pnum(dto.getPnum())
                .fname(dto.getFname())
                .uuid(dto.getUuid())
                .first(dto.isFirst())
                .build();

        return picture;
    }

}
