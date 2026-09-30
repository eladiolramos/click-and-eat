package com.clickandeat.backend.dto;

import lombok.Builder;

@Builder
public record CategoryResponseDTO(
        Long id,
        String name
) {
}
