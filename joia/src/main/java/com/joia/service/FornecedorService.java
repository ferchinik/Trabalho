package com.joia.service;

import com.joia.entity.Fornecedor;
import com.joia.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public String save(Fornecedor fornecedorEntity) {
        fornecedorRepository.save(fornecedorEntity);
        return "Fornecedor salvo com sucesso!";
    }

    public Fornecedor findById(Long id) {
        return fornecedorRepository.findById(id).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado!"));
    }

    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    public String update(Fornecedor fornecedorEntity, Long id) {
        Fornecedor fornecedorEntityExistente = fornecedorRepository.findById(id).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado!"));
        fornecedorEntityExistente.setName(fornecedorEntity.getName());
        fornecedorRepository.save(fornecedorEntityExistente);
        return "Fornecedor atualizado com sucesso!";
    }

    public String delete(Long id) {
        fornecedorRepository.deleteById(id);
        return "Fornecedor deletado com sucesso!";
    }
}
