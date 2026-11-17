package com.lexi.lexi_api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBiblioteca;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}