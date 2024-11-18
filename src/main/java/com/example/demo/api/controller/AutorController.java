package com.example.demo.api.controller;

import com.example.demo.api.dto.*;
import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService service;

    @PostMapping
    @RequestMapping("/cadastrar")
    public ResponseEntity<AutorCadastroDTO> cadastrarAutor(@RequestBody @Valid AutorCadastroDTO dto, UriComponentsBuilder uriBuilder){

        AutorEntity autor = service.cadastrarAutor(dto);

        var uri = uriBuilder.path("/{id}").buildAndExpand(autor.getId()).toUri();

        return ResponseEntity.created(uri).body(new AutorCadastroDTO(autor));
    }

    @GetMapping
    @RequestMapping("/listar")
    public ResponseEntity<List<AutorDetalhesDTO>> listarAutor(){

        List<AutorDetalhesDTO> lista = service.listarAutor();

        return ResponseEntity.ok(lista);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<AutorDetalhesDTO> buscarPorId(@PathVariable Long id){
        AutorDetalhesDTO autor = service.buscarPorId(id);

        return ResponseEntity.ok(autor);
    }

    @PutMapping
    @RequestMapping("/atualizar")
    @Transactional
    public ResponseEntity<AutorDetalhesDTO> atualizarAutor (@RequestBody @Valid AutorAtualizarDTO dto){
        AutorEntity autor = service.atualizarAutor(dto);

        return ResponseEntity.ok(new AutorDetalhesDTO(autor));
    }

    @DeleteMapping
    @RequestMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity<?> excluirAutor(@PathVariable Long id){
        service.deletarAutor(id);

        return ResponseEntity.noContent().build();
    }
}
