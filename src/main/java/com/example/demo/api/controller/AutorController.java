package com.example.demo.api.controller;

import com.example.demo.api.dto.AutorCadastroDTO;
import com.example.demo.api.dto.AutorDetalhesDTO;
import com.example.demo.api.dto.LivroCadastroDTO;
import com.example.demo.api.dto.LivroDetalheDTO;
import com.example.demo.api.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<AutorDetalhesDTO> cadastrarAutor(@RequestBody AutorCadastroDTO dto, UriComponentsBuilder uriBuilder){

        var autor = service.cadastrarAutor(dto);

        var uri = uriBuilder.path("/{id}").buildAndExpand(autor.getId()).toUri();

        return ResponseEntity.created(uri).body(new AutorDetalhesDTO(autor));
    }

    @GetMapping
    @RequestMapping("/listar")
    public ResponseEntity<List<AutorDetalhesDTO>> listarLivros(){

        var lista = service.listarAutor();

        return ResponseEntity.ok(lista);
    }
}
