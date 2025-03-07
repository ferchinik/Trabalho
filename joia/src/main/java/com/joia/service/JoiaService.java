package com.joia.service;

import com.joia.entity.JoiaEntity;
import com.joia.repository.JoiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoiaService {

    @Autowired
    private JoiaRepository joiaRepository;

    public String save(JoiaEntity joiaEntity) {
        joiaRepository.save(joiaEntity);
        return "Joia salva com sucesso!";
    }

    public JoiaEntity findById(Long id) {
        return joiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Joia não encontrada!"));
    }

    public List<JoiaEntity> findAll() {
        return joiaRepository.findAll();
    }

    public String update(JoiaEntity joiaEntity, Long id) {
        JoiaEntity joiaExistente = joiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Joia não encontrada!"));
        joiaExistente.setNome(joiaEntity.getNome());
        joiaExistente.setDescricao(joiaEntity.getDescricao());
        joiaExistente.setTipoMetal(joiaEntity.getTipoMetal());
        joiaExistente.setCategoria(joiaEntity.getCategoria());
        joiaExistente.setFornecedor(joiaEntity.getFornecedor());
        joiaRepository.save(joiaExistente);
        return "Joia atualizada com sucesso!";
    }

    public String delete(Long id) {
        joiaRepository.deleteById(id);
        return "Joia deletada com sucesso!";
    }
}
