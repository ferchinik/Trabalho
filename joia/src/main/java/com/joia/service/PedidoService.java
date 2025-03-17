package com.joia.service;

import com.joia.entity.Pedido;
import com.joia.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public String save(@Valid Pedido pedidoEntity) {
        validarPedido(pedidoEntity);
        pedidoRepository.save(pedidoEntity);
        return "Pedido salvo com sucesso!";
    }

    public Pedido findById(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado!"));
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public String update(@Valid Pedido pedidoEntity, Long id) {
        Pedido pedidoEntityExistente = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado!"));

        validarPedido(pedidoEntity);

        pedidoEntityExistente.setDataPedido(pedidoEntity.getDataPedido());
        pedidoEntityExistente.setCliente(pedidoEntity.getCliente());
        pedidoEntityExistente.setJoias(pedidoEntity.getJoias());

        pedidoRepository.save(pedidoEntityExistente);
        return "Pedido atualizado com sucesso!";
    }

    public String delete(Long id) {
        pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado!"));
        pedidoRepository.deleteById(id);
        return "Pedido deletado com sucesso!";
    }

    private void validarPedido(Pedido pedidoEntity) {
        if (pedidoEntity.getDataPedido() == null) {
            throw new IllegalArgumentException("A data do pedido não pode ser nula!");
        }

        if (pedidoEntity.getCliente() == null) {
            throw new IllegalArgumentException("O cliente do pedido não pode ser nulo!");
        }

        if (pedidoEntity.getJoias() == null || pedidoEntity.getJoias().isEmpty()) {
            throw new IllegalArgumentException("O pedido deve conter pelo menos uma joia!");
        }
    }
}
