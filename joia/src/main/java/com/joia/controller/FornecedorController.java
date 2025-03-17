package com.joia.controller;

import com.joia.entity.Fornecedor;
import com.joia.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@Valid @RequestBody Fornecedor fornecedorEntity) {
        try {
            String mensagem = fornecedorService.save(fornecedorEntity);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Long id) {
        try {
            Fornecedor fornecedorEntity = fornecedorService.findById(id);
            return new ResponseEntity<>(fornecedorEntity, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Fornecedor>> findAll() {
        List<Fornecedor> fornecedores = fornecedorService.findAll();
        return new ResponseEntity<>(fornecedores, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody Fornecedor fornecedorEntity) {
        try {
            String mensagem = fornecedorService.update(fornecedorEntity, id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        try {
            String mensagem = fornecedorService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
