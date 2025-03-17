package com.joia.controller;

import com.joia.entity.Joia;
import com.joia.service.JoiaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/joias")
public class JoiaController {

    @Autowired
    private JoiaService joiaService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@Valid @RequestBody Joia joiaEntity) {
        try {
            String mensagem = joiaService.save(joiaEntity);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Joia> findById(@PathVariable Long id) {
        try {
            Joia joiaEntity = joiaService.findById(id);
            return new ResponseEntity<>(joiaEntity, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Joia>> findAll() {
        List<Joia> joiaEntities = joiaService.findAll();
        return new ResponseEntity<>(joiaEntities, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody Joia joiaEntity) {
        try {
            String mensagem = joiaService.update(joiaEntity, id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        try {
            String mensagem = joiaService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
