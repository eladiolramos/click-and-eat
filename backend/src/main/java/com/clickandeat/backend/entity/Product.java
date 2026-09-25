package com.clickandeat.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (updatable = false)
    private Long id;

    @Column(unique = true,nullable = false,length = 50)
    @NotBlank(message = "the product name cannot be empty")
    @Size(max =50, message = "The name must not exceed 50 characters")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @ToString.Exclude
    @NotNull(message = "The product must be a category")
    private Category category;

    @Column(length = 255)
    @Size(max = 255, message = "The description must not exceed 255 characters ")
    private String description;

    @Column(name = "url_image", length = 255)
    @Size(max = 255, message = "The url_image must not exceed 255 characters ")
    private String image;

    @Column(nullable = false, precision = 10, scale = 2)
    @NotNull(message = "the price cannot be empty")
    @Positive(message = "the price must be positive")
    private BigDecimal price;

    @Column(nullable = false)
    @NotNull(message = "The stock cannot be empty")
    @PositiveOrZero(message = "The stock must be positive or zero")
    @Builder.Default
    private Integer stock = 0;

    @Column(nullable = false)
    @NotNull(message = "The product must be active or inactive")
    @Builder.Default
    private Boolean available = true;
}
