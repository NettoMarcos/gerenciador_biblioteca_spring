package com.example.demo.api.service;

import com.example.demo.api.dto.AutorCadastroDTO;
import com.example.demo.api.dto.AutorDetalhesDTO;
import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    AutorRepository repository;

    public AutorEntity cadastrarAutor(AutorCadastroDTO dto) {
        var autor = new AutorEntity(dto);
        repository.save(autor);
        return autor;
    }

    public List<AutorDetalhesDTO> listarAutor() {
        return repository.findAll().stream().map(AutorDetalhesDTO::new).toList();
    }
}
