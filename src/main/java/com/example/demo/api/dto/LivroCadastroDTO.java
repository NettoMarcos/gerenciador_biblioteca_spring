package com.example.demo.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroCadastroDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String isbn,
        @NotNull
        Long autor_id,
        @NotNull
        Long categoria_id) {
}
