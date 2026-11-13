// Arquivo: PreferenciaRepository.java
package com.lexi.lexi_api.repository;

import com.lexi.lexi_api.model.PreferenciaLeitura;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PreferenciaRepository extends JpaRepository<PreferenciaLeitura, Long> {
    Optional<PreferenciaLeitura> findByUsuarioIdUsuario(Long idUsuario);
}