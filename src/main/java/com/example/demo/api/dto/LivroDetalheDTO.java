package com.example.demo.api.dto;

import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.model.CategoriaEntity;
import com.example.demo.api.model.LivroEntity;

import java.util.List;

public record LivroDetalheDTO(Long id, String titulo, String isbn, AutorResumoDTO autor, CategoriaEntity categoria) {

    public LivroDetalheDTO(LivroEntity livro){
        this(livro.getId(), livro.getTitulo(), livro.getIsbn(), new AutorResumoDTO(livro.getAutor_id()), livro.getCategoria_id());
    }
}