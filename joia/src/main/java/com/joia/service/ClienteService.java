package com.joia.service;

import com.joia.entity.Cliente;
import com.joia.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public String save(@Valid Cliente clienteEntity) {
        if (clienteRepository.findByEmail(clienteEntity.getEmail()) != null) {
            throw new RuntimeException("Email já cadastrado!");
        }
        clienteRepository.save(clienteEntity);
        return "Cliente salvo com sucesso!";
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
    }

    public Cliente findByEmail(String email) {
        Optional<Cliente> cliente = clienteRepository.findByEmail(email);
        if (cliente.isEmpty()) {
            throw new RuntimeException("Cliente com este email não encontrado!");
        }
        return cliente.orElse(null);
    }


    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public String update(@Valid Cliente clienteEntity, Long id) {
        Cliente clienteEntityExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));

        if (!clienteEntityExistente.getEmail().equals(clienteEntity.getEmail())
                && clienteRepository.findByEmail(clienteEntity.getEmail()) != null) {
            throw new RuntimeException("Email já cadastrado!");
        }

        clienteEntityExistente.setNome(clienteEntity.getNome());
        clienteEntityExistente.setEmail(clienteEntity.getEmail());
        clienteRepository.save(clienteEntityExistente);
        return "Cliente atualizado com sucesso!";
    }

    public String delete(Long id) {
        clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
        clienteRepository.deleteById(id);
        return "Cliente deletado com sucesso!";
    }
}
