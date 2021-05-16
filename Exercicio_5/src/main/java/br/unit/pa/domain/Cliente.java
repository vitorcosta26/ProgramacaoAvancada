package br.unit.pa.domain;

import java.time.LocalDate;

public class Cliente {
	
	private long id;
    private String nome;
    private String endereco;
    private LocalDate dataCadastro;
	
    public Cliente() {
		super();
	}

	public Cliente(long id, String nome, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
	            " id='" + this.getId() + "'" +
	            ", nome='" + this.getNome() + "'" +
	            ", endereco='" + this.getEndereco() + "'" +
	            ", dataCadastro='" + this.getDataCadastro() + "'" +
	            "}";
	}
}
