package shop.parkkibeom.api.art.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import shop.parkkibeom.api.art.domain.*;
import shop.parkkibeom.api.art.repository.ArtFileRepository;
import shop.parkkibeom.api.art.repository.ArtRepository;
import shop.parkkibeom.api.artist.domain.Artist;
import shop.parkkibeom.api.category.domain.Category;
import shop.parkkibeom.api.resume.domain.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Log4j2
@RequiredArgsConstructor
@Service
public class ArtServiceImpl implements ArtService {

    private final ArtFileServiceImpl artFileService;

    private final ArtRepository artRepository;

    private final ArtFileRepository artFileRepository;

    @Transactional
    @Override
    public Long register(ArtDTO artDTO, List<MultipartFile> files) {

        Art art = dtoToEntity(artDTO);

        artRepository.save(art);

        log.info(files);

        System.out.println(artFileService.uploadFiles(files, art.getArtId()));

//        List<ArtFileDTO> artFileDtos = artDTO.getFiles();
//
//        if (artFileDtos != null && artFileDtos.size() > 0) {
//            artFileDtos.forEach(artFileDTO -> {
//                ArtFile artFile = dtoToEntityFiles(artFileDTO);
//                artFile.setArt(art);
//                log.info("ArtFile: " + artFile);
//                artFileRepository.save(artFile);
//            });
//        }

        return art.getArtId();

    }

    @Transactional
    @Override
    public PageResultDTO<ArtDTO, Object[]> getArtList(PageRequestDTO pageRequestDTO) {

        Function<Object[], ArtDTO> fn = (entity ->
                entityToDto((Art) entity[0], (Artist) entity[1], (Category) entity[2], (Resume) entity[3], getFilesByArtId(((Art) entity[0]).getArtId())));

        Page<Object[]> result = artRepository.getArts(pageRequestDTO.getPageable(Sort.by("artId").descending()));

        return new PageResultDTO<>(result, fn);

    }

    @Transactional
    @Override
    public ArtDTO get(Long artId) {

        log.info("get() : " + artId);
        List<Object[]> result = artRepository.getArtByArtId(artId);

        log.info("result : " + Arrays.toString(result.get(0)));

        List<ArtFile> artFileList = new ArrayList<>();

        result.forEach(arr -> artFileList.add((ArtFile) arr[4]));

        log.info("artFileList: " + artFileList);

        return entityToDto(
                (Art) result.get(0)[0], (Artist) result.get(0)[1],
                (Category) result.get(0)[2], (Resume) result.get(0)[3],
                artFileList);

    }

    @Override
    public List<ArtFile> getFilesByArtId(Long artId) {

        return artFileRepository.getFilesByArtId(artId);

    }

    @Transactional
    @Override
    public Long delete(Long artId) {

        // 파일 부터 삭제
        artFileRepository.deleteByArtId(artId);

        artRepository.deleteById(artId);

        return artRepository.findById(artId).isPresent() ? 0L : 1L;

    }

    @Override
    public Long modify(ArtDTO artDTO) {

        Art art = artRepository.getOne(artDTO.getArtId());

        System.out.println(art.toString());
        System.out.println(artDTO.toString());

        art.changeTitle(artDTO.getTitle());
        art.changeDescription(artDTO.getDescription());
        art.changeMainImg(artDTO.getMainImg());

        System.out.println(art.toString());
        System.out.println("-------------변경 직전");
        System.out.println(artRepository.save(art));

        return 1L;

    }

}
