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
@Entity(name = "categorias")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da categoria não pode ser vazio.")
    @Column
    private String nome;

    @OneToMany(mappedBy = "categoria")
    @JsonIgnoreProperties({"joiaEntities", "categoria", "fornecedor","pedidos","joias","cliente","clientes"})
    private List<JoiaEntity> joiaEntities;
}
