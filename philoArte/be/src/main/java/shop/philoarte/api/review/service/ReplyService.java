package shop.philoarte.api.review.service;

import shop.philoarte.api.review.domain.Reply;
import shop.philoarte.api.review.domain.Review;
import shop.philoarte.api.review.domain.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {

    Long save(ReplyDTO replyDto);

    void remove(Long rno);

    void modify(ReplyDTO replyDto);


    List<ReplyDTO> getList(Long reviewId);

    default Reply dtoToEntity(ReplyDTO replyDto) {
        Review review = Review.builder().reviewId(replyDto.getReviewId()).build();

        Reply reply = Reply.builder()
                .rno(replyDto.getRno())
                .text(replyDto.getText())
                .replyer(replyDto.getReplyer())
                .uuid(replyDto.getUuid())
                .imageName(replyDto.getImgName())
                .path(replyDto.getPath())
                .review(review)
                .build();

        return reply;
    }

    default ReplyDTO entityToDto(Reply reply) {
        ReplyDTO replyDto = ReplyDTO.builder()
                .rno(reply.getRno())
                .text(reply.getText())
                .uuid(reply.getUuid())
                .imgName(reply.getImageName())
                .path(reply.getPath())
                .reviewId(reply.getReview().getReviewId())
                .replyer(reply.getReplyer())
                .regDate(reply.getRegDate())
                .modDate(reply.getModDate())
                .build();

        return replyDto;
    }

}
