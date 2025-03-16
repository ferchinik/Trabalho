package com.joia.service;

import com.joia.entity.Joia;
import com.joia.repository.JoiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoiaService {

    @Autowired
    private JoiaRepository joiaRepository;

    // Método para salvar com validação
    public String save(Joia joiaEntity) {
        validarJoia(joiaEntity); // Validação antes de salvar
        joiaRepository.save(joiaEntity);
        return "Joia salva com sucesso!";
    }

    public Joia findById(Long id) {
        return joiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Joia não encontrada!"));
    }

    public List<Joia> findAll() {
        return joiaRepository.findAll();
    }

    // Método para atualizar com validação
    public String update(Joia joiaEntity, Long id) {
        Joia joiaExistente = joiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Joia não encontrada!"));

        validarJoia(joiaEntity); // Validação antes de atualizar

        // Atualizando os atributos
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

    // Método para validar regras de negócio
    private void validarJoia(Joia joiaEntity) {
        if (joiaEntity.getNome() == null || joiaEntity.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome da joia não pode ser vazio!");
        }

        // Garantir que o nome esteja em caixa alta
        joiaEntity.setNome(joiaEntity.getNome().toUpperCase());

        if (joiaEntity.getDescricao() == null || joiaEntity.getDescricao().isEmpty()) {
            throw new IllegalArgumentException("A descrição da joia não pode ser vazia!");
        }

        if (joiaEntity.getTipoMetal() == null || joiaEntity.getTipoMetal().isEmpty()) {
            throw new IllegalArgumentException("O tipo de metal não pode ser vazio!");
        }

        // Outras validações podem ser adicionadas conforme necessário
    }
}
