package shop.parkkibeom.api.upload.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.parkkibeom.api.upload.dto.PerformanceDTO;
import shop.parkkibeom.api.upload.dto.PicturesDTO;
import shop.parkkibeom.api.upload.entity.Performance;
import shop.parkkibeom.api.upload.entity.Pictures;
import shop.parkkibeom.api.upload.repository.PerformanceRepository;
import shop.parkkibeom.api.upload.repository.PicturesRepository;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class PerformanceServiceImpl implements PerformanceService {

    private final PerformanceRepository performanceRepository;
    private final PicturesRepository picturesRepository;

    @Transactional
    @Override
    public Long register(PerformanceDTO performanceDTO) {

        Performance performance = dtoToEntity(performanceDTO);

        // save
        performanceRepository.save(performance);

        ArrayList<PicturesDTO> pictures = performanceDTO.getPictures();

        if (pictures != null && pictures.size() > 0) {

            pictures.forEach(picturesDTO -> {
                Pictures pic = dtoToEntityPictures(picturesDTO);
                pic.confirmPerformance(performance);
                picturesRepository.save(pic);
            });
        }

        return performance.getPno();
    }
}
