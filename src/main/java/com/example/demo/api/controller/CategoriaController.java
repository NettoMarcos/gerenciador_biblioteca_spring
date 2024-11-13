package com.example.demo.api.controller;

import com.example.demo.api.dto.AutorCadastroDTO;
import com.example.demo.api.dto.AutorDetalhesDTO;
import com.example.demo.api.dto.CategoriaCadastroDTO;
import com.example.demo.api.dto.CategoriaDetalhesDTO;
import com.example.demo.api.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriasService service;

    @PostMapping
    @RequestMapping("/cadastrar")
    public ResponseEntity<CategoriaDetalhesDTO> cadastrarCategoria(@RequestBody CategoriaCadastroDTO dto, UriComponentsBuilder uriBuilder){

        var categoria = service.cadastrarCategoria(dto);

        var uri = uriBuilder.path("/{id}").buildAndExpand(categoria.getId()).toUri();

        return ResponseEntity.created(uri).body(new CategoriaDetalhesDTO(categoria));
    }

    @GetMapping
    @RequestMapping("/listar")
    public ResponseEntity<List<CategoriaDetalhesDTO>> listarCategorias(){

        var lista = service.listarCategorias();

        return ResponseEntity.ok(lista);
    }
}
