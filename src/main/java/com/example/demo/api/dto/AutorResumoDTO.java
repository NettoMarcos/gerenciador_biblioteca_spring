package com.example.demo.api.dto;

import com.example.demo.api.model.AutorEntity;

public record AutorResumoDTO(Long id, String nome, String nacionalidade) {
    public AutorResumoDTO(AutorEntity autor){
        this(autor.getId(), autor.getNome(), autor.getNacionalidade());
    }
}
