package br.unit.pa.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Funcionario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long matricula;
	private String nome;
	private String email;
	private Date dataDeCadastro;
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(long matricula, String nome, String email) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.dataDeCadastro = new Date();
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
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

	public Date getData() {
		return dataDeCadastro;
	}

	public void setData(Date data) {
		this.dataDeCadastro = data;
	}

	@Override
	public String toString() {
		return "{" + 
			" matricula= '" + getMatricula() + "'" +
			", nome= '" + getNome() + "'" +
			", email= '" + getEmail() + "'" +
			", dataDeCadastro= '" + getData()  + "'" +
			"}";
	}
}
