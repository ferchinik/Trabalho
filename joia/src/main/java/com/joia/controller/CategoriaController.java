package com.joia.controller;

import com.joia.entity.Categoria;
import com.joia.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@Valid @RequestBody Categoria categoriaEntity) {
        try {
            String mensagem = categoriaService.save(categoriaEntity);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        try {
            Categoria categoriaEntity = categoriaService.findById(id);
            return new ResponseEntity<>(categoriaEntity, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> categoriaEntities = categoriaService.findAll();
        return new ResponseEntity<>(categoriaEntities, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody Categoria categoriaEntity) {
        try {
            String mensagem = categoriaService.update(categoriaEntity, id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            String mensagem = categoriaService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
