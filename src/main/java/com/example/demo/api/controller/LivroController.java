package com.example.demo.api.controller;

import com.example.demo.api.dto.*;
import com.example.demo.api.model.LivroEntity;
import com.example.demo.api.repository.LivroRepository;
import com.example.demo.api.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroService service;

    @PostMapping
    @RequestMapping("/cadastrar")
    public ResponseEntity<LivroDetalheDTO> cadastrarLivro(@RequestBody @Valid LivroCadastroDTO dto, UriComponentsBuilder uriBuilder){

        LivroEntity livro = service.cadastrarLivro(dto);

        var uri = uriBuilder.path("/{id}").buildAndExpand(livro.getId()).toUri();

        return ResponseEntity.created(uri).body(new LivroDetalheDTO(livro));
    }

    @GetMapping
    @RequestMapping("/listar")
    public ResponseEntity<List<LivroDetalheDTO>> listarLivros(){

       List<LivroDetalheDTO> lista = service.listarLivros();

        return ResponseEntity.ok(lista);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<LivroDetalheDTO> buscarPorId(@PathVariable Long id){
        LivroDetalheDTO livro = service.buscarPorId(id);

        return ResponseEntity.ok(livro);
    }

    @PutMapping
    @RequestMapping("/atualizar")
    @Transactional
    public ResponseEntity<LivroDetalheDTO> atualizarLivro (@RequestBody @Valid LivroAtualizarDTO dto){
        LivroEntity livro = service.atualizarLivro(dto);

        return ResponseEntity.ok(new LivroDetalheDTO(livro));
    }

    @DeleteMapping
    @RequestMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity<?> excluirCategoria(@PathVariable Long id){
        service.deletarLivro(id);

        return ResponseEntity.noContent().build();
    }


}
