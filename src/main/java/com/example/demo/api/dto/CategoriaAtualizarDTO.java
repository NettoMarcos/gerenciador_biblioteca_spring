package com.example.demo.api.dto;

import jakarta.validation.constraints.NotNull;

public record CategoriaAtualizarDTO(
                                    @NotNull
                                    Long id,
                                    String nome) {
}
