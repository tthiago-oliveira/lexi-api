package com.lexi.lexi_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;

    @Column(nullable = false)
    private String nome;
}