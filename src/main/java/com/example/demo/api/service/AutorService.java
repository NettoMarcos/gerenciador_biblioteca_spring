package com.example.demo.api.service;

import com.example.demo.api.dto.AutorAtualizarDTO;
import com.example.demo.api.dto.AutorCadastroDTO;
import com.example.demo.api.dto.AutorDetalhesDTO;
import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.repository.AutorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    AutorRepository repository;

    public AutorEntity cadastrarAutor(AutorCadastroDTO dto) {
        AutorEntity autor = new AutorEntity(dto);
        repository.save(autor);
        return autor;
    }

    public List<AutorDetalhesDTO> listarAutor() {
        return repository.findAll().stream().map(AutorDetalhesDTO::new).toList();
    }


    public AutorEntity atualizarAutor(AutorAtualizarDTO dto) {
        AutorEntity autor = repository.getReferenceById(dto.id());
        autor.atualizarAutor(dto);

        return autor;
    }

    public void deletarAutor(Long id){
        repository.deleteById(id);
    }

    public AutorDetalhesDTO buscarPorId(Long id) {
        return repository.findById(id).map(AutorDetalhesDTO::new)
                .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado"));
    }
}
