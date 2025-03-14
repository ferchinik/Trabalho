package com.joia.service;

import com.joia.entity.PedidoEntity;
import com.joia.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public String save(PedidoEntity pedidoEntity) {
        pedidoRepository.save(pedidoEntity);
        return "Pedido salvo com sucesso!";
    }

    public PedidoEntity findById(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado!"));
    }

    public List<PedidoEntity> findAll() {
        return pedidoRepository.findAll();
    }

    public String update(PedidoEntity pedidoEntity, Long id) {
        PedidoEntity pedidoEntityExistente = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado!"));
        pedidoEntityExistente.setOrderDate(pedidoEntity.getOrderDate());
        pedidoEntityExistente.setCliente(pedidoEntity.getCliente());
        pedidoEntityExistente.setJoias(pedidoEntity.getJoias());
        pedidoRepository.save(pedidoEntityExistente);
        return "Pedido atualizado com sucesso!";
    }

    public String delete(Long id) {
        pedidoRepository.deleteById(id);
        return "Pedido deletado com sucesso!";
    }
}

