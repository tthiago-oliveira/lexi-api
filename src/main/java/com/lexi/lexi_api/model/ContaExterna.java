package com.lexi.lexi_api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class ContaExterna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;

    @Column(nullable = false)
    private String provedor;

    @Column(nullable = false)
    private String idExterno;

    private LocalDateTime dataVinculacao = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}