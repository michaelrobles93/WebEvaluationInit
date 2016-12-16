package br.com.webevaluationinit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="habilidade")
public class Habilidade {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="{habilidade.nomeHabilidade.nulo)")
	@NotEmpty
	@Column(name="nome_habilidade", nullable = false)
	private String nomeHabilidade;
	
	@NotNull(message="{habilidade.descricao.nulo)")
	@NotEmpty
	@Column(name="descricao")
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeHabilidade() {
		return nomeHabilidade;
	}

	public void setNomeHabilidade(String nomeHabilidade) {
		this.nomeHabilidade = nomeHabilidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
