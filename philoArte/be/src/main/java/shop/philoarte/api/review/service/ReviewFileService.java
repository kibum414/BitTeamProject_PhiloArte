package shop.philoarte.api.review.service;

import org.springframework.web.multipart.MultipartFile;
import shop.philoarte.api.common.util.ModelMapperUtils;
import shop.philoarte.api.review.domain.ReviewFile;
import shop.philoarte.api.review.domain.dto.ReviewFileDTO;

import java.util.ArrayList;
import java.util.List;

public interface ReviewFileService {
    ArrayList<ReviewFileDTO> saveFile(List<MultipartFile> uploadFiles);
    void reviewFileDelete(Long reviewFileId);

    default ReviewFile dtoToEntity(ReviewFileDTO reviewFileDto){
        ReviewFile reviewFile = ModelMapperUtils.getModelMapper().map(reviewFileDto, ReviewFile.class);

        return reviewFile;
    }

    default ReviewFileDTO entityToDto(ReviewFile reviewFile){
        ReviewFileDTO reviewFileDto = ModelMapperUtils.getModelMapper().map(reviewFile, ReviewFileDTO.class);

        return reviewFileDto;
    }
}
