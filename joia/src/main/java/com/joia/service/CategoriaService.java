package com.joia.service;

import com.joia.entity.CategoriaEntity;
import com.joia.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public String save(CategoriaEntity categoriaEntity) {
        categoriaRepository.save(categoriaEntity);
        return "Categoria salva com sucesso!";
    }

    public CategoriaEntity findById(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));
    }

    public List<CategoriaEntity> findAll() {
        return categoriaRepository.findAll();
    }

    public String update(CategoriaEntity categoriaEntity, Long id) {
        CategoriaEntity categoriaEntityExistente = categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));
        categoriaEntityExistente.setNome(categoriaEntity.getNome());
        categoriaRepository.save(categoriaEntityExistente);
        return "Categoria atualizada com sucesso!";
    }

    public String delete(Long id) {
        categoriaRepository.deleteById(id);
        return "Categoria deletada com sucesso!";
    }
}

