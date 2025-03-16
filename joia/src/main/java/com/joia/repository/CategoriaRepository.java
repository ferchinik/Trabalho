package com.joia.repository;

import com.joia.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // consulta para encontrar categorias por nome (case-insensitive e contendo parte do nome)
    List<Categoria> findByNomeIgnoreCaseContaining(String nome);

    // consulta para encontrar categorias que têm joias associadas (apenas IDs válidos)
    List<Categoria> findByJoiaEntitiesIsNotNull();

    // consulta para encontrar categorias ordenadas por nome em ordem ascendente
    List<Categoria> findByOrderByNomeAsc();
}
