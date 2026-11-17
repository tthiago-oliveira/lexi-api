package com.lexi.lexi_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Estante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstante;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_biblioteca")
    private Biblioteca biblioteca;
}