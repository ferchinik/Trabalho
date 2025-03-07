package com.joia.repository;

import com.joia.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    List<ClienteEntity> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT c FROM clientes c WHERE c.email = :email")
    ClienteEntity findByEmail(String email);
}
