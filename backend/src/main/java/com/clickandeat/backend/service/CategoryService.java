package com.clickandeat.backend.service;

import com.clickandeat.backend.dto.CategoryRequestDTO;
import com.clickandeat.backend.dto.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {

    // Metodo para crear una categoria.
    CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO);

    // Metodo para actualizar una categoria.
    CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO categoryRequestDTO);

    // Metodo para eliminar una categoria.
    void deleteCategory(Long id);

    // Metodo para listar todas las categorias.
    List<CategoryResponseDTO> getAllCategories();

    // Metodo para obtener una categoria.
    CategoryResponseDTO getCategoryById(Long id);

}
