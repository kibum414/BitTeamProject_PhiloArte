package shop.philoarte.api.funding.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import shop.philoarte.api.funding.domain.Funding;
import shop.philoarte.api.funding.domain.FundingDTO;
import shop.philoarte.api.funding.domain.FundingPageDTO;
import shop.philoarte.api.funding.domain.PageRequestDTO;
import shop.philoarte.api.funding.service.FundingServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(tags = "funding")
@RequestMapping("/funding")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FundingPageController {
    private final FundingServiceImpl service;

    @GetMapping("/list")
    public ResponseEntity<FundingPageDTO<FundingDTO, Funding>> list(int page) {

        return ResponseEntity.ok(service.getList(page));
    }

    @GetMapping("/list/{fundingId}")
    public ResponseEntity<FundingPageDTO<FundingDTO, Funding>> getByFundingId(PageRequestDTO requestDto,
                                                                              @PathVariable("fundingId") Long fundingId) {
        return ResponseEntity.ok(service.getPageById(requestDto, fundingId));
    }

    @GetMapping("/list/artistfunding/{artistId}")
    public ResponseEntity<FundingPageDTO<FundingDTO, Funding>> getByArtistId(PageRequestDTO requestDto,
                                                                             @PathVariable("artistId") Long artistId) {
        return ResponseEntity.ok(service.getPageByArtistId(requestDto, artistId));
    }

    @GetMapping("/list/search")
    public ResponseEntity<FundingPageDTO<FundingDTO, Funding>> searchTCInPage(PageRequestDTO requestDto,
                                                                              @RequestParam("keyword") String keyword) {
        return ResponseEntity.ok(service.searchTitleAndContent(requestDto, keyword));
    }

    @GetMapping("/list/artist")
    public ResponseEntity<FundingPageDTO<FundingDTO, Funding>> searchArtistName(PageRequestDTO requestDto,
                                                                                @RequestParam("artistName") String artistName) {
        return ResponseEntity.ok(service.getByartistName(requestDto, artistName));
    }

    // @GetMapping("/listpage/searchsum")
    // public ResponseEntity<Page<FundingDto>>
    // searchTCInPage(@RequestParam("keyword") String keyword, Pageable pageable){
    // return ResponseEntity.ok(service.searchTitleAndContent(pageable, keyword));
    // }

}