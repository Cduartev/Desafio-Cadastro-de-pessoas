package com.example.cadastro.service;

import com.example.cadastro.model.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class PessoaService {

    @PersistenceContext
    private EntityManager em;

    public void salvar(Pessoa pessoa) {
        try {
            if (pessoa.getId() == null) {
                em.persist(pessoa);
            } else {
                em.merge(pessoa);
            }
            em.flush();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar pessoa", e);
        }
    }

    public void excluir(Long id) {
        try {
            Pessoa p = em.find(Pessoa.class, id);
            if (p != null) {
                em.remove(p);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir pessoa com id " + id, e);
        }
    }

    public Pessoa buscar(Long id) {
        try {
            return em.createQuery(
                            "SELECT DISTINCT p FROM Pessoa p LEFT JOIN FETCH p.enderecos WHERE p.id = :id", Pessoa.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar pessoa com id " + id, e);
        }
    }

    public List<Pessoa> listar() {
        try {
            return em.createQuery(
                            "SELECT DISTINCT p FROM Pessoa p LEFT JOIN FETCH p.enderecos ORDER BY p.nome", Pessoa.class)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar pessoas", e);
        }
    }
}