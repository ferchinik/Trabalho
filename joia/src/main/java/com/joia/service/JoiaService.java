package com.joia.service;

import com.joia.entity.Joia;
import com.joia.repository.JoiaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoiaService {

    @Autowired
    private JoiaRepository joiaRepository;

    public String save(@Valid Joia joiaEntity) {
        validarJoia(joiaEntity);
        joiaRepository.save(joiaEntity);
        return "Joia salva com sucesso!";
    }

    public Joia findById(Long id) {
        return joiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Joia não encontrada!"));
    }

    public List<Joia> findAll() {
        return joiaRepository.findAll();
    }

    public String update(@Valid Joia joiaEntity, Long id) {
        Joia joiaExistente = joiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Joia não encontrada!"));

        validarJoia(joiaEntity);

        joiaExistente.setNome(joiaEntity.getNome().toUpperCase());
        joiaExistente.setCategoria(joiaEntity.getCategoria());
        joiaExistente.setFornecedor(joiaEntity.getFornecedor());

        joiaRepository.save(joiaExistente);
        return "Joia atualizada com sucesso!";
    }

    public String delete(Long id) {
        joiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Joia não encontrada!"));
        joiaRepository.deleteById(id);
        return "Joia deletada com sucesso!";
    }

    private void validarJoia(Joia joiaEntity) {
        if (joiaEntity.getNome() == null || joiaEntity.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da joia não pode ser vazio!");
        }

        if (joiaEntity.getCategoria() == null) {
            throw new IllegalArgumentException("A categoria da joia não pode ser nula!");
        }

        if (joiaEntity.getFornecedor() == null) {
            throw new IllegalArgumentException("O fornecedor da joia não pode ser nulo!");
        }
    }
}
