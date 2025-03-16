package com.joia.repository;

import com.joia.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    // consulta para encontrar fornecedores por parte do nome
    List<Fornecedor> findByNameContainingIgnoreCase(String name);

    // consulta para encontrar fornecedores que têm joias associadas
    List<Fornecedor> findByJoiasIsNotEmpty();

    //consulta para encontrar fornecedores ordenados pelo nome em ordem ascendente
    List<Fornecedor> findByOrderByNameAsc();
}
