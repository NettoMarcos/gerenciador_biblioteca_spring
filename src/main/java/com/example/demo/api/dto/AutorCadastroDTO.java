package com.example.demo.api.dto;

import com.example.demo.api.model.AutorEntity;
import jakarta.validation.constraints.NotBlank;

public record AutorCadastroDTO(

        @NotBlank
        String nome,
        String nacionalidade) {
    public AutorCadastroDTO(AutorEntity autor){
        this(autor.getNome(), autor.getNacionalidade());
    }
}
