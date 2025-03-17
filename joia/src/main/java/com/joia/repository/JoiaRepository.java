package com.joia.repository;

import com.joia.entity.Joia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JoiaRepository extends JpaRepository<Joia, Long> {


    List<Joia> findByNomeContainingIgnoreCase(String nome);

    List<Joia> findByTipoMetalIgnoreCase(String tipoMetal);

    List<Joia> findByCategoriaId(Long categoriaId);


    List<Joia> findAllByOrderByNomeAsc();

    List<Joia> findByFornecedorId(Long fornecedorId);

    List<Joia> findByPrecoGreaterThan(Double preco);
}
