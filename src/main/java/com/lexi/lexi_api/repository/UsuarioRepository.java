// Arquivo: UsuarioRepository.java
package com.lexi.lexi_api.repository;

import com.lexi.lexi_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}