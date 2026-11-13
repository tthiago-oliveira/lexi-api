package com.lexi.lexi_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PreferenciaLeitura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPreferencia;

    private Integer tamanhoFonte = 16;
    private Double espacamentoLetras = 1.0;
    private Double espacamentoLinhas = 1.5;
    private String alinhamento = "left";
    private Integer brilho = 100;
    private String tema = "Neutro";
    private Double velocidadeTts = 1.0;
    private String vozTts = "pt-BR";
    private Boolean marcaTexto = true;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}