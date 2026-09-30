package com.clickandeat.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequestDTO(
        @NotBlank(message = "The category name cannot be empty.")
        @Size(max = 30, message = "The category name must not exceed 30 characters")
        String name) {
}
