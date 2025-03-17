package com.joia.repository;

import com.joia.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByDataPedido(Date dataPedido);

    List<Pedido> findByDataPedidoBetween(Date startDate, Date endDate);

    List<Pedido> findByClienteId(Long clienteId);

    List<Pedido> findAllByOrderByDataPedidoDesc();

    List<Pedido> findByJoiasIsNotEmpty();

    List<Pedido> findByJoiasIsEmpty();
}
