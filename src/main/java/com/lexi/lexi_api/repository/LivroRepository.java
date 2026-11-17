package com.lexi.lexi_api.repository;

import com.lexi.lexi_api.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTituloContainingIgnoreCase(String titulo);
    List<Livro> findByAutorNomeContainingIgnoreCase(String autor);
    List<Livro> findByGeneroNomeContainingIgnoreCase(String genero);
    List<Livro> findByTituloContainingIgnoreCaseOrAutorNomeContainingIgnoreCaseOrGeneroNomeContainingIgnoreCase(
            String titulo, String autor, String genero
    );
}