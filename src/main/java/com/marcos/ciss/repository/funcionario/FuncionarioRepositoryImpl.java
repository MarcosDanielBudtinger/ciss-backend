package com.marcos.ciss.repository.funcionario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.marcos.ciss.model.Funcionario;
import com.marcos.ciss.repository.filter.FuncionarioFilter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class FuncionarioRepositoryImpl implements FuncionarioRepositoryQuery {

    @PersistenceContext
    EntityManager manager;

    @Override
    public Page<Funcionario> filtrar(FuncionarioFilter funcionarioFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Funcionario> criteria = builder.createQuery(Funcionario.class);
        Root<Funcionario> root = criteria.from(Funcionario.class);

        // Restrições
        Predicate[] predicates = inserirRestricoes(funcionarioFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Funcionario> query = manager.createQuery(criteria);

        inserirRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, query.getResultList().size());
    }

    private void inserirRestricoesDePaginacao(TypedQuery<Funcionario> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistrosPorPagina);

    }

    private Predicate[] inserirRestricoes(FuncionarioFilter funcionarioFilter, CriteriaBuilder builder,
            Root<Funcionario> root) {
        List<Predicate> predicates = new ArrayList<>();
        if (funcionarioFilter.getNome() != null) {
            predicates.add(builder.like(builder.lower(root.get("nome")),
                    "%" + funcionarioFilter.getNome().toLowerCase() + "%"));
        }

        if (funcionarioFilter.getSobrenome() != null) {
            predicates.add(builder.like(builder.lower(root.get("sobrenome")),
                    "%" + funcionarioFilter.getSobrenome().toLowerCase() + "%"));
        }

        if (funcionarioFilter.getEmail() != null) {
            predicates.add(builder.like(builder.lower(root.get("email")),
                    "%" + funcionarioFilter.getEmail().toLowerCase() + "%"));
        }

        if (funcionarioFilter.getNumeroNis() != null) {
            predicates.add(builder.like(builder.lower(root.get("numeroNis")),
                    "%" + funcionarioFilter.getNumeroNis().toLowerCase() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
