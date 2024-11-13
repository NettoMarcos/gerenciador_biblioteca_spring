package com.example.demo.api.model;

import com.example.demo.api.dto.CategoriaCadastroDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TBL_CATEGORIAS")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public CategoriaEntity(CategoriaCadastroDTO dto) {
        this.nome = dto.nome();
    }
}
