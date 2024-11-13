package com.example.demo.api.dto;

import com.example.demo.api.model.AutorEntity;

public record AutorDetalhesDTO(Long id, String nome, String nacionalidade) {

    public AutorDetalhesDTO(AutorEntity autor){
        this(autor.getId(), autor.getNome(), autor.getNacionalidade());
    }
}
