package br.com.cast.castapi.dto;

import br.com.cast.castapi.model.Pessoa;

public class PessoaDTO {

	private String nome;
	private String cpf;
	private String email;

	private EnderecoDTO endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public static PessoaDTO fromPessoa(Pessoa pessoa) {
		PessoaDTO dto = new PessoaDTO();
		dto.setCpf(pessoa.getCpf());
		dto.setNome(pessoa.getNome());
		dto.setEmail(pessoa.getEmail());
		
		EnderecoDTO enderecoDTO = EnderecoDTO
				.fromEndereco(pessoa.getEndereco());
		
		dto.setEndereco(enderecoDTO);
		
		return dto;
	}

}
