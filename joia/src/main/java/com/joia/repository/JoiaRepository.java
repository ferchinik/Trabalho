package com.joia.repository;

import com.joia.entity.Joia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JoiaRepository extends JpaRepository<Joia, Long> {

    // consulta para encontrar joias por parte do nome
    List<Joia> findByNomeIgnoreCaseContaining(String nome);

    // consulta para encontrar joias por tipo de metal
    List<Joia> findByTipoMetalIgnoreCase(String tipoMetal);

    // consulta para encontrar joias de uma categoria específica
    List<Joia> findByCategoriaId(Long categoriaId);

    //consulta para encontrar joias ordenadas pelo nome em ordem ascendente
    List<Joia> findByOrderByNomeAsc();
}
