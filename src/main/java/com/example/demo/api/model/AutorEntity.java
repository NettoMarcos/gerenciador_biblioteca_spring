package com.example.demo.api.model;

import com.example.demo.api.dto.AutorAtualizarDTO;
import com.example.demo.api.dto.AutorCadastroDTO;
import com.example.demo.api.dto.AutorDetalhesDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Bean;

import java.util.List;

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


    @OneToMany(mappedBy = "autor_id")
    private List<LivroEntity> livros;

    public AutorEntity(AutorCadastroDTO dto) {
        this.nome = dto.nome();
        this.nacionalidade = dto.nacionalidade();
    }

    public void atualizarAutor(AutorAtualizarDTO dto){
        if(dto.nome() != null){
            this.nome = dto.nome();
        }
        if (dto.nacionalidade() != null){
            this.nacionalidade = dto.nacionalidade();
        }
    }
}
