package com.clickandeat.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString @Builder
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(unique = true,nullable = false,length = 30)
    @NotBlank(message = "The category name cannot be empty.")
    @Size(max = 30, message = "The category name must not exceed 30 characters")
    private String name;
}
