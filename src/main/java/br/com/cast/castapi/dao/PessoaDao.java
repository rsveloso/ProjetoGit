package br.com.cast.castapi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.castapi.model.Pessoa;

public class PessoaDao {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public PessoaDao() {
		emf = Persistence.createEntityManagerFactory("puEndereco");
		em = emf.createEntityManager();
	}
	
	public void inserir(Pessoa pessoa) {
		try {
			beginTransaction();
			em.persist(pessoa);
			commit();
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public void alterar(Pessoa pessoa) {
		try {
			beginTransaction();
			em.merge(pessoa);
			commit();
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public void excluir(Pessoa pessoa) {
		try {
			beginTransaction();
			em.remove(pessoa);
			commit();
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
			throw e;
		}
	}

	
	public Pessoa buscarPorCpf(String cpf) {
		return em.find(Pessoa.class, cpf);
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> buscarTodos() {
		String qlString = "SELECT p " + 
	                      "FROM " + Pessoa.class.getName() + " p " +  
						  "	  join fetch p.endereco ";
		
		Query query = em.createQuery(qlString);
		
		return query.getResultList();
	}
	
	public void fechar() {
		em.close();
		emf.close();
	}
	
	private void rollback() {
		em.getTransaction().rollback();
	}

	private void commit() {
		em.getTransaction().commit();
	}

	private void beginTransaction() {
		em.getTransaction().begin();
	}
	
}
