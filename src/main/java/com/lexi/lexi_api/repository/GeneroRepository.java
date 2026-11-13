package com.lexi.lexi_api.repository;

import com.lexi.lexi_api.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
    Optional<Genero> findByNomeIgnoreCase(String nome);
}