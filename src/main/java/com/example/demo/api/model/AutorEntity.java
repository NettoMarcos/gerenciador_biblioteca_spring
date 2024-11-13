package com.example.demo.api.model;

import com.example.demo.api.dto.AutorCadastroDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TBL_AUTORES")
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nacionalidade;

    public AutorEntity(AutorCadastroDTO dto) {
        this.nome = dto.nome();
        this.nacionalidade = dto.nacionalidade();
    }
}
