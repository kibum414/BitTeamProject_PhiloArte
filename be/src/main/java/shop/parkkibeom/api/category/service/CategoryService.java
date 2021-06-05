package shop.parkkibeom.api.category.service;

import shop.parkkibeom.api.category.domain.Category;
import shop.parkkibeom.api.category.domain.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getCategoryList();

    default CategoryDTO entityToDto(Category category) {
        return CategoryDTO.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .build();
    }
}
