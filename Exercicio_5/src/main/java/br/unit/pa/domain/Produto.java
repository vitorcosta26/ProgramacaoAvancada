package br.unit.pa.domain;

import java.time.LocalDate;

public class Produto {
	
	private long id;
    private String nome;
    private String categoria;
    private LocalDate dataCadastro;
	
    public Produto() {
		super();
	}

	public Produto(long id, String nome, String categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.setDataCadastro(LocalDate.now());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "{" +
	            " id='" + getId() + "'" +
	            ", nome='" + getNome() + "'" +
	            ", categoria='" + getCategoria() + "'" +
	            ", dataCadastro='" + getDataCadastro() + "'" +
	            "}";
	}
}
