package com.example.demo.api.controller;

import com.example.demo.api.dto.LivroCadastroDTO;
import com.example.demo.api.dto.LivroDetalheDTO;
import com.example.demo.api.model.LivroEntity;
import com.example.demo.api.repository.LivroRepository;
import com.example.demo.api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<LivroDetalheDTO> cadastrarLivro(@RequestBody LivroCadastroDTO dto, UriComponentsBuilder uriBuilder){

        var livro = service.cadastrarLivro(dto);

        var uri = uriBuilder.path("/{id}").buildAndExpand(livro.getId()).toUri();

        return ResponseEntity.created(uri).body(new LivroDetalheDTO(livro));
    }

    @GetMapping
    @RequestMapping("/listar")
    public ResponseEntity<List<LivroDetalheDTO>> listarLivros(){

        var lista = service.listarLivros();

        return ResponseEntity.ok(lista);
    }


}
