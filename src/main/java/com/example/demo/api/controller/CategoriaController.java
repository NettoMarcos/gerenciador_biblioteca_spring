package com.example.demo.api.controller;

import com.example.demo.api.dto.*;
import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.model.CategoriaEntity;
import com.example.demo.api.service.CategoriasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    public ResponseEntity<CategoriaDetalhesDTO> cadastrarCategoria(@RequestBody @Valid CategoriaCadastroDTO dto, UriComponentsBuilder uriBuilder){

        CategoriaEntity categoria = service.cadastrarCategoria(dto);

        var uri = uriBuilder.path("/{id}").buildAndExpand(categoria.getId()).toUri();

        return ResponseEntity.created(uri).body(new CategoriaDetalhesDTO(categoria));
    }

    @GetMapping
    @RequestMapping("/listar")
    public ResponseEntity<List<CategoriaDetalhesDTO>> listarCategorias(){

        List<CategoriaDetalhesDTO> lista = service.listarCategorias();

        return ResponseEntity.ok(lista);
    }
    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<CategoriaDetalhesDTO> buscarPorId(@PathVariable Long id){
        CategoriaDetalhesDTO categoria = service.buscarPorId(id);

        return ResponseEntity.ok(categoria);
    }

    @PutMapping
    @RequestMapping("/atualizar")
    @Transactional
    public ResponseEntity<CategoriaDetalhesDTO> atualizarCategoria (@RequestBody @Valid CategoriaAtualizarDTO dto){
        CategoriaEntity  categoria = service.atualizarCategoria(dto);

        return ResponseEntity.ok(new CategoriaDetalhesDTO(categoria));
    }

    @DeleteMapping
    @RequestMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity<?> excluirCategoria(@PathVariable Long id){
        service.deletarCategoria(id);

        return ResponseEntity.noContent().build();
    }
}
