package shop.parkkibeom.api.art.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.parkkibeom.api.art.domain.ArtDto;
import shop.parkkibeom.api.art.domain.ArtFile;
import shop.parkkibeom.api.art.domain.ArtFileDto;
import shop.parkkibeom.api.art.repository.ArtFileRepository;
import shop.parkkibeom.api.common.service.AbstractService;
import shop.parkkibeom.api.art.domain.Art;
import shop.parkkibeom.api.art.repository.ArtRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArtServiceImpl extends AbstractService<ArtDto> implements ArtService {

    private final ArtRepository artRepository;
    private final ArtFileRepository artFileRepository;

    @Transactional
    @Override
    public Long save(ArtDto artDto) {
        Art art = dtoToEntity(artDto);

        artRepository.save(art);

        List<ArtFileDto> artFileDtos = artDto.getFiles();

        if (artFileDtos != null && artFileDtos.size() > 0) {
            artFileDtos.forEach(artFileDto -> {
                ArtFile artFile = dtoToEntityFiles(artFileDto);
                artFile.setArt(art);
                artFileRepository.save(artFile);
            });
        }

        return art.getArtId();
    }

    // 전체 목록 -> 대표 이미지만 보이면 됨
    // 상세 -> 해당 artId에 맞는 파일들 전부 다 보여야 됨
    @Override
    public Page<ArtDto> getAllArtsPaging() {
        Pageable pageable = PageRequest.of(0, 10);

        return artRepository.getAllArtsPaging(pageable).map(this::entityToDto);
    }

    @Override
    public ArtDto getArtsByArtId(Long artId) {
        return entityToDto(artRepository.getArtByArtId(artId));
    }

    @Override
    public List<ArtFile> getFilesByArtId(Long artId) {
        return artFileRepository.getFilesByArtId(artId);
    }

    @Transactional
    @Override
    public Long delete(ArtDto artDto) {
        artRepository.deleteById(artDto.getArtId());

        return (findById(artDto.getArtId()).orElse(null) == null) ? 1L : 0L;
    }




    @Override
    public Long count() {
        return artRepository.count();
    }

    @Override
    public Boolean existsById(long id) {
        return artRepository.existsById(id);
    }

    @Override
    public List<ArtDto> findAll() {
        return null;
    }

    @Override
    public Optional<ArtDto> findById(long id) {
        return null;
    }

    @Override
    public Optional<ArtDto> getOne(long id) {
        return null;
    }
}
