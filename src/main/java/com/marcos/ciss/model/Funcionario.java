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

}
