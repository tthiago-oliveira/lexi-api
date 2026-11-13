package com.lexi.lexi_api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class ProgressoLeitura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProgresso;

    private Integer posicaoLeitura = 0;
    private Double percentual = 0.0;
    private LocalDateTime dataUltimaLeitura = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;
}