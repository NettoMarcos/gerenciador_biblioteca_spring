package com.example.demo.api.model;

import com.example.demo.api.dto.LivroCadastroDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_LIVROS")
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String isbn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTOR_ID", referencedColumnName = "id")
    private AutorEntity autor_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORIA_ID", referencedColumnName = "id")
    private CategoriaEntity categoria_id;

    public LivroEntity(LivroCadastroDTO dto,AutorEntity autor, CategoriaEntity categoria) {
        this.titulo = dto.titulo();
        this.isbn = dto.isbn();
        this.autor_id = autor;
        this.categoria_id = categoria;
    }
}
