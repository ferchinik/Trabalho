package com.joia.repository;

import com.joia.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // consulta para encontrar clientes por parte do nome (case-insensitive)
    List<Cliente> findByNomeContainingIgnoreCase(String nome);

    // consulta personalizada usando @Query para buscar cliente por email
    @Query("SELECT c FROM Cliente c WHERE c.email = :email")
    Cliente findByEmail(String email);

    // consulta para buscar clientes que têm pelo menos um pedido associado
    @Query("SELECT c FROM Cliente c WHERE c.pedidos IS NOT EMPTY")
    List<Cliente> findClientesComPedidos();

    // consulta para encontrar clientes ordenados pelo nome em ordem decrescente
    List<Cliente> findByOrderByNomeDesc();
}
