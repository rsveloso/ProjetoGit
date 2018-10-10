package br.com.cast.castapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.cast.castapi.dto.EnderecoDTO;

@Entity
@Table(name = "endereco", schema = "endereco")
public class Endereco {

	@Id
	@SequenceGenerator(sequenceName = "seq_endereco_id", name = "gerador_end_seq", allocationSize = 1, schema = "endereco")
	@GeneratedValue(generator = "seq_endereco_id", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="cep", length=8, nullable=false)
	private String cep;
	
	@Column(name="logradouro", length=200, nullable=false)
	private String logradouro;
	
	@Column(name="numero", length=5, nullable=true)
	private String numero;
	
	@Column(name="complemento", length=20, nullable=true)
	private String complemento;
	
	@Column(name="bairro", length=200, nullable=false)
	private String bairro;
	
	@Column(name="cidade", length=200, nullable=false)
	private String cidade;
	
	@Column(name="uf", length=2, nullable=false)
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

	public static void fromDTO(Endereco endereco, 
			EnderecoDTO enderecoDTO) {
		endereco.setId(enderecoDTO.getId());
		endereco.setCep(enderecoDTO.getCep());
		endereco.setBairro(enderecoDTO.getBairro());
		endereco.setCidade(enderecoDTO.getCidade());
		endereco.setComplemento(enderecoDTO.getComplemento());
		endereco.setLogradouro(enderecoDTO.getLogradouro());
		endereco.setNumero(enderecoDTO.getNumero());
		endereco.setUf(enderecoDTO.getUf());
		
	}

}
