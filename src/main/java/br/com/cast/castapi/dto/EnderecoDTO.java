package br.com.cast.castapi.dto;

import br.com.cast.castapi.model.Endereco;

public class EnderecoDTO {

	private Integer id;
	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public static EnderecoDTO fromEndereco(Endereco endereco) {
		EnderecoDTO dto = new EnderecoDTO();

		dto.setId(endereco.getId());
		dto.setBairro(endereco.getBairro());
		dto.setCep(endereco.getCep());
		dto.setCidade(endereco.getCidade());
		dto.setComplemento(endereco.getComplemento());
		dto.setLogradouro(endereco.getLogradouro());
		dto.setNumero(endereco.getNumero());
		dto.setUf(endereco.getUf());

		return dto;
	}

}
