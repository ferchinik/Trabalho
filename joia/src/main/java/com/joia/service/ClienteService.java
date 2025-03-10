package com.joia.service;

import com.joia.entity.ClienteEntity;
import com.joia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public String save(ClienteEntity clienteEntity) {
        if (clienteRepository.findByEmail(clienteEntity.getEmail()) != null) {
            throw new RuntimeException("Email já cadastrado!");
        }
        clienteRepository.save(clienteEntity);
        return "Cliente salvo com sucesso!";
    }

    public ClienteEntity findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
    }

    public ClienteEntity findByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }

    public String update(ClienteEntity clienteEntity, Long id) {
        ClienteEntity clienteEntityExistente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));

        if (!clienteEntityExistente.getEmail().equals(clienteEntity.getEmail()) && clienteRepository.findByEmail(clienteEntity.getEmail()) != null) {
            throw new RuntimeException("Email já cadastrado!");
        }

        clienteEntityExistente.setNome(clienteEntity.getNome());
        clienteEntityExistente.setEmail(clienteEntity.getEmail());
        clienteRepository.save(clienteEntityExistente);
        return "Cliente atualizado com sucesso!";
    }

    public String delete(Long id) {
        clienteRepository.deleteById(id);
        return "Cliente deletado com sucesso!";
    }
}

