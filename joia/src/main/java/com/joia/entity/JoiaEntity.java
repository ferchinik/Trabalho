package com.joia.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = "joias")
public class JoiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da joia não pode ser vazio!")
    @Column
    private String nome;

    @NotBlank(message = "A descrição da joia não pode ser vazia!")
    @Column
    private String descricao;

    @NotBlank(message = "O tipo de metal não pode ser vazio!")
    @Column
    private String tipoMetal;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties({"joais", "categorias", "fornecedores", "clientes", "pedidos"})
    private CategoriaEntity categoria;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    @JsonIgnoreProperties({"joais", "categorias", "fornecedores", "clientes", "pedidos"})
    private FornecedorEntity fornecedor;
}

