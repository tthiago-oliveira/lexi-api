package com.lexi.lexi_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTema;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(columnDefinition = "TEXT")
    private String configuracaoCores;
}