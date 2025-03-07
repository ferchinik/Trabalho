package com.joia.service;

import com.joia.entity.FornecedorEntity;
import com.joia.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public String save(FornecedorEntity fornecedorEntity) {
        fornecedorRepository.save(fornecedorEntity);
        return "Fornecedor salvo com sucesso!";
    }

    public FornecedorEntity findById(Long id) {
        return fornecedorRepository.findById(id).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado!"));
    }

    public List<FornecedorEntity> findAll() {
        return fornecedorRepository.findAll();
    }

    public String update(FornecedorEntity fornecedorEntity, Long id) {
        FornecedorEntity fornecedorEntityExistente = fornecedorRepository.findById(id).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado!"));
        fornecedorEntityExistente.setName(fornecedorEntity.getName());
        fornecedorRepository.save(fornecedorEntityExistente);
        return "Fornecedor atualizado com sucesso!";
    }

    public String delete(Long id) {
        fornecedorRepository.deleteById(id);
        return "Fornecedor deletado com sucesso!";
    }
}
