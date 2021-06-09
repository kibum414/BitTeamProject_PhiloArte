package shop.parkkibeom.api;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import shop.parkkibeom.api.art.domain.*;
import shop.parkkibeom.api.art.repository.ArtFileRepository;
import shop.parkkibeom.api.art.repository.ArtRepository;
import shop.parkkibeom.api.art.service.ArtService;
import shop.parkkibeom.api.artist.domain.Artist;
import shop.parkkibeom.api.category.domain.Category;
import shop.parkkibeom.api.resume.domain.Resume;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
@Log4j2
public class ArtRepositoryTests {

    @Autowired
    private ArtService artService;

    @Autowired
    private ArtRepository artRepository;

    @Autowired
    private ArtFileRepository artFileRepository;

    @Test
    public void testSaveArts() {

        for (int i = 0; i < 30; i++) {
            artRepository.save(
                    Art.builder()
                            .title("제목 " + i)
                            .description("설명 " + i)
                            .mainImg("이미지 " + i)
                            .artist(Artist.builder().artistId((long) (Math.random() * 404 + 1)).build())
                            .category(Category.builder().categoryId((long) (Math.random() * 3 + 1)).build())
                            .resume(Resume.builder().resumeId((long) (Math.random() * 100 + 1)).build())
                            .build());
        }

//        artRepository.insertData(
//                "[INTERVIEW] 싱그러운 꽃잎에 담긴 진심, 박진희",
//                "플로리스트는 꽃을 여러 가지 목적에 따라 보기 좋게 꾸미는 일을 하는 사람을 뜻한다. 명칭에서 알 수 있듯이 이들의 업무는 단순히 여러 꽃을 모아 다발을 만들어 파는 것에서 끝나지 않는다. 보기 좋게 꾸민다는 건 장식의 개념을 넘어서 꽃이 가진 가치와 의미를 새로 부여하는 것으로까지 발전 가능성을 열어 두어야 한다.",
//                "http://www.yck.kr/_data/file/bbsData/86d2f471ffc196ee508845737375d38d.jpg");
//        artRepository.insertData(
//                "[ISSUE] 날 사랑한 적이 있긴 하니? 진부한 텍스트 속 진심을 탐구하는, 작가 이정",
//                "원앤제이 갤러리 소속 아티스트이자, 설치미술 및 사진 작가로 알려진 이정이 아트 바젤 홍콩 2021에 참여한다. 이정은 풍경 속에 직접 설치된 텍스트 기반의 조명 사진으로 주목 받은 바 있다. 이정 작가는 자신의 작품 속에 텍스트를 등장시킴으로써, 역설적으로 텍스트가 가지는 한계에 대해 이야기 한다.",
//                "http://www.yck.kr/_data/file/bbsData/8efd1af19be7e9023323be500c9039e0.png"
//        );
//        artRepository.insertData(
//                "[REVIEW] 북한산의 풍광과 한옥의 아름다움을 한번에, 은평 한옥마을",
//                "지하철 3호선 구파발역에서 버스를 타고 10분 정도 가면 나오는 은평 한옥마을은 21세기 서울형 한옥 주거 단지다. 관광지가 아닌, 주거 단지가 목적이었기 때문에 이곳의 한옥들은 라이프스타일에 맞춰 모습을 바꿨다. 한옥의 정체성은 유지하면서 생활의 편리함을 추구했기 때문에 다세대형과 2층형 등 다양한 모습의 한옥을 발견할 수 있다.",
//                "http://www.yck.kr/_data/file/bbsData/ec403cc084dfe1bb2cf6ce14bdeb744c.jpg"
//        );
//        artRepository.insertData(
//                "[INTERVIEW] 알다가도 모를 흥미진진한 오브제, 정그림",
//                "무언가를 만드는 사람, 그 무언가가 물음표 가득한 무언가이길 바랐던 정그림은 부속의 재료를 주재료로 사용해 물체의 쓸모를 재정의한다. 고무 튜브, 실리콘, 스틸, 혹은 또 다른 무언가로 구성된 ‘모노’ 시리즈는 만지기 전까지 형태의 질감조차 가늠하기 어렵다.",
//                "http://www.yck.kr/_data/file/bbsData/20323a51d1ba61107eeda1a3e012e12a.jpg"
//        );
//        artRepository.insertData(
//                "[INTERVIEW] 색의 가능성을 발견하다, 최수진",
//                "최수진에게 색은 가능성이다. 색은 그림 안에서 어떤 것이든 될 수 있다. 하다못해 색더미가 되더라도, 그 안에서 색을 발굴해내는 나의 모습이 주제가 될 수도 있다. 최수진은 이런 색의 가능성을 믿고, 팔레트에 색을 펼친다. 펼쳐지는 찰나, 그는 또 새로운 가능성을 발견하겠지.",
//                "http://www.yck.kr/_data/file/bbsData/5ca75731b80f47e303ab970e900718ba.jpg"
//        );
//        artRepository.insertData(
//                "[INTERVIEW] 펑크 밴드의 아트디렉터가 된 일러스트레이터 ‘오햄킹’",
//                "국내 펑크 밴드 DTSQ의 아트 디렉터, 오햄킹의 뿌리는 일러스트레이터다. 잠시 그리는 행위가 권태롭다고 느껴졌을 때 태블릿PC을 잡은 게 화근이었다. 더이상 좋아하는 일이 없을 줄만 알았는데...",
//                "http://www.yck.kr/_data/file/bbsData/9bdd7bea71ef277c9ba02e69592d3e7f.jpg"
//        );
//        artRepository.insertData(
//                "[SPECIAL] 2021년, 5월은 농담의 달. 많이 웃어둡시다.",
//                "“5월이 지나고 나면 9월까지 휴일이 없대.” “농담이지?” 6월 6일 현충일은 일요일, 8월 15일 광복절도 일요일이다. 9월 지나 10월은 더 얄궃다. 10월 3일 개천절은 일요일, 10월 9일 한글날은 토요일이다. 대미를 장식할 크리스마스는? 역시나 토요일이다. '설마.... 농담이지?' 정말 농담이라 믿고 싶다.",
//                "http://www.yck.kr/_data/file/bbsData/e2c45bed25fe5a16e7b86af04db02319.png"
//        );
//        artRepository.insertData(
//                "[INTERVIEW]특별한 가족사진을 만들어드립니다, '글래머샷'",
//                "작년 이맘때쯤, 한 지인이 인스타그램에 ‘결혼 1주년 기념으로 다 때려 부쉈다’라는 글과 함께 사진을 올렸다. 마치 할리우드 액션 영화의 한 장면처럼 총을 들고 타오르는 화염 속에서 두 인물이 튀어 오르며 등장하고 있는 사진이었다.",
//                "http://www.yck.kr/_data/file/bbsData/ceafcabc89e4b8e7ab2f4aed9169a0ac.png"
//        );
//        artRepository.insertData(
//                "[INTERVIEW] 철저한 익명들의 시니컬한 유머, ooo 작가",
//                "한 페이지 짜리를 열 장으로 늘리는 것과 열 장 짜리를 한 페이지로 줄이는 것 중에 더 어려운 일은 단연코 후자다. 말을 엿가락처럼 끊임없이 늘리는 건 쉬운 일이다. 하지만 무수히 많은 말들 중 핵심을 짚어내는 건 문맥을 완벽히 이해하는 건 물론, 글에 대한 통찰과 센스도 필요한 일이다.",
//                "http://www.yck.kr/_data/file/bbsData/33bf1fa14c354a37c9c520f843bfcea3.jpg"
//        );
//        artRepository.insertData(
//                "[INTERVIEW] 냉소를 담은 유머, 유머를 담은 냉소로 세상을 그리는 '순이지' 작가",
//                "세상이 유머러스한 요소들로만 가득차 있다면, 사람들은 매일같이 하하호호 웃으며 행복할까. 아니면 그 상황 자체를 다양한 감정이 배제되고 웃음으로 일소되는 비관적인 상황으로 받아들일까. 순이지 작가는 개인의 내외면 세상에서 벌어지는 현상과 아이러니를, 작가 특유의 냉소적이고 음울한 유머감각으로 포착해 그려낸다.",
//                "http://www.yck.kr/_data/file/bbsData/d99789f091d5c9df2b58754212eecca9.png"
//        );
//        artRepository.insertData(
//                "[INTERVIEW] \"어머 이건 먹어야 돼\" 먹툰을 그리는 다이어터, 25일",
//                "25일의 본업은 '일러스트레이터'지만, 전업은 '다이어터'다. 또한, 음식을 좋아하고 다이어트를 평생의 업으로 생각하는 '평범한 사람'이다. 평범함은 그에게 독이 아닌 득이 되었다. 마치 오래 알고 지내던 친구처럼, 마음을 대변해 주는 한마디로 사람들의 좋아요를 몰고 왔고, 그는 수많은 밈을 보유한 '짤 부자'가 되었다.",
//                "http://www.yck.kr/_data/file/bbsData/3ed3af8515da48f03ff6bbd43d3de850.png"
//        );
    }

    @Test
    public void testSaveArtFiles() {

        String uuid;
        for (int i = 0; i < 30; i++) {
            uuid = UUID.randomUUID().toString();
            artFileRepository.save(
                    ArtFile.builder()
                            .uuid(uuid)
                            .originalFileName("Vuex.png")
                            .savedFileName(uuid + "_Vuex.png")
                            .art(Art.builder().artId((long) (Math.random() * 27 + 104)).build())
                            .build());
        }
    }

    @Test
    public void testDelete() {

    }

    @Transactional
    @Test
    public void testRead1() {
        Optional<Art> result = artRepository.findById(121L);

        Art art = result.get();

        System.out.println(art);
        System.out.println(art.getArtist());
    }

    /*
    @Test
    public void testArtWithArtist() {
        Object result = artRepository.getArtWithArtist(121L);

        Object[] arr = (Object[]) result;

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testGetArtWithFile() {
        List<Object[]> result = artRepository.getArtWithFile(121L);
        for (Object[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    @Test
    public void testWithFileCount() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("artId").descending());

        Page<Object[]> result = artRepository.getArtWithFileCount(pageable);

        result.get().forEach(row -> {
            Object[] arr = (Object[]) row;

            System.out.println(Arrays.toString(arr));
        });
    }
    */

    @Test
    public void testRegister() {
//        ArtDTO artDTO = ArtDTO.builder()
//                .title("Test.")
//                .description("Test...")
//                .mainImg("Test.......")
//                .artist(Artist.builder().artistId(100L).build())
//                .category(Category.builder().categoryId(2L).build())
//                .resume(Resume.builder().resumeId(10L).build())
//                .build();
//
//        System.out.println(artService.register(artDTO));
    }

    @Test
    public void testRead3() {
//        Object result = artRepository.getArtByArtId(123L);
//
//        Object[] arr = (Object[]) result;
//
//        System.out.println(Arrays.toString(arr));
    }

    @Transactional
    @Test
    public void testList() {
//        PageRequestDTO pageRequestDTO = new PageRequestDTO();
//
//        PageResultDTO<ArtDTO, Object[]> result = artService.getList(pageRequestDTO);
//
//        for (ArtDTO artDTO : result.getDtoList()) {
//            System.out.println(artDTO);
//        }
    }

    @Transactional
    @Test
    public void testGet() {
        ArtDTO artDTO = artService.get(123L);

        System.out.println(artDTO);
    }

    @Test
    public void testArts() {

        Page<Object[]> result = artRepository.getArtsss(PageRequest.of(0, 10, Sort.by("artId").descending()));

        result.get().forEach(arr -> {
            System.out.println(Arrays.toString(arr));
            System.out.println("--------------------------");
        });

    }

    @Test
    public void testArtsTest() {
        List<Object[]> result = artRepository.getArtsTest(PageRequest.of(0, 10));

        result.forEach(arr -> {
            System.out.println(Arrays.toString(arr));
        });
    }

    @Test
    public void testRemove() {
        artService.delete(112L);
    }

    @Transactional
    @Commit
    @Test
    public void testModify() {

        ArtDTO artDTO = ArtDTO.builder()
                .artId(133L)
                .title("제목 변경")
                .description("내용 변경")
                .mainImg("메인 이미지 변경")
                .build();

        System.out.println("--------------변경 준비");
        System.out.println(artService.modify(artDTO));
        System.out.println("--------------변경 완료");

    }

    @Test
    public void updateTest() {

        Optional<Art> result = artRepository.findById(161L);

        if(result.isPresent()) {

            Art art = result.get();

            art.changeTitle("Changed Title...");
            art.changeDescription("Changed Description...");

            artRepository.save(art);

        }

    }

    @Test
    public void testQuery1() {

//        Pageable pageable = PageRequest.of(0, 10, Sort.by("artId").descending());
//
//        QArt qArt = QArt.art; // 동적으로 처리하기 위해 Q도메인 클래스 얻어옴. 엔티티 클래스에 선언된 필드들을 변수로 활용 가능
//
//        String keyword = "1";
//
//        BooleanBuilder builder = new BooleanBuilder(); // BooleanBuilder : where 문에 들어가는 조건들을 넣어주는 컨테이너
//
//        BooleanExpression expression = qArt.title.contains(keyword); // 원하는 조건은 필드 값과 같이 결합해서 생성
//
//        builder.and(expression); // 만들어진 조건은 where 문의 and 나 or 같은 키워드와 결합
//
//        Page<Art> result = artRepository.findAll(builder, pageable); // BooleanBuilder는 QuerydslPredicateExcutor 인터페이스의 findAll() 사용 가능
//
//        result.stream().forEach(art -> {
//            System.out.println(art);
//        });

    }

    @Test
    public void testQuery2() {

//        Pageable pageable = PageRequest.of(0, 10, Sort.by("artId").descending());
//
//        QArt qArt = QArt.art;
//
//        String keyword = "1";
//
//        BooleanBuilder builder = new BooleanBuilder();
//
//        BooleanExpression exTitle = qArt.title.contains(keyword);
//
//        BooleanExpression exDescription = qArt.description.contains(keyword);
//
//        BooleanExpression exAll = exTitle.or(exDescription); // exTitle과 exDescription라는 BooleanExpression을 결합
//
//        builder.and(exAll); // BooleanBuilder에 추가
//
//        builder.and(qArt.artId.gt(0L)); // artId > 0
//
//        Page<Art> result = artRepository.findAll(builder, pageable);
//
//        result.stream().forEach(art -> {
//            System.out.println(art);
//        });

    }

    @Test
    public void testSearch1() {
        PageRequestDTO pageRequestDto = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .type("t")
                .keyword("유아연")
                .build();
        PageResultDTO<ArtDTO, Object[]> reviewDtoReviewPageResultDto = artService.getList(pageRequestDto);
        System.out.println("prev : " + reviewDtoReviewPageResultDto.isPrev());
        System.out.println("next : " + reviewDtoReviewPageResultDto.isNext());
        System.out.println("total : " + reviewDtoReviewPageResultDto.getTotalPage());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        for (ArtDTO reviewDto : reviewDtoReviewPageResultDto.getDtoList()) {
            System.out.println(reviewDto);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        reviewDtoReviewPageResultDto.getPageList().forEach(i -> System.out.println(i));
    }

    @Test
    public void testSearchPage() {

        Pageable pageable =
                PageRequest.of(0, 10,
                        Sort.by("artId").descending()
                                .and(Sort.by("title").ascending()));

        Page<Object[]> result = artRepository.searchPage("", "", pageable);

        System.out.println(result);

    }

    @Test
    public void testFindFile() {

        System.out.println(artFileRepository.findByUuid("1db5dc1c-6d96-4277-be4e-0165a118bec7"));

    }

}
