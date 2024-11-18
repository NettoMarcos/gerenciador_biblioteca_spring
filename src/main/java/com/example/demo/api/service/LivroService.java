package com.example.demo.api.service;

import com.example.demo.api.dto.CategoriaDetalhesDTO;
import com.example.demo.api.dto.LivroAtualizarDTO;
import com.example.demo.api.dto.LivroCadastroDTO;
import com.example.demo.api.dto.LivroDetalheDTO;

import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.model.CategoriaEntity;
import com.example.demo.api.model.LivroEntity;
import com.example.demo.api.repository.AutorRepository;
import com.example.demo.api.repository.CategoriaRepository;
import com.example.demo.api.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
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

        AutorEntity autor =  autorRepository.findById(dto.autor_id()).orElse(null);
        CategoriaEntity categoria = categoriaRepository.findById(dto.categoria_id()).orElse(null);

        LivroEntity livro = new LivroEntity(dto, autor, categoria);
        repository.save(livro);

        return livro;
    }


    public LivroEntity atualizarLivro(LivroAtualizarDTO dto) {
            System.out.println(dto);
            LivroEntity livro = repository.getReferenceById(dto.id());
            AutorEntity autor =  autorRepository.findById(dto.autor_id()).orElse(null);
            CategoriaEntity categoria = categoriaRepository.findById(dto.categoria_id()).orElse(null);

            livro.atualizarLivro(dto, autor, categoria);
        return livro;
    }


    public void deletarLivro(Long id) {
        repository.deleteById(id);
    }

    public LivroDetalheDTO buscarPorId(Long id) {
        return repository.findById(id).map(LivroDetalheDTO::new)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));
    }
}
