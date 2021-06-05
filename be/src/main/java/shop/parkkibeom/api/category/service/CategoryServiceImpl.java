package shop.parkkibeom.api.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.parkkibeom.api.category.domain.CategoryDTO;
import shop.parkkibeom.api.category.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getCategoryList() {
        return categoryRepository.findAll().stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
