package com.example.demo.api.dto;

import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.model.LivroEntity;

import java.util.List;
import java.util.stream.Collectors;

public record AutorDetalhesDTO(Long id, String nome, String nacionalidade, List<LivroResumoDTO> livros) {

    public AutorDetalhesDTO(AutorEntity autor){
        this(autor.getId(), autor.getNome(), autor.getNacionalidade(),
                autor.getLivros().stream().map(LivroResumoDTO::new).collect(Collectors.toList()));
    }
}