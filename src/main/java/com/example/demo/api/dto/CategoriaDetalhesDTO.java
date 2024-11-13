package com.example.demo.api.dto;

import com.example.demo.api.model.CategoriaEntity;

public record CategoriaDetalhesDTO(Long id, String nome) {
    public CategoriaDetalhesDTO(CategoriaEntity categoria) {
        this(categoria.getId(), categoria.getNome());
    }
}
