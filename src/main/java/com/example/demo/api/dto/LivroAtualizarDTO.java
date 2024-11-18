package com.example.demo.api.dto;

import jakarta.validation.constraints.NotNull;

public record LivroAtualizarDTO(
        @NotNull
        Long id,
        String titulo,
        String isbn,
        Long autor_id,
        Long categoria_id) {
}
