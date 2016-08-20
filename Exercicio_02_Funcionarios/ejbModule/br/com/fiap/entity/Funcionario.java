package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="funcionarios", schema="funcionariossejb")
public class Funcionario implements Serializable{
	@Id	
	@Column(name="cpf")
	private String cpf;
	@Column(name="nome")
	private String nome;
	@Column(name="cargo")
	private String cargo;
	@Column(name="salario")
	private Double salario;
	@Column(name="irpf")
	private Double irpf;
	@Column(name="inss")
	private Double inss;
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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Double getIrpf() {
		return irpf;
	}
	public void setIrpf(Double irpf) {
		this.irpf = irpf;
	}
	public Double getInss() {
		return inss;
	}
	public void setInss(Double inss) {
		this.inss = inss;
	}
}
