package com.joia.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = "fornecedores")
public class FornecedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode ser vazio.")
    @Column
    private String name;

    @OneToMany(mappedBy = "fornecedor")
    @JsonIgnoreProperties({"joiaEntities", "categoria", "fornecedor","pedidos","joias","cliente","clientes"})
    private List<JoiaEntity> joias;
}

