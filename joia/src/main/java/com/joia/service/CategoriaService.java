package com.joia.service;

import com.joia.entity.Categoria;
import com.joia.repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public String save(@Valid Categoria categoriaEntity) {
        categoriaRepository.save(categoriaEntity);
        return "Categoria salva com sucesso!";
    }

    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public String update(@Valid Categoria categoriaEntity, Long id) {
        Categoria categoriaEntityExistente = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));
        categoriaEntityExistente.setNome(categoriaEntity.getNome());
        categoriaRepository.save(categoriaEntityExistente);
        return "Categoria atualizada com sucesso!";
    }

    public String delete(Long id) {
        categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));
        categoriaRepository.deleteById(id);
        return "Categoria deletada com sucesso!";
    }
}
