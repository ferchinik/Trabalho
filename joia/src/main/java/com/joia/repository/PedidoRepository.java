package com.joia.repository;

import com.joia.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // consulta para buscar pedidos por data específica
    List<Pedido> findByOrderDate(Date orderDate);

    // consulta para buscar pedidos em um intervalo de datas
    List<Pedido> findByOrderDateBetween(Date startDate, Date endDate);

    // consulta  para buscar pedidos de um cliente específico
    List<Pedido> findByClienteId(Long clienteId);

    // consulta para buscar pedidos ordenados pela data em ordem decrescente
    List<Pedido> findByOrderByOrderDateDesc();
}
