package com.lexi.lexi_api.controller;

import com.lexi.lexi_api.model.PreferenciaLeitura;
import com.lexi.lexi_api.model.Usuario;
import com.lexi.lexi_api.repository.PreferenciaRepository;
import com.lexi.lexi_api.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final PreferenciaRepository preferenciaRepository;

    public UsuarioController(UsuarioRepository usuarioRepository, PreferenciaRepository preferenciaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.preferenciaRepository = preferenciaRepository;
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        Usuario salvo = usuarioRepository.save(usuario);
        PreferenciaLeitura prefPadrao = new PreferenciaLeitura();
        prefPadrao.setUsuario(salvo);
        preferenciaRepository.save(prefPadrao);
        return salvo;
    }

    @GetMapping("/{id}/preferencias")
    public ResponseEntity<PreferenciaLeitura> buscarPreferencias(@PathVariable Long id) {
        return preferenciaRepository.findByUsuarioIdUsuario(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/preferencias")
    public ResponseEntity<PreferenciaLeitura> atualizarPreferencias(@PathVariable Long id, @RequestBody PreferenciaLeitura novas) {
        return preferenciaRepository.findByUsuarioIdUsuario(id).map(atual -> {
            atual.setTamanhoFonte(novas.getTamanhoFonte());
            atual.setEspacamentoLetras(novas.getEspacamentoLetras());
            atual.setEspacamentoLinhas(novas.getEspacamentoLinhas());
            atual.setAlinhamento(novas.getAlinhamento());
            atual.setBrilho(novas.getBrilho());
            atual.setTema(novas.getTema());
            atual.setVelocidadeTts(novas.getVelocidadeTts());
            atual.setVozTts(novas.getVozTts());
            atual.setMarcaTexto(novas.getMarcaTexto());
            return ResponseEntity.ok(preferenciaRepository.save(atual));
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        preferenciaRepository.findByUsuarioIdUsuario(id).ifPresent(preferenciaRepository::delete);
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}