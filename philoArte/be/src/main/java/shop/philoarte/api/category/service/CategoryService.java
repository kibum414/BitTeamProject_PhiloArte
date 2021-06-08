package shop.philoarte.api.category.service;

import java.util.List;

import shop.philoarte.api.category.domain.CategoryDTO;

public interface CategoryService {
    List<CategoryDTO> findAllCategory();
}
