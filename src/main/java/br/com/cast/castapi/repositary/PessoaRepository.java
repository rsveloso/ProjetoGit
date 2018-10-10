package br.com.cast.castapi.repositary;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cast.castapi.dto.PessoaDTO;
import br.com.cast.castapi.model.Pessoa;

@Repository
public class PessoaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Pessoa> buscarTodas() {
		return entityManager.createQuery(
				  "SELECT p "
				+ "FROM Pessoa p "
				+ "join fetch p.endereco")
			.getResultList();
	}

	public void inserir(Pessoa pessoa) {
		entityManager.persist(pessoa);
	}

/*	public void alterar(String cpf, PessoaDTO pessoaDTO) {
		entityManager.merge(pessoa);
		Pessoa pessoa = dao.buscarPorCpf(cpf);
		Pessoa.fromDTO(pessoa, pessoaDTO);
		dao.alterar(pessoa);
		dao.fechar();
	}*/

/*	public void excluir(String cpf) throws Exception {
		Pessoa pessoa = dao.buscarPorCpf(cpf);
		dao.excluir(pessoa);
		dao.fechar();
	}*/

/*	public PessoaDTO buscarPorCpf(String cpf) {
		Pessoa pessoa = dao.buscarPorCpf(cpf);
		PessoaDTO dto = PessoaDTO.fromPessoa(pessoa);
		dao.fechar();
		return dto;
	}*/
//	@Override
/*	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}*/
	
}
