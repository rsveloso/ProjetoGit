package br.com.cast.castapi.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.castapi.dao.PessoaDao;
import br.com.cast.castapi.dto.PessoaDTO;
import br.com.cast.castapi.model.Pessoa;
import br.com.cast.castapi.repositary.PessoaRepository;

@Service
public class PessoaBusiness {
	
	@Autowired
	private PessoaRepository repositorio; // sao do spring
	private PessoaDao dao;
	
	public PessoaBusiness() {
		dao = new PessoaDao();
	}

	
	public List<PessoaDTO> buscarTodas() {
		List<Pessoa> pessoas = repositorio.buscarTodos();
		List<PessoaDTO> dtos = new ArrayList<>();
		
		for (Pessoa pessoa : pessoas) {
			dtos.add(PessoaDTO.fromPessoa(pessoa));
		}
		
		return dtos;
	}

	@Transactional()
	public void salvar(PessoaDTO dto){
		Pessoa pessoa = new Pessoa();
		Pessoa.fromDTO(pessoa, dto);
		
		repositorio.inserir(pessoa);
	}
	

	public void alterar(String cpf, PessoaDTO pessoaDTO) throws Exception {
		Pessoa pessoa = dao.buscarPorCpf(cpf);
		Pessoa.fromDTO(pessoa, pessoaDTO);
		dao.alterar(pessoa);
		dao.fechar();
	}

	public void excluir(String cpf) throws Exception {
		Pessoa pessoa = dao.buscarPorCpf(cpf);
		dao.excluir(pessoa);
		dao.fechar();
	}

	public PessoaDTO buscarPorCpf(String cpf) {
		Pessoa pessoa = dao.buscarPorCpf(cpf);
		PessoaDTO dto = PessoaDTO.fromPessoa(pessoa);
		dao.fechar();
		return dto;
	}

}
