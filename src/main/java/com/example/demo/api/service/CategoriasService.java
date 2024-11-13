package com.example.demo.api.service;

import com.example.demo.api.dto.CategoriaCadastroDTO;
import com.example.demo.api.dto.CategoriaDetalhesDTO;
import com.example.demo.api.model.CategoriaEntity;
import com.example.demo.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriasService {
    @Autowired
    CategoriaRepository repository;
    public CategoriaEntity cadastrarCategoria(CategoriaCadastroDTO dto) {

        var categoria = new CategoriaEntity(dto);
        repository.save(categoria);
        return categoria;
    }

    public List<CategoriaDetalhesDTO> listarCategorias() {
        return repository.findAll().stream().map(CategoriaDetalhesDTO::new).toList();
    }
}
