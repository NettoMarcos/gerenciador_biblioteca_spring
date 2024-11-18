package com.example.demo.api.dto;

import com.example.demo.api.model.CategoriaEntity;
import com.example.demo.api.model.LivroEntity;

public record LivroResumoDTO(Long id, String titulo, String isbn, CategoriaEntity categoria) {
    public LivroResumoDTO(LivroEntity livro) {
        this(livro.getId(), livro.getTitulo(), livro.getIsbn(), livro.getCategoria_id());
    }
}
