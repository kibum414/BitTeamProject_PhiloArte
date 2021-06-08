package shop.philoarte.api.review.service;

import shop.philoarte.api.artist.domain.Artist;
import shop.philoarte.api.review.domain.Review;
import shop.philoarte.api.review.domain.ReviewFile;
import shop.philoarte.api.review.domain.dto.PageRequestDTO;
import shop.philoarte.api.review.domain.dto.PageResultDTO;
import shop.philoarte.api.review.domain.dto.ReviewDTO;
import shop.philoarte.api.review.domain.dto.ReviewFileDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface ReviewService {
    Long save(ReviewDTO reviewDto);

    ReviewDTO get(Long reviewId);

    void modify(ReviewDTO reviewDto);

    void removeWithReplies(Long reviewId);

    PageResultDTO<ReviewDTO, Object[]> getList(PageRequestDTO PageRequestDto);


    default Map<String, Object> dtoToEntity(ReviewDTO reviewDto) {
        Map<String, Object> entityMap = new HashMap<>();
        Artist artists = Artist.builder().artistId(reviewDto.getWriterId()).build();
        Review review = Review.builder()
                .reviewId(reviewDto.getReviewId())
                .title(reviewDto.getTitle())
                .content(reviewDto.getContent())
                .artist(artists)
                .build();
        entityMap.put("review", review);

        List<ReviewFileDTO> fileDtoList = reviewDto.getReviewFileDtoList();

        if (fileDtoList != null && fileDtoList.size() > 0) {
            List<ReviewFile> reviewFileList = fileDtoList.stream().map(reviewFileDto -> {
                ReviewFile reviewFile = ReviewFile.builder()
                        .reviewFileId(reviewFileDto.getReviewFileId())
                        .path(reviewFileDto.getPath())
                        .imgName(reviewFileDto.getImgName())
                        .uuid(reviewFileDto.getUuid())
                        .review(review)
                        .build();
                return reviewFile;
            }).collect(Collectors.toList());
            entityMap.put("fileList", reviewFileList);
        }
        return entityMap;
    }

    default ReviewDTO entityToDto(Review review, Artist artist, Long replyCount, List<ReviewFile> reviewFiles) {
        ReviewDTO reviewDto = ReviewDTO.builder()
                .reviewId(review.getReviewId())
                .title(review.getTitle())
                .content(review.getContent())
                .regDate(review.getRegDate())
                .modDate(review.getModDate())
                .writerId(artist == null ? 1L : artist.getArtistId())
                .writerName(artist == null ? "" : artist.getName())
                .replyCount(replyCount.intValue())
                .build();
        if(reviewFiles != null && reviewFiles.size() > 0) {
            System.out.println("size : " +reviewFiles.size());
            List<ReviewFileDTO> reviewFileDtoList = reviewFiles.stream().map(reviewFile -> {

                if(reviewFile == null) {
                    return null;
                }
                return ReviewFileDTO.builder()
                        .reviewFileId(reviewFile.getReviewFileId())
                        .imgName(reviewFile.getImgName())
                        .path(reviewFile.getPath())
                        .uuid(reviewFile.getUuid())
                        .build();
            }).collect(Collectors.toList());
            reviewDto.setReviewFileDtoList(reviewFileDtoList);
        }

        reviewDto.setReplyCount(replyCount.intValue());
        return reviewDto;
    }

}
