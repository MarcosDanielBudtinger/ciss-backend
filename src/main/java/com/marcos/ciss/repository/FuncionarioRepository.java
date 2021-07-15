package com.marcos.ciss.repository;

import com.marcos.ciss.model.Funcionario;
import com.marcos.ciss.repository.funcionario.FuncionarioRepositoryQuery;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>, FuncionarioRepositoryQuery {

}
