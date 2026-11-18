package com.lexi.lexi_api.controller;

import com.lexi.lexi_api.model.Autor;
import com.lexi.lexi_api.model.Genero;
import com.lexi.lexi_api.model.Livro;
import com.lexi.lexi_api.repository.AutorRepository;
import com.lexi.lexi_api.repository.GeneroRepository;
import com.lexi.lexi_api.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping
    public List<Livro> listarOuBuscar(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String autor,
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) String todos) {

        if (titulo != null && !titulo.isBlank()) {
            return livroRepository.findByTituloContainingIgnoreCase(titulo);
        }
        if (autor != null && !autor.isBlank()) {
            return livroRepository.findByAutorNomeContainingIgnoreCase(autor);
        }
        if (genero != null && !genero.isBlank()) {
            return livroRepository.findByGeneroNomeContainingIgnoreCase(genero);
        }
        if (todos != null && !todos.isBlank()) {
            return livroRepository.findByTituloContainingIgnoreCaseOrAutorNomeContainingIgnoreCaseOrGeneroNomeContainingIgnoreCase(
                    todos, todos, todos);
        }
        return livroRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> obterPorId(@PathVariable Long id) {
        return livroRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody LivroDTO dados) {
        Autor autor = autorRepository.findByNomeIgnoreCase(dados.autor())
                .orElseGet(() -> {
                    Autor novo = new Autor();
                    novo.setNome(dados.autor());
                    return autorRepository.save(novo);
                });

        Genero genero = generoRepository.findByNomeIgnoreCase(dados.genero())
                .orElseGet(() -> {
                    Genero novo = new Genero();
                    novo.setNome(dados.genero());
                    return generoRepository.save(novo);
                });

        Livro livro = new Livro();
        livro.setTitulo(dados.titulo());
        livro.setAutor(autor);
        livro.setGenero(genero);
        livro.setAnoPublicacao(dados.anoPublicacao());
        livro.setConteudo(dados.conteudo());

        return ResponseEntity.status(HttpStatus.CREATED).body(livroRepository.save(livro));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!livroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        livroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public record LivroDTO(String titulo, String autor, String genero, Integer anoPublicacao, String conteudo) {}
}
