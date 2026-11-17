package com.lexi.lexi_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;

    @Column(nullable = false)
    private String titulo;

    private Integer anoPublicacao;

    @Column(columnDefinition = "LONGTEXT")
    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;
}