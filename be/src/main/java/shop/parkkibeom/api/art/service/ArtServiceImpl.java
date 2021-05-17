package shop.parkkibeom.api.art.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.parkkibeom.api.common.service.AbstractService;
import shop.parkkibeom.api.art.domain.Art;
import shop.parkkibeom.api.art.repository.ArtRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArtServiceImpl extends AbstractService<Art> implements ArtService {

    private final ArtRepository artRepository;

    @Override
    public Long count() {
        return artRepository.count();
    }

    @Override
    public Boolean existsById(long id) {
        return artRepository.existsById(id);
    }

    @Override
    public List<Art> findAll() {
        return artRepository.findAll();
    }

    @Override
    public Optional<Art> findById(long id) {
        return artRepository.findById(id);
    }

    @Override
    public Optional<Art> getOne(long id) {
        return Optional.of(artRepository.getOne(id));
    }

    @Override
    public Long save(Art art) {
        System.out.println(art.getTitle());
        return (artRepository.save(art) != null) ? 1L : 0L;
    }

    @Override
    public Long delete(Art art) {
        artRepository.delete(art);

        return (findById(art.getArtId()).orElse(null) == null) ? 1L : 0L;
    }
}
