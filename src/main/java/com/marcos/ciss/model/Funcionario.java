package com.marcos.ciss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "nome")
    @Size(min = 2, max = 30)
    private String nome;

    @Getter
    @Setter
    @Column(name = "sobrenome")
    @Size(min = 2, max = 50)
    private String sobrenome;

    @Getter
    @Setter
    @Size(min = 2, max = 50)
    @Column(name = "email")
    @Email(message = "E-mail incorreto")
    private String email;

    @Getter
    @Setter
    @Size(min = 11, max = 20)
    @Column(name = "numero_nis")
    @Pattern(regexp = "[0-9]+", message = "Formato invalido, utilize apenas numeros para o atributo Numero Nis")
    private String numeroNis;

    /**
     * Dos atributos do Funcionário - Nome (Entre 2 e 30 caracteres) -
     * Sobrenome(Entre 2 e 50 caracteres) - e-mail (Validar e-mail) - Número do NIS
     * (PIS) (Somente números)
     * 
     * Das funcionalidades (Utilizando APIs): - Inserção de um Funcionário -
     * Exclusão de um Funcionário - Atualização de um Funcionário
     * 
     * - Listagem de um Funcionário
     * 
     * 
     * Do desenvolvimento: - Utilize o padrão de desenvolvimento que acredita ser o
     * mais correto.
     * 
     * Da entrega dos fontes: - Faça a entrega dos fontes da forma que acredita ser
     * a mais correta.
     */

}
