package shop.philoarte.api.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.philoarte.api.review.domain.Reply;
import shop.philoarte.api.review.domain.Review;
import shop.philoarte.api.review.domain.dto.ReplyDTO;
import shop.philoarte.api.review.repository.ReplyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository repository;


    @Transactional
    @Override
    public Long save(ReplyDTO replyDto) {
        Reply replySave = dtoToEntity(replyDto);

        repository.save(replySave);

        return replyDto.getRno();
    }

    @Override
    public List<ReplyDTO> getList(Long reviewId) {
        List<Reply> result = repository.getRepliesByReviewOrderByRegDate(Review.builder().reviewId(reviewId).build());
        return result.stream().map(reply -> entityToDto(reply)).collect(Collectors.toList());
    }

    @Override
    public void modify(ReplyDTO replyDto) {
        Reply reply = dtoToEntity(replyDto);
        repository.save(reply);
//        repository.deleteById(replyDto.getRno());
////        repository.findById(replyDto.getRno());
//        repository.save(reply);
//        repository.findById(replyDto.getRno());
    }


    @Override
    public void remove(Long rno) {

        repository.deleteById(rno);
    }
}
