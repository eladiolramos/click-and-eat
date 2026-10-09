package com.clickandeat.backend.mapper;

import com.clickandeat.backend.dto.CategoryRequestDTO;
import com.clickandeat.backend.dto.CategoryResponseDTO;
import com.clickandeat.backend.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryResponseDTO toCategoryResponseDTO(Category entity) {
        if (entity == null) return null;
        return new CategoryResponseDTO(entity.getId(), entity.getName());
    }

    public Category toEntity(CategoryRequestDTO dto) {
        if (dto == null) return null;
        return Category.builder()
                .name(dto.name())
                .build();
    }
}
