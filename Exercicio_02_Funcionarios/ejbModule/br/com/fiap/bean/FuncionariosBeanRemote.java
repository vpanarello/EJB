package br.com.fiap.bean;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.entity.Funcionario;

@Remote
public interface FuncionariosBeanRemote {
	void add(Funcionario funcionario);
	List<Funcionario> getAll();
	
	public double CalcularIrpf(double salario);
}
