package com.joia.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = "pedidos")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The order date cannot be null!")
    @Column
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties({"joiaEntities", "categoria", "fornecedor","pedidos","joias","cliente","clientes"})
    private ClienteEntity cliente;

    @ManyToMany
    @JoinTable(
            name = "pedido_joia",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "joia_id")
    )
    @JsonIgnoreProperties({"joiaEntities", "categoria", "fornecedor","pedidos","joias","cliente","clientes"})
    private List<JoiaEntity> joias;
}
