package com.joia.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = "clientes")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do cliente não pode ser vazio.")
    @Size(max = 100, message = "O nome do cliente não pode exceder 100 caracteres.")
    @Column
    private String nome;

    @NotBlank(message = "O email do cliente não pode ser vazio.")
    @Email(message = "O email deve ser válido.")
    @Size(max = 100, message = "O email do cliente não pode exceder 100 caracteres.")
    @Column
    private String email;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnoreProperties({"joiaEntities", "categoria", "fornecedor","pedidos","joias","cliente","clientes"})
    private List<PedidoEntity> pedidos;
}

