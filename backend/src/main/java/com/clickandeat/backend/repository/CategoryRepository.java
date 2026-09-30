package com.clickandeat.backend.repository;

import com.clickandeat.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Para validar si existe el nombre para grabar una categoría
    boolean existsByName(String name);

    // Para buscar y recupera la categoría si existe para mostrarla.
    Optional<Category> findByName(String name);
}
