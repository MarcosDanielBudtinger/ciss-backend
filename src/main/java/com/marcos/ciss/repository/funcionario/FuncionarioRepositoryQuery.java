package com.marcos.ciss.repository.funcionario;

import com.marcos.ciss.model.Funcionario;
import com.marcos.ciss.repository.filter.FuncionarioFilter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FuncionarioRepositoryQuery {

    public Page<Funcionario> filtrar(FuncionarioFilter funcionarioFilter, Pageable pageable);
}
