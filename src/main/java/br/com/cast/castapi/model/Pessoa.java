package br.com.cast.castapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.cast.castapi.dto.PessoaDTO;

@Table(name="pessoa", schema="endereco")
@Entity
public class Pessoa {

	@Id
	private String cpf;
	@Column(name="nome", length=200, nullable=false)
	private String nome;
	@Column(name="email", length=100, nullable=false)
	private String email;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_endereco", 
				foreignKey=@ForeignKey(name="fk_pessoa_endereco"))
	private Endereco endereco;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public static void fromDTO(Pessoa pessoa, PessoaDTO pessoaDTO) {
		Endereco endereco = new Endereco();
		Endereco.fromDTO(endereco, pessoaDTO.getEndereco());
		
		pessoa.setCpf(pessoaDTO.getCpf());
		pessoa.setEmail(pessoaDTO.getEmail());
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setEndereco(endereco);
	}

}
