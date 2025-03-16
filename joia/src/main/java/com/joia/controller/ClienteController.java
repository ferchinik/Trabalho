package com.joia.controller;

import com.joia.entity.Cliente;
import com.joia.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Cliente clienteEntity) {
        try {
            String mensagem = clienteService.save(clienteEntity);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        try {
            Cliente clienteEntity = clienteService.findById(id);
            return new ResponseEntity<>(clienteEntity, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<Cliente> findByEmail(@RequestParam String email) {
        try {
            Cliente cliente = clienteService.findByEmail(email);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clienteEntities = clienteService.findAll();
        return new ResponseEntity<>(clienteEntities, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Cliente clienteEntity) {
        try {
            String mensagem = clienteService.update(clienteEntity, id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            String mensagem = clienteService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
