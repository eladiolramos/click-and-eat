package com.clickandeat.backend.service.impl;

import com.clickandeat.backend.dto.CategoryRequestDTO;
import com.clickandeat.backend.dto.CategoryResponseDTO;
import com.clickandeat.backend.entity.Category;
import com.clickandeat.backend.mapper.CategoryMapper;
import com.clickandeat.backend.repository.CategoryRepository;
import com.clickandeat.backend.service.CategoryService;
import com.clickandeat.backend.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

import static com.clickandeat.backend.util.StringUtils.capitalize;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    @Transactional
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) {

        String cleanNameDto = capitalize(categoryRequestDTO.name());

        if(categoryRepository.existsByName(cleanNameDto)){
            throw new IllegalArgumentException("Category with name " + cleanNameDto + " already exists");
        }

        Category newCategory = categoryMapper.toEntity(new CategoryRequestDTO(cleanNameDto));
        Category savedCategory = categoryRepository.save(newCategory);

        return categoryMapper.toCategoryResponseDTO(savedCategory);
    }

    @Override
    @Transactional
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO categoryRequestDTO) {

        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Category with id " + id + " does not exist"));

        String cleanNameDto = StringUtils.capitalize(categoryRequestDTO.name());

        if(categoryRepository.existsByNameAndIdNot(cleanNameDto, id)){
            throw new IllegalArgumentException("Category with name " + cleanNameDto + " already exists");
        }

        category.setName(cleanNameDto);
        Category savedCategory = categoryRepository.save(category);

        return categoryMapper.toCategoryResponseDTO(savedCategory);
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {

    if (!categoryRepository.existsById(id)) {
        throw new IllegalArgumentException("Category with id " + id + " does not exist");
    }
    categoryRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> allCategories = categoryRepository.findAll();
        List<CategoryResponseDTO> categoryResponseDTOS = new ArrayList<>();

        for (Category category : allCategories) {
            categoryResponseDTOS.add(categoryMapper.toCategoryResponseDTO(category));
        }
        return categoryResponseDTOS;
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryResponseDTO getCategoryById(Long id) {

        Category category =  categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category with id " + id + " does not exist"));

        return  categoryMapper.toCategoryResponseDTO(category);
    }
}