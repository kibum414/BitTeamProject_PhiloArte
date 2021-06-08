package shop.philoarte.api.category.domain;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.philoarte.api.common.util.ModelMapperUtils;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoryDTO {
    private Long categoryId;
    private String categoryName;

    public static CategoryDTO of(Category category) {
        CategoryDTO categoryDto = ModelMapperUtils.getModelMapper().map(category, CategoryDTO.class);
        return categoryDto;
    }
}
