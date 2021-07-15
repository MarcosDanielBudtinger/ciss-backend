package com.marcos.ciss.service;

import com.marcos.ciss.model.Funcionario;
import com.marcos.ciss.repository.FuncionarioRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario atualizar(Long id, Funcionario funcionario) {
        Funcionario funcionarioSalvo = buscarFuncionarioPeloId(id);
        BeanUtils.copyProperties(funcionario, funcionarioSalvo, "id");
        return funcionarioRepository.save(funcionarioSalvo);
    }

    private Funcionario buscarFuncionarioPeloId(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        return funcionario;
    }

}