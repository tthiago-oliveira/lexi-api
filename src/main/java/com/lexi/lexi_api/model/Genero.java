package com.lexi.lexi_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGenero;

    @Column(nullable = false)
    private String nome;
}