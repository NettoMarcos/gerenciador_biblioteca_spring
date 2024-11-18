package com.example.demo.api.service;

import com.example.demo.api.dto.AutorDetalhesDTO;
import com.example.demo.api.dto.CategoriaAtualizarDTO;
import com.example.demo.api.dto.CategoriaCadastroDTO;
import com.example.demo.api.dto.CategoriaDetalhesDTO;
import com.example.demo.api.model.CategoriaEntity;
import com.example.demo.api.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriasService {
    @Autowired
    CategoriaRepository repository;
    public CategoriaEntity cadastrarCategoria(CategoriaCadastroDTO dto) {

        CategoriaEntity categoria = new CategoriaEntity(dto);
        repository.save(categoria);
        return categoria;
    }

    public List<CategoriaDetalhesDTO> listarCategorias() {
        return repository.findAll().stream().map(CategoriaDetalhesDTO::new).toList();
    }

    public CategoriaEntity atualizarCategoria(@Valid CategoriaAtualizarDTO dto) {
        CategoriaEntity categoria = repository.getReferenceById(dto.id());
        categoria.atualizarCategoria(dto);

        return categoria;
    }

    public void deletarCategoria(Long id) {
        repository.deleteById(id);
    }

    public CategoriaDetalhesDTO buscarPorId(Long id) {
        return repository.findById(id).map(CategoriaDetalhesDTO::new)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrado"));
    }
}
