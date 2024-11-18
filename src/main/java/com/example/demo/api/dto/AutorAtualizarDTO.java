package com.example.demo.api.dto;

import jakarta.validation.constraints.NotNull;

public record AutorAtualizarDTO(
                                @NotNull
                                Long id,
                                String nome,
                                String nacionalidade) {
}
