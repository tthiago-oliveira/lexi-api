package com.lexi.lexi_api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class ArquivoLivro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArquivo;

    @Column(nullable = false)
    private String nomeArquivo;

    private String formato;
    private String localizacao;
    private Long tamanho;
    private LocalDateTime dataImportacao = LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;
}