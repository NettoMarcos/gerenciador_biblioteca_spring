package com.example.demo.api.service;

import com.example.demo.api.dto.LivroCadastroDTO;
import com.example.demo.api.dto.LivroDetalheDTO;

import com.example.demo.api.model.LivroEntity;
import com.example.demo.api.repository.AutorRepository;
import com.example.demo.api.repository.CategoriaRepository;
import com.example.demo.api.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<LivroDetalheDTO> listarLivros() {
        return repository.findAll().stream().map(LivroDetalheDTO::new).toList();
    }

    public LivroEntity cadastrarLivro(LivroCadastroDTO dto) {

        var autor =  autorRepository.getReferenceById(dto.autor_id());
        var categoria = categoriaRepository.getReferenceById(dto.categoria_id());

        var livro = new LivroEntity(dto, autor, categoria);
        repository.save(livro);

        return livro;
    }
}
